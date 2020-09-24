var express = require('express');
var router = express.Router();

//page model get
var Page = require('../models/page');


//get index pages
router.get('/',function(req,res){
    res.send('admin area');
   Page.find({}).sort({sorting: 1}).exec(function(err, pages){
    res.render('admin/pages',{
        pages: pages
    });
   });
});

//get add pages index


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


router.post('/add-page', function(req, res){
    req.checkBody('title','Title must have a value.').notEmpty();
    req.checkBody('content','Title must have a value.').notEmpty();

    var title = req.body.title;
    var slug = req.body.slug.replace(/\s+/g, '-').toLowerCase();
    if (slug =="")slug = title.replace(/\s+/g,'-').toLowerCase();
     var content = req.body.content;
     var errors = req.validationErrors();
    if (errors) {
        res.render('admin/add_page',{
            errors: errors,
            title: title,
            slug: slug,
            content: content 
         });
     } else {
         Page.findOne({slug: slug}, function(err, page) {
          if (page) {
            req.flash('danger','Page slug exist,choose another.');
            res.render('admin/add_page', {
                title: title,
                slug: slug,
                content: content 
             });
        }else {
            var page = new Page({
                title: title,
                slug: slug,
                content: content,
                sorting: 100
            });
            page.save(function(err){
                if (err) return console.log(err);
                req.flash('success','Page added');
                res.redirect('/admin/pages');
            });
        }
         });
     }
   
});


//post reorder pages
router.post('/reorder-pages',function(req,res){
    var ids = req.body['id[]'];
    var count = 0;
    for (var i =0;i< ids.length; i++){
        var id= ids[i];
        count++;
        (function(count) {

        
        Page.findById(id, function(err, page){
            page.sorting =count;
            page.save(function(err){
                if (err)
                return console.log(err);
            });
        });
        })(count);
    }
 });

//edit page

 
router.get('/edit-page/:slug', function(req, res) {
    Page.findById( req.params.id, function(err, page){
   if (err) 
      return console.log(err);
    
   
    res.render('admin/edit_page',{
       title: title,
       slug: slug,
       content: content,
       id: page._id
    });
});
});

 //post edit page
 router.post('/edit-page/:id', function(req, res){
    req.checkBody('title','Title must have a value.').notEmpty();
    req.checkBody('content','Title must have a value.').notEmpty();

    var title = req.body.title;
    var slug = req.body.slug.replace(/\s+/g, '-').toLowerCase();
    if (slug =="")slug = title.replace(/\s+/g,'-').toLowerCase();
     var content = req.body.content;
     var id = req.params.id;
     var errors = req.validationErrors();
    if (errors) {
        res.render('admin/edit_page',{
            errors: errors,
            title: title,
            slug: slug,
            content: content,
            id: id
         });
     } else {
         Page.findOne({slug: slug, _id:{'$ne':id}}, function(err, page) {
        if (page) {
            req.flash('danger','Page slug exist,choose another.');
            res.render('admin/edit_page',{
                title: title,
                slug: slug,
                content: content,
                id: id 
             });
        }else {
            Page.findById(id, function(err, page){
                if (err) return console.log(err);
                page.title = title;
                page.slug = slug;
                page.content = content;

                page.save(function(err){
                    if (err) 
                    return console.log(err);
                    req.flash('success','Page added');
                    res.redirect('/admin/pages/edit-page/'+ id);
                });
            });
    
           
        }
         });
     }
   
});
//get delete pages
router.get('/delete-page/:id',function(req,res){
   Page.findByIdAndRemove(req.param.id, function(err){
       if (err) return console.log(err);
       req.flash('success','Page deleted');
       res.redirect('/admin/pages/edit-page/');
   });
});



//module
module.exports = router;