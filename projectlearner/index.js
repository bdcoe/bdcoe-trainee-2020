const express = require('express')
const app = express();
require('dotenv').config();
const PORT = process.env.PORT || 5000;
const routerComp = require('./backend/app');

app.use('/',routerComp)

console.log(`Listening on Port ${PORT}`)
app.listen(PORT)
