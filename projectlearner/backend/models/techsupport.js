const mongoose = require('mongoose')
const TechSupportSchema = mongoose.Schema({
  title:{
    type:String,
    required:false
  },
  subject:{
    type:String,
    required:false
  },
  content:{
    type:String,
    required:false
  }
});

const TechSupportModel = mongoose.model('techsupport',TechSupportSchema)
module.exports = TechSupportModel
