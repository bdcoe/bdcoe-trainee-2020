const jwt = require('jsonwebtoken');
module.exports={
 Score:(date, score)=>{
    var D = new Date();
    var date1 = D.getDate() * 24;
    var date2 = date.getDate() * 24;
    var time1 = D.getHours();
    var time2 = date.getHours();
    if ((date1 + time1) - (date2 + time2) == 0) {
        return score+120;
    } else if ((date1 + time1) - (date2 + time2) >= 1 && (date1 + time1) - (date2 + time2) <= 5) {
        return score+110;
    } else return score
},
headers:(req,res)=> {
    const token = req.headers.authorization.split(' ')[1];
    var userId = jwt.decode(token)['userId']
    return userId
},
checkauth:(req,res,next)=>{
    try{
      console.log('called auth',req.url)
      const token = req.headers.authorization.split(' ')[1];
      jwt.verify(token,"This_Should_Be_Working");
      next();
    }catch(error){
      console.log(error)
      return res.status(401).json({message:"Auth Failed"})
    }
  }
}