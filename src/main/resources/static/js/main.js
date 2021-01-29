
$(document).ready(function () {
    let isUserLogged = sessionStorage.getItem("LoggedIn");
    const login = $("#btn-login");
    const go_to_download = $("#btn-download-excel");
    if(isUserLogged === 'true') {
        login.text("Logout");
        go_to_download.removeClass('d-none');
        login.on('click', function (event) {
            sessionStorage.setItem("LoggedIn",false);
            window.location = 'index.html'
        });
        go_to_download.on('click', function (event) {
            window.location = 'LoggedIn.html'
        });
    }
    else {
        login.text("Login");
    }

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


$.fn.serializeObject = function()
{
    let o = {};
    let a = this.serializeArray();
    $.each(a, function() {
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

function authenticate() {
    const login_form = $('#loginForm');
    const register_form = $('#regForm');
    let jsonObject;
    let callURL;
    if(register_form.hasClass('d-block')) {
        jsonObject = JSON.stringify(register_form.serializeObject());
        callURL = 'api/signup';
        register_form.trigger("reset");
    }

    else {
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
            sessionStorage.setItem("LoggedIn",true);
            window.location = 'LoggedIn.html'
        },
        error: function (err) {
            alert(err.responseText);
        }
    });

    return false;
}