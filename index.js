const express = require('express')
const app = express();
require('dotenv').config();
const PORT = process.env.PORT || 5000;

app.get('/', (req, res, next) => {
    return res.json({ "Body": "Yes" })
})
console.log(`Listening on Port ${PORT}`)
app.listen(PORT)