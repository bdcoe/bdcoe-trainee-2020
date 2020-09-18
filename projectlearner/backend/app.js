const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const TechSupportModel = require('./models/techsupport');
const ProblemModel = require('./models/problem');
const SolutionModel = require('./models/solution');
const Register = require('./models/register');
const { headers, Score, checkauth } = require('./functions/func');
const multer = require('multer');
const MIME_TYPE_MAP = {
  'image/png': 'png',
  'image/jpeg': 'jpg',
  'image/jpg': 'jpg'
}
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    const isValid=MIME_TYPE_MAP[file.mimetype];
    let error = new Error('Invalid mimeType');
    if(isValid){
      error=null
    }
    cb(error, 'backend/images');
  },
  filename: (req, file, cb) => {
    const name = file.originalname.toLowerCase().split(' ').join('-')
    const ext = MIME_TYPE_MAP[file.mimetype];
    cb(name+'-'+Date.now()+'.'+ext);
  }
})
router.post('/register', async (req, res) => {
  if (req.body.fname == '' || req.body.lname == '' || req.body.email == '' || req.body.phone == null || req.body.password == '') {
    return res.status(401).json({ message: 'Invalid Input' })
  }
  var ele = await Register.findOne({ email: req.body.email.toLowerCase() })
  if (ele != null) {
    return res.status(404).json({ message: 'User Already exist with same Email' })
  }
  var t = bcrypt.hashSync(req.body.password.toString(), 10);
  const newRegister = new Register({
    fname: req.body.fname,
    lname: req.body.lname,
    email: req.body.email.toLowerCase(),
    phone: req.body.phone,
    password: t,
  });
  newRegister.save().then((ele) => {
    return res.status(201).json({
      message: 'registration successful',
    });
  });
});
router.put('/register', checkauth,multer({storage:storage}).single('image'), async (req, res) => {
  var userId = headers(req, res);
  await Register.updateOne({ _id: userId }, { fname: req.body.fname, lname: req.body.lname, phone: req.body.phone, language: req.body.language })
  return res.status(200).json({ message: 'Done' })
});
router.get('/dashboard', checkauth, (req, res) => {
  res.status(200).json({ message: 'yeah' });
});
router.get('/profile', checkauth, async (req, res) => {
  var userId = headers(req, res);
  let user = await Register.findOne({ _id: userId });
  // let count = await ProblemModel.find({ owner: userId }).count()
  // delete user['password']
  // user.myquestion = count;
  // console.log(user)
  res.status(200).json(user)
});
router.get('/solution', checkauth, async (req, res) => {
  var userId = headers(req, res);
  var solution = await SolutionModel.find({ owner: userId });
  var final = []
  solution.forEach(async ele => {
    var problem = await ProblemModel.findOne({ _id: ele['Qid'] })
    final.push({ problem: problem, solution: ele })
  })
  return res.status(200).json({ message: final })

})
router.post('/techsupport', checkauth, (req, res) => {
  const NewTechSupport = new TechSupportModel({
    title: req.body.title,
    subject: req.body.subject,
    content: req.body.content
  });
  NewTechSupport.save()
    .then((ele) => {
      return res.status(200).json({ message: 'Issue Registered' });
    })
    .catch((error) => {
      return res.status(404).json({ message: error });
    });
});
router.post('/addproblem', checkauth, async (req, res) => {
  console.log('add problem called')
  var userId = headers(req, res);
  var t = await ProblemModel.find({ owner: userId }).count();
  var date = new Date();
  const AddNewProblem = new ProblemModel({
    tech: req.body.tech,
    title: req.body.title,
    explain: req.body.explain,
    code: req.body.code,
    owner: userId,
    date: date
  })
  AddNewProblem.save().then(async ele => {
    await Register.updateOne({ _id: userId }, { myquestion: ++t })
    return res.status(200).json({ message: 'saved' })
  }).catch(error => {
    return res.status(401).json({ message: error })
  })
});
router.get('/addproblem', checkauth, async (req, res) => {

  var problems = await ProblemModel.find();
  problems = problems.map(ele => {
    return ele['tech']
  })
  var lang = await Register.find();
  lang = lang.map(ele => {
    return ele['language']
  })
  lang.forEach(ele => {
    problems.push(ele)
  })
  return res.status(200).json({ message: problems })

})
router.get('/problem', checkauth, async (req, res) => {

  const token = req.headers.authorization.split(' ')[1];
  const userId = jwt.decode(token)['userId'];
  var problems = await ProblemModel.find({ owner: userId });
  return res.status(200).json({ problems: problems })
});
router.get('/allproblem', checkauth, async (req, res) => {
  var problems = await ProblemModel.find()
  return res.json({ 'message': problems })
})
router.post('/solution', checkauth, async (req, res) => {
  var userId = headers(req, res);
  var t = await Register.findOne({ _id: userId })
  var score = t['rating'];
  var d = await ProblemModel.findOne({ _id: req.body.Qid })
  var date = d['date']
  const NewSolution = new SolutionModel({
    solapp: req.body.solapp,
    sol: req.body.sol,
    Qid: req.body.QId,
    owner: userId
  })
  NewSolution.save().then(async ele => {
    var finalScore = Score(date, score)
    await Register.updateOne({ _id: userId }, { mysolution: t, rating: finalScore })
    return res.status(200).json({ 'message': 'Done' })
  })

})
router.get('/work', checkauth, async (req, res) => {
  var userId = headers(req, res);
  var user = await Register.findOne({ _id: userId });
  if (user['language'] == '') {
    return res.status(401).json({ message: 'Please set Your Tech' })
  }
  var exp = new RegExp(user['language'], 'ig');
  console.log(exp)
  var problem = await ProblemModel.find({ tech: exp });
  console.log(problem)
  return res.status(200).json({ message: problem })
})
router.get('/leaderboard', checkauth, async (req, res) => {
  var star = await Register.find().sort({ rating: -1 }).limit(5)
  return res.status(200).json({ 'message': star })
})
router.delete('/problem', async (req, res) => {

  const body = req.headers.body;
  await ProblemModel.deleteOne({ _id: body }).then(ele => {
    return res.status(200).json({ message: 'Deleted' })
  }).catch(error => {
    return res.status(401).json({ message: error })
  })

})
router.put('/problem', async (req, res) => {
  console.log(req.body)
  ProblemModel.updateOne({ _id: req.body.update }, {
    tech: req.body.tech,
    title: req.body.title,
    explain: req.body.explain,
    code: req.body.code
  }).then(ele => {
    return res.status(200).json({ message: 'Success' })
  }).catch(error => {
    return res.status(400).json({ message: error })
  })
})
router.post('/', async (req, res) => {
  const email = req.body.email;
  const password = req.body.password;
  if (email == null || password == null || email == '' || password == '') {
    return res.status(401).json({ message: 'Empty Email Or Password' })
  }
  var x = await Register.findOne({ email: email.toLowerCase() });
  if (x == null || x == undefined || x.length <= 0) {
    return res.status(401).json({ message: 'Invalid User Id' });
  } else {
    var t = bcrypt.compareSync(password.toString(), x['password']);
    if (!t) {
      return res.status(401).json({ message: 'Login failure' });
    }
    const token = jwt.sign(
      { email: x['email'], userId: x['_id'] },
      'This_Should_Be_Working',
      { expiresIn: '1h' }
    );
    res.status(200).json({ token: token });
  }
});

module.exports = router;
