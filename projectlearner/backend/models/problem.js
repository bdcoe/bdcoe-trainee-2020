const mongoose = require('mongoose');
const ProblemSchema = mongoose.Schema({
    tech:{
        type:String,
        required:false
    },
    title:{
        type:String,
        required:false
    },
    explain:{
        type:String,
        required:false
    },
    code:{
        type:String,
        required:false
    },
    owner:{
        type:String,
        required:false
    },
    solution:{
        type:Array,
        required:false,
        default:[]
    },
    date:{
        type:Date,
        required:false,
        default:Date()
    }
})

const ProblemModel = mongoose.model('problem',ProblemSchema);
module.exports = ProblemModel