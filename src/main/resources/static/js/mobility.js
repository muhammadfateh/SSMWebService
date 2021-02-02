$(document).ready(function () {
    /* Reading Images from directory and displaying dynamically and writing html code
    *  Replace img_1, img_2, ... content with any number of paragraphs...
    *
    *
    *  furthermore, to change the header... simply give text inside heading */
    let mobility_content = [];
    let totalImages = 5;

    let img_1 = ['paragraph 1', 'paragraph 2'];
    let img_2 = ['paragraph 1', 'paragraph 2'];
    let img_3 = ['paragraph 1', 'paragraph 2'];
    let img_4 = ['paragraph 1', 'paragraph 2'];
    let img_5 = ['paragraph 1', 'paragraph 2'];

    mobility_content.push( { heading: "Heading 01", data: '<p>' + img_1.join('</p><p>') + '</p>' });
    mobility_content.push( { heading: "Heading 02", data: '<p>' + img_2.join('</p><p>') + '</p>' });
    mobility_content.push( { heading: "Heading 03", data: '<p>' + img_3.join('</p><p>') + '</p>' });
    mobility_content.push( { heading: "Heading 04", data: '<p>' + img_4.join('</p><p>') + '</p>' });
    mobility_content.push( { heading: "Heading 05", data: '<p>' + img_5.join('</p><p>') + '</p>' });

    for (let i = 1; i <= totalImages; i++) {

        /* Add Image Title in data-heading attribute of img
        *  and, description for each image down inside div with id='img-content' */
        let elem = "<div class='col-md-3'>" +
            "<img id='mobility_" + i + "' data-toggle='modal' data-target='#showPhotoDetail' class='gallery-img' src='img/photo_gallery/mobility/gallery/mobility_" + i + ".jpg' alt='mobility " + i + "' data-heading='" + mobility_content[i-1].heading + "'/>" +
            "<div class='d-none' id='img-content'>" + mobility_content[i-1].data +  "</div>" +
            "</div>";
        $('#photos-col').append(elem);
    }
});