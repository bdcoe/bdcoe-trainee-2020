const express = require('express');
const Register = require('./models/register');
const router = express.Router();
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const checkauth = require('./checkauth');
const TechSupportModel = require('./models/techsupport');
const ProblemModel = require('./models/problem');
const SolutionModel = require('./models/solution');

router.post('/register', async (req, res) => {
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
router.put('/register', checkauth, async (req, res) => {
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId'];
  console.log(userId, req.body)
  Register.updateOne({ _id: userId }, { fname: req.body.fname, lname: req.body.lname, phone: req.body.phone }).then(ele => {
    console.log('yes', ele)
  })
});
router.get('/dashboard', checkauth, (req, res) => {
  res.status(200).json({ message: 'yeah' });
});
router.get('/profile', checkauth, async (req, res) => {
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId']
  let user = await Register.findOne({ _id: userId });
  let count = await ProblemModel.find({ owner: userId }).count()
  delete user['password']
  user.myquestion = count;
  console.log(user)
  res.status(200).json(user)
});
router.get('/solution',checkauth,async (req,res)=>{
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId'];
  var solution = await SolutionModel.find({owner:userId});
  // solution = solution.map(ele=>{return ele['Qid']});
  // solution.forEach( async ele=>{
  //    var t=await ProblemModel.find({_id:ele});
  //    t.forEach(async )
  // })

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
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId']
  const AddNewProblem = new ProblemModel({
    tech: req.body.tech,
    title: req.body.title,
    explain: req.body.explain,
    code: req.body.code,
    owner: userId
  })
  AddNewProblem.save().then(ele => {
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
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId'];
  const NewSolution= new SolutionModel({
    solapp:req.body.solapp,
    sol:req.body.sol,
    Qid:req.body.QId,
    owner:userId
  })
  NewSolution.save().then(ele=>{
    return res.status(200).json({'message':'Done'})
  })
  
})
router.post('/', async (req, res) => {
  console.log(req.body);
  const email = req.body.email;
  const password = req.body.password;
  var x = await Register.findOne({ email: email.toLowerCase() });
  if (x == null || x == undefined || x.length <= 0) {
    console.log('Wrong Id');
    return res.status(401).json({ message: 'Invalid User Id' });
  } else {
    var t = bcrypt.compareSync(password.toString(), x['password']);
    if (!t) {
      return res.json({ message: 'Login failure' });
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
