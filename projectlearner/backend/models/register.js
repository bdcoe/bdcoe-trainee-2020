const mongoose = require("mongoose");
const registerSchema = mongoose.Schema({
  fname: {
    type: String,
    required: false,
  },
  lname:{
    type:String,
    required:false
  }
  ,
  email: {
    type: String,
    required: false,
  },
  password: {
    type: String,
    required: false,
  },
  phone: {
    type: Number,
    required: false,
  },
  myquestion:{
    type:Number,
    required:true,
    default:0
  },
  mysolution:{
    type:Number,
    required:true,
    default:0
  },
  language:{
    type:String,
    required:false,
    default:''
  }
});
var Register = mongoose.model("register", registerSchema);
module.exports = Register;
