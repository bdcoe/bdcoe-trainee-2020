const express = require('express')
const app = express();
require('dotenv').config();
const PORT = process.env.PORT || 5000;
const routerComp = require('./backend/app');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cron = require('node-cron');
const fetch = require('node-fetch');
const Bluebird = require('bluebird');
fetch.Promise = Bluebird;
const path = require('path')
const Register = require('./backend/models/register');
const ProblemModel = require('./backend/models/problem');
const SolutionModel = require('./backend/models/solution');
const TechSupportModel = require('./backend/models/techsupport')

cron.schedule('0 23 * * *',async()=>{
  var mapper = [Register,ProblemModel,SolutionModel,TechSupportModel]
  for(let map of mapper){
    var body =  await map.find();
    fetch('https://boiling-river-94988.herokuapp.com/upload', {
      method:'Post',
      body:body,
      headers:{'Content-Type':'application/json'}
    })
    .then(ele=>{
      console.log('SUVVESS')
    })
  }

})
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use('/image',express.static(path.join('backend/image')))

app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", '*');
  res.setHeader('Access-Control-Allow-Headers',
    'Origin,X-Requested-With,Content-Type,Accept,Authorization,Body');
  res.setHeader('Access-Control-Allow-Methods',
    'GET,PUT,POST,PATCH,DELETE,OPTIONS')
  next();
})
cron.schedule("* * 28 * *", async () => {
  await Register.updateMany({ rating: { $gte: 0 } }, { rating: 0 })
})

app.use('/', routerComp)

mongoose.connect(process.env.MONGO_KEY, { useNewUrlParser: true }).then(ele => {
  app.listen(PORT, () => {
    console.log(`Listening on Port ${PORT}`)
  })
})


