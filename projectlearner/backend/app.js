const express = require('express')
const router = express.Router();

router.use('/',(req,res)=>{
  return res.json({"end":"yes"})
})



module.exports = router
