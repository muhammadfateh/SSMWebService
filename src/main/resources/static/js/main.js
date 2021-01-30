
$(document).ready(function () {
    /* Using SessionStorage */
    let isUserLogged = sessionStorage.getItem("LoggedIn");
    const login = $("#btn-login");
    const go_to_download = $("#btn-download-excel");

    /* Check if user is login then */
    if(isUserLogged === 'true') {
        /* Change Login Button Text && Display "Download File" Button */
        login.text("Logout");
        go_to_download.removeClass('d-none');

        /* If click on Logout Button | Logout of the system */
        login.on('click', function (event) {
            sessionStorage.setItem("LoggedIn",false);
            window.location = 'index.html'
        });

        /* If user is on another page and wants to go back to download page he can simply click on "Workout Plan" to go there  */
        go_to_download.on('click', function (event) {
            window.location = 'LoggedIn.html'
        });
    }
    else {
        /* On Logout Reset Login Button Text */
        login.text("Login");
    }

    /* If user click on "down arrow" scroll to main-content */
    $("#scroll-to-content").on('click', function (event) {
        if (this.hash !== "") {
            event.preventDefault();
            let hash = this.hash;
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 800);
        }
    });
});

/* A little jquery to hide and show login & registration form */
function showRegistrationForm() {
    const login_form = $('#loginForm');
    const register_form = $('#regForm');

    if(register_form.hasClass('d-none')) {
        register_form.removeClass('d-none');
        login_form.removeClass('d-block');

        register_form.addClass('d-block');
        login_form.addClass('d-none');
    }
    else {
        register_form.removeClass('d-block');
        login_form.removeClass('d-none');

        register_form.addClass('d-none');
        login_form.addClass('d-block');
    }
}

/* reading values from login & registration form returning them in the form of json object */
$.fn.serializeObject = function()
{
    let o = {};
    let a = this.serializeArray();
    $.each(a, function() {
        /* little tweaks in naming keys */
        if(this.name === 'reg_username' || this.name === 'reg_password') {
            this.name = this.name.replace('reg_', '');
        }
        /* we don't need confirm Password value in json object */
        if(this.name === 'confirmPassword') {
            return true;
        }

        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
};
/* function call on Login/Create Account Button */
function authenticate() {
    const login_form = $('#loginForm');
    const register_form = $('#regForm');
    let jsonObject;
    let callURL;
    let errors = 0;

    /* checking which form is active */
    if(register_form.hasClass('d-block')) {

        /* form validation */
        $("#regForm :input").map(function(){
            if( !$(this).val() ) {
                $(this).addClass('is-invalid');
                errors++;
            } else if ($(this).val()) {
                $(this).removeClass('is-invalid');
            }
        });

        if(errors > 0){
            alert("All fields are required");
            return false;
        }
        if($("#confirmPassword").val() !== $("#reg_password").val()) {
            alert('password and confirm password is not same');
            return false;
        }

        jsonObject = JSON.stringify(register_form.serializeObject());
        callURL = 'api/signup';
        register_form.trigger("reset");
    }
    else {
        /* form validation */
        $("#loginForm :input").map(function(){
            if( !$(this).val() ) {
                $(this).addClass('is-invalid');
                errors++;
            } else if ($(this).val()) {
                $(this).removeClass('is-invalid');
            }
        });

        if(errors > 0){
            alert("All fields are required");
            return false;
        }

        jsonObject = JSON.stringify(login_form.serializeObject());
        callURL = 'api/login';
        login_form.trigger("reset");
    }

    let host = 'http://localhost:8080/';

    $.ajax({
        type: "POST",
        url: host + callURL,
        cache: false,
        contentType: 'application/json',
        data: jsonObject,
        success: function(msg) {
            /* saving login status into SessionStorage */
            sessionStorage.setItem("LoggedIn",true);
            window.location = 'LoggedIn.html'
        },
        error: function (err) {
            /* in case of any error */
            alert(err.responseText);
        }
    });

    return false;
}