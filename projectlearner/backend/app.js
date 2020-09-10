const express = require("express");
const Register = require("./models/register");
const router = express.Router();
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const checkauth = require("./checkauth");
router.post("/register", async (req, res) => {
  var t = bcrypt.hashSync(req.body.password.toString(), 10);
  const newRegister = new Register({
    name: req.body.name,
    email: req.body.email.toLowerCase(),
    phone: req.body.phone,
    password: t,
  });
  newRegister.save().then((ele) => {
    return res.status(201).json({
      message: "registration successful",
    });
  });
});
router.get("/dashboard", checkauth, (req, res) => {
  res.status(200).json({ message: "yeah" });
});

router.post("/", async (req, res) => {
  console.log(req.body);
  const email = req.body.email;
  const password = req.body.password;
  var x = await Register.findOne({ email: email.toLowerCase() });
  if (x == null || x == undefined || x.length <= 0) {
    console.log("Wrong Id");
    return res.status(401).json({ message: "Invalid User Id" });
  } else {
    var t = bcrypt.compareSync(password.toString(), x["password"]);
    if (!t) {
      return res.json({ message: "Login failure" });
    }
    const token = jwt.sign(
      { email: x["email"], userId: x["_id"] },
      "This_Should_Be_Working",
      { expiresIn: "1h" }
    );
    res.status(200).json({ token: token });
  }
});

module.exports = router;
