$(document).ready(function () {
    var totalImages = 5;
    for(i = 1; i<=totalImages; i++) {
        $('#photos-col').append("<div class='col-md-3'><img id='mobility_"+i+"' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallary/mobility/gallery/mobility_"+i+".jpg' alt='mobility "+i+"'></div>");
    }
});

$(document).on('show.bs.modal','#showPhotoDetail', function (e) {
    var OpenImg = $(e.relatedTarget).attr('src');
    $("#openImage").attr('src', OpenImg)
});