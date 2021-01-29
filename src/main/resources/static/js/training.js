

$(document).ready(function () {
    var totalImages = 16;
    for(i = 1; i<=totalImages; i++) {
        $('#photos-col').append("<div class='col-md-3'><img id='training_"+i+"' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallary/training/gallery/training_"+i+".jpg' alt='training "+i+"'></div>");
    }
});

$(document).on('show.bs.modal','#showPhotoDetail', function (e) {
    var OpenImg = $(e.relatedTarget).attr('src');
    $("#openImage").attr('src', OpenImg)
});