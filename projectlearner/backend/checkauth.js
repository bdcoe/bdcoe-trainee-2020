const jwt = require('jsonwebtoken')

module.exports = (req,res,next)=>{
  try{
    const token = req.headers.authorization.split(' ')[1];
    jwt.verify(token,"This_Should_Be_Working")
    next();
  }catch(error){
    console.log(error)
    return res.status(401).json({message:"Auth Failed"})
  }

}
