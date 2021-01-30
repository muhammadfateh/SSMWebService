/* Using SessionStorage */
/* Check if user is not login then redirect to home page */
let isUserLogged = sessionStorage.getItem("LoggedIn");
const login = $("#btn-login");
if (isUserLogged === 'false') {
    window.location = 'index.html'
}


$(document).ready(function () {
    downloadFile();
    const download_file_btn = $("#btn-download");
    download_file_btn.removeClass('d-none').delay(3000);

    download_file_btn.on('click', function (event) {
        downloadFile();
    });
});
/* Download Excel File */
function downloadFile() {
    /* Give the path of the file */
    let path = "ext-files/workout_plan.xlsx";
    let file = new File(["aa"], "workout_plan");
    /* Creating a temporary link for downloading file */
    let link = document.createElement("a");
    /* providing file path to be downloaded */
    link.download = path;
    link.href = path;
    /* virtually trigger click event to start downloading the file */
    link.click();
    /* Removing the temp link */
    link.remove();
}
