$(document).ready(function () {
    /* Reading Images from directory and displaying dynamically and writing html code */
    let totalImages = 5;
    for (let i = 1; i <= totalImages; i++) {

        /* Add Image Title in data-heading attribute of img
        *  and, description for each image down inside div with id='img-content' */
        let elem = "<div class='col-md-3'>" +
            "<img id='nutrition_" + i + "' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallery/nutrition/gallery/nutrition_" + i + ".jpg' alt='nutrition " + i + "' data-heading='nutrition " + i + "'/>" +
            "<div class='d-none' id='img-content'>" +
            "<p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores modi rem laudantium amet dolore eos tempore ipsa est velit pariatur corrupti nam totam, illo in adipisci impedit, neque cumque ut! </p>" +
            "</div>" +
            "</div>";
        $('#photos-col').append(elem);
    }
});
