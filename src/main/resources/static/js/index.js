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

function sign_in_success() {
    console.log(1);
    $.ajax({
        url : "/board/load-form",
        type : "GET",
        success : function(data) {
            console.log(data);
            // $("body > .container").empty().load(data);
            window.location.href = data;
        },
        error : function(err){
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

    var data_val = {
        "uiId" : $("#sign_in_id").val(),
        "uiPwd" : $("#sign_in_pwd").val()
    }

    $.ajax({
        url : "/auth/sign-in",
        type : "POST",
        contentType : "application/json",
        dataType : "JSON",
        data : JSON.stringify(data_val),
        success : function(data) {
            if(data.signInInfo.RESULT_CODE === "NONEXISTENT_USER") {
                alert("it's non-existent user. check your id or password");
                $("#sign_in_id").focus();

            } else if(data.signInInfo.RESULT_CODE === "SUCCESS_SIGNIN") {
                console.log(data.signInInfo.USER_INFO);
                sign_in_success();
            }
        },
        error : function(err) {
            console.log(err);
        }
    });

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

    $.ajax({
        url : "/auth/sign-up",
        type : "POST",
        contentType : "application/json",
        dataType : "JSON",
        data : JSON.stringify(data_val),
        success : function(data) {
            console.log(data.signUpInfo.RESULT_CODE);
            if(data.signUpInfo.RESULT_CODE === "DUPLICATE_ID") {
                alert("ID is duplicate. please check it.");
                $("sign_up_id").focus();
            } else if(data.signUpInfo.RESULT_CODE === "SUCCESS_SIGNUP") {
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
