function ajax_test() {
    $.ajax({
        url : "/auth/test",
        type : "POST",
        contentType : "application/json",
        dataType : "JSON",
        success : function(data) {
            console.log(data);
        },
        error : function(err) {
            console.log(err);
        }
    });
}

function sign_in_user() {
    $("#sign_in_id").val($("#sign_in_id").val().replace(/ /gi, ''));
    if($("#sign_in_id").val() === "") {
        alert("please check login ID!");
        $("#sign_in_id").focus();
        return false;
    }

    $("#sign_in_pwd").val($("#sign_in_pwd").val().replace(/ /gi, ''));
    if($("#sign_in_pwd").val() === "") {
        alert("please check login Password!");
        $("#sign_in_pwd").focus();
        return false;
    }



}

function sign_up_user(){
    $("#sign_up_id").val($("#sign_up_id").val().replace(/ /gi, ''));
    if($("#sign_up_id").val() === "") {
        alert("please check ID!");
        $("#sign_up_id").focus();
        return false;
    }

    $("#sign_up_pwd").val($("#sign_up_pwd").val().replace(/ /gi, ''));
    if($("#sign_up_pwd").val() === "") {
        alert("please check password!");
        $("#sign_up_pwd").focus();
        return false;
    }

    $("#sign_up_name").val($("#sign_up_name").val().replace(/ /gi, ''));
    if($("#sign_up_name").val() === "") {
        alert("please check name!");
        $("#sign_up_name").focus();
        return false;
    }

    $("#sign_up_phone").val($("#sign_up_phone").val().replace(/ /gi, ''));
    if($("#sign_up_phone").val() === "") {
        alert("please check phone!");
        $("#sign_up_phone").focus();
        return false;
    }

    $("#sign_up_email").val($("#sign_up_email").val().replace(/ /gi, ''));
    if($("#sign_up_email").val() === "") {
        alert("please check email!");
        $("#sign_up_email").focus();
        return false;
    }


    var data_val = {
        "uiId" : $("#sign_up_id").val(),
        "uiPwd" : $("#sign_up_pwd").val(),
        "uiName" : $("#sign_up_name").val(),
        "uiPhone" : $("#sign_up_phone").val(),
        "uiEmail" : $("#sign_up_email").val()
    };
    console.log(data_val);

    $.ajax({
        url : "/auth/sign-up",
        type : "POST",
        contentType : "application/json",
        dataType : "JSON",
        data : JSON.stringify(data_val),
        success : function(data) {
            if(data.signUpInfo.RESULT_CODE === "DUPLICATE_ID") {
                console.log(data);
                alert("ID is duplicate. please check it.");
            } else if(data.signUpInfo.RESULT_CODE === "SUCCESS_SIGNUP") {
                console.log(data);
                alert("success sign up. welcome!");

                $(".sign_up_form > input").val("");
                show_sign_in();
            }
        },
        error : function(err) {
            console.log(err);
        }
    });
}


function show_sign_in() {
    $(".container").removeClass("right-panel-active");
}

function show_sign_up() {
    $(".container").addClass("right-panel-active");
}

$(function () {

});