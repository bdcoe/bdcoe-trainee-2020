const express = require('express');
const Register = require('./models/register');
const router = express.Router();
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const checkauth = require('./checkauth');
const TechSupportModel = require('./models/techsupport');
const ProblemModel = require('./models/problem');


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
router.put('/register',checkauth,async (req,res)=>{
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId'];
  console.log(userId,req.body)
  Register.updateOne({_id:userId},{fname:req.body.fname,lname:req.body.lname,phone:req.body.phone}).then(ele=>{
    console.log('yes',ele)
  })
})
router.get('/dashboard', checkauth, (req, res) => {
  res.status(200).json({ message: 'yeah' });
});
router.get('/profile', checkauth, async (req, res) => {
  const token = req.headers.authorization.split(' ')[1];
  var userId = jwt.decode(token)['userId']
  let user = await Register.findOne({ _id: userId });
  delete user['password']
  console.log(user)
  res.status(200).json(user)
})
router.post('/techsupport', (req, res) => {
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
router.post('/addproblem',checkauth,async (req,res)=>{
  const AddNewProblem = new ProblemModel({
    tech:req.body.tech,
    title:req.body.title,
    explain:req.body.explain,
    code:req.body.code
  })
  AddNewProblem.save().then(ele=>{
    return res.status(200).json({message:'saved'})
  }).catch(error=>{
    return res.status(401).json({message:error})
  })
})
module.exports = router;
