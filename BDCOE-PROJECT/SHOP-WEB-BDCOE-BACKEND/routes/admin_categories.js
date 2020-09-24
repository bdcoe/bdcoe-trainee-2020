var express = require('express');
var router = express.Router();

//get category model
var Category = require('../models/category');


//category index pages
router.get('/',function(req,res){
   Category.find(function(arr, categories){
    if (err) return console.log(err); 
    res.render('admin/categories',{
        categories: categories
    }); 
   });
}); 

//get add category


router.get('/add-page', function(req, res){
    
    var title = "";
    var slug = "";
    var content = "";

    res.render('admin/add_page',{
       title: title,
       slug: slug,
       content: content 
    });
});

// post add category

router.post('/add-category', function(req, res){
    req.checkBody('title','Title must have a value.').notEmpty();

    var title = req.body.title;
    var slug = title.replace(/\s+/g, '-').toLowerCase();

     var errors = req.validationErrors();
    if (errors) {
        res.render('admin/add_category',{
            errors: errors,
            title: title
         });
     } else {
         Category.findOne({slug: slug}, function(err, category) {
          if (page) {
            req.flash('danger','category exist,choose another.');
            res.render('admin/add_category', {
                title: title
             });
        }else {
            var category = new Category({
                title: title,
                slug: slug
            });
            category.save(function(err){
                if (err) return console.log(err);
                req.flash('success','Category added');
                res.redirect('/admin/categories');
            });
        }
         });
     }
   
});




//edit page

 
router.get('/edit-category/:id', function(req, res) {
    Category.findOne({id: req.params.id}, function(err, category){
   if (err) 
      return console.log(err);
    
   
    res.render('admin/edit_category',{
       title: category.title,
       id: category._id
    });
});
});

 //post edit category
 router.post('/edit-category/:id', function(req, res){
    req.checkBody('title','Title must have a value.').notEmpty();

    var title = req.body.title;
    var slug = title.replace(/\s+/g, '-').toLowerCase();
     var id = req.params.id;
     var errors = req.validationErrors();
    if (errors) {
        res.render('admin/edit_category',{
            errors: errors,
            title: title,
            id: id
         });
     } else {
         Category.findOne({slug: slug, _id:{'$ne':id}}, function(err, category) {
        if (category) {
            req.flash('danger','Category id exist,choose another.');
            res.render('admin/edit_category',{
                title: title,
                id: id 
             });
        }else {
            Category.findById(id, function(err, category){
                if (err) return console.log(err);
                category.title = title;
                category.slug = slug;

                category.save(function(err){
                    if (err) 
                    return console.log(err);
                    req.flash('success','Category added');
                    res.redirect('/admin/categories/edit-category/'+id);
                });
            });
    
           
        }
         });
     }
   
});
//get delete pages
router.get('/delete-category/:id',function(req,res){
   Category.findByIdAndRemove(req.param.id, function(err){
       if (err) 
       return console.log(err);
       req.flash('success','Category deleted');
       res.redirect('/admin/categories/');
   });
});



//module
module.exports = router;