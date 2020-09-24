var mongoose = require('mongoose');

//page schema
var CategorySchema = mongoose.Schema({
   title: {
       type: String,
       required: true
   },
   slug: {
    type: String

}

});
var Category = module.exports = mongoose.model('Page',CategorySchema);
