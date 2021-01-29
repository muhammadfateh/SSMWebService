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

function downloadFile() {
    let path = "ext-files/workout_plan.xlsx";
    let file = new File(["aa"], "workout_plan");
    let link = document.createElement("a");
    link.download = path;
    link.href = file;
    link.click();
}
