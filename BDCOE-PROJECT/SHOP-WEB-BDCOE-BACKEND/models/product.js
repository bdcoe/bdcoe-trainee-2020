var mongoose = require('mongoose');

//page schema
var ProductSchema = mongoose.Schema({
   title: {
       type: String,
       required: true
}

});
var Page = module.exports = mongoose.model('Product',ProductSchema);
