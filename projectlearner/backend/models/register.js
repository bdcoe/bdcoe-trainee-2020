const mongoose = require("mongoose");
const registerSchema = mongoose.Schema({
  name: {
    type: String,
    required: false,
  },
  email: {
    type: String,
    required: false,
  },
  password: {
    type: String,
    required: false,
  },
  phone: {
    type: Number,
    required: false,
  },
});
var Register = mongoose.model("register", registerSchema);
module.exports = Register;
