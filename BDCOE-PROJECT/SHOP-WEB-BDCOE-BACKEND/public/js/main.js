$(function(){

    if ($('textarea').length) {
        CKEDITOR.replace('ta');
    }
    $('a.confirmDeletion').on('click',function(e){
        if (!confirm('Confirm deletion')) return false;
         return false;
    });
    
});