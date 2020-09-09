const express = require('express');
const Register = require('./models/register');
const router = express.Router();

router.post('/',async(req,res)=>{
  const newRegister = new Register({
    name:req.body.name,
    email:req.body.email,
    phone:req.body.phone,
    password:req.body.password
  })
  newRegister.save().then(ele=>{
    return res.status(201).json({
      message:"registration successful"
    }).catch(errpr=>{
      return res.status(400).json({message:"resgistration failed Please Contact to Technical department"})
    })
  })
})



module.exports = router
