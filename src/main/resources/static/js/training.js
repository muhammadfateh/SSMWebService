

$(document).ready(function () {
    /* Reading Images from directory and displaying dynamically and writing html code
    *  Replace img_1, img_2, ... content with any number of paragraphs...
    *
    *
    *  furthermore, to change the header... simply give text inside heading */
    let training_content = [];
    let totalImages = 16;

    let img_1 = ['paragraph 1', 'paragraph 2'];
    let img_2 = ['paragraph 1', 'paragraph 2'];
    let img_3 = ['paragraph 1', 'paragraph 2'];
    let img_4 = ['paragraph 1', 'paragraph 2'];
    let img_5 = ['paragraph 1', 'paragraph 2'];

    let img_6 = ['paragraph 1', 'paragraph 2'];
    let img_7 = ['paragraph 1', 'paragraph 2'];
    let img_8 = ['paragraph 1', 'paragraph 2'];
    let img_9 = ['paragraph 1', 'paragraph 2'];
    let img_10 = ['paragraph 1', 'paragraph 2'];

    let img_11 = ['paragraph 1', 'paragraph 2'];
    let img_12 = ['paragraph 1', 'paragraph 2'];
    let img_13 = ['paragraph 1', 'paragraph 2'];
    let img_14 = ['paragraph 1', 'paragraph 2'];
    let img_15 = ['paragraph 1', 'paragraph 2'];

    let img_16 = ['paragraph 1', 'paragraph 2'];


    training_content.push( { heading: "Heading 01", data: '<p>' + img_1.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 02", data: '<p>' + img_2.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 03", data: '<p>' + img_3.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 04", data: '<p>' + img_4.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 05", data: '<p>' + img_5.join('</p><p>') + '</p>' });


    training_content.push( { heading: "Heading 06", data: '<p>' + img_6.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 07", data: '<p>' + img_7.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 08", data: '<p>' + img_8.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 09", data: '<p>' + img_9.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 10", data: '<p>' + img_10.join('</p><p>') + '</p>' });


    training_content.push( { heading: "Heading 11", data: '<p>' + img_11.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 12", data: '<p>' + img_12.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 13", data: '<p>' + img_13.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 14", data: '<p>' + img_14.join('</p><p>') + '</p>' });
    training_content.push( { heading: "Heading 15", data: '<p>' + img_15.join('</p><p>') + '</p>' });

    training_content.push( { heading: "Heading 16", data: '<p>' + img_16.join('</p><p>') + '</p>' });

    for (let i = 1; i <= totalImages; i++) {

        /* Add Image Title in data-heading attribute of img
        *  and, description for each image down inside div with id='img-content' */
        let elem = "<div class='col-md-3'>" +
            "<img id='training_" + i + "' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallery/training/gallery/training_" + i + ".jpg' alt='training " + i + "' data-heading='" + training_content[i-1].heading + "'/>" +
            "<div class='d-none' id='img-content'>" + training_content[i-1].data +  "</div>" +
            "</div>" +
            "</div>";
        $('#photos-col').append(elem);
    }
});
