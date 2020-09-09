const express = require('express')
const app = express();
require('dotenv').config();
const PORT = process.env.PORT || 5000;
const routerComp = require('./backend/app');
const mongoose = require('mongoose');

app.use('/',routerComp)

mongoose.connect(process.env.MONGO_KEY,{useNewUrlParser:true}).then(ele=>{
  app.listen(PORT,()=>{
    console.log(`Listening on Port ${PORT}`)
  })
})


