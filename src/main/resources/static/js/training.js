$(document).ready(function () {
    /* Reading Images from directory and displaying dynamically writing html code */
    let totalImages = 16;
    for(let i = 1; i<=totalImages; i++) {
        $('#photos-col').append("<div class='col-md-3'><img id='training_"+i+"' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallery/training/gallery/training_"+i+".jpg' alt='training "+i+"'></div>");
    }
});
/* When You Click on Photos | it will show their details */
$(document).on('show.bs.modal','#showPhotoDetail', function (e) {
    /* Get All details here, using different ways as per requirement */
    /* Currently getting their name & picture to display them into the card */
    let OpenImg = $(e.relatedTarget).attr('src');
    $("#openImage").attr('src', OpenImg)
});