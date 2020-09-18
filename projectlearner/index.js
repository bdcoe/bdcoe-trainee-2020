const express = require('express')
const app = express();
require('dotenv').config();
const PORT = process.env.PORT || 5000;
const routerComp = require('./backend/app');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cron = require('node-cron');
const Register = require('./backend/models/register');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
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


