var express = require('express');
var path = require('path');
var mongoose = require('mongoose');
var config = require('./config/database');
var bodyParser = require('body-parser');
var session = require('express-session');
let ejs = require('ejs');
var fileUpload = express('express-fileupload');


  
var expressMessages = require('express-messages');

//data connecting to db
mongoose.connect(config.database);

var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
  console.log('connected to SHOP-WEB-BDCOE'); 
});

var app = express();

//for engine
app.set('views',path.join(__dirname,'views'));
app.set('view engine', 'ejs');


//public folder

app.use(express.static(path.join(__dirname,'public')));

//set routes
var pages = require('./routes/pages.js');
var adminPages = require('./routes/admin_pages.js');
var adminCategories = require('./routes/admin_categories.js');
app.use('/admin/pages', adminPages);
app.use('/admin/categories', adminCategories);
app.use('/', pages);8

//set global errorrs variables
app.locals.errors = null;

//expree file middleware
app.use(fileUpload());

//body-parser setup

app.use(bodyParser.urlencoded({ extended: false }));
// parse application/json
app.use(bodyParser.json());

// express session middleware
app.use(session({
  secret: 'keyboard cat',
  resave: true,
  saveUninitialized: true,
  cookie: { secure: true }
}));




//express message
app.use(require('connect-flash')());
app.use(function (req, res, next) {
  res.locals.messages = require('express-messages')(req, res);
  next();
});


//set routes

var pages = require('./routes/pages.js');
var adminPages = require('./routes/admin_pages.js');
var adminCategories = require('./routes/admin_categories.js');
var adminProduct = require('./routes/admin_products.js');
app.use ('/layouts/pages', adminPages);
app.use ('/admin/categories', adminCategories);
app.use ('/admin/products', adminProducts);
app.use ('/', pages);


//server
var port = 3000;
app.listen(port,function(){
    console.log("nitin server on port 3000");
});
