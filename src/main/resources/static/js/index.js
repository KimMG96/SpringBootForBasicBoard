// 정규식 이메일 검증
function chk_email_filter(val) {
    var email_filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    if(email_filter.test(val) === true) {
        return true;
    } else {
        return false;
    }
}

function sign_up_user(){
    var sign_up_id = $("#sign_up_id").val($.trim($("#sign_up_id")));
    if(sign_up_id === "") {
        alert("please check ID!");
        $("#sign_up_id").focus();
        return false;
    }
    console.log("1");
    return false;

    var sign_up_pwd = $("#sign_up_pwd").val($.trim($("#sign_up_pwd")));
    if(sign_up_pwd === "") {
        alert("please check password!");
        $("#sign_up_pwd").focus();
        return false;
    }

    var sign_up_name = $("#sign_up_name").val($.trim($("#sign_up_name")));
    if(sign_up_name === "") {
        alert("please check name!");
        $("#sign_up_name").focus();
        return false;
    }

    var sign_up_phone = $("#sign_up_phone").val($.trim($("#sign_up_phone")));
    if(sign_up_phone === "") {
        alert("please check name!");
        $("#sign_up_phone").focus();
        return false;
    }

    var sign_up_email = $("#sign_up_email").val($.trim($("#sign_up_email")));
    if(sign_up_email === "" || chk_email_filter(sign_up_email)) {
        alert("please check name!");
        $("#sign_up_email").focus();
        return false;
    }


    var data_val = {
        "uiId" : sign_up_id,
        "uiPwd" : sign_up_pwd,
        "uiName" : sign_up_name,
        "uiPhone" : sign_up_phone,
        "uiEmail" : sign_up_email
    }


    $.ajax({
        url : "/sign-up",
        type : "POST",
        dataType : "JSON",
        data : data_val,
        success : function(data) {
            console.log(data);
        },
        error : function(err) {
            console.log(err);
        }
    });
}

$(document).on("click", "#signIn", function() {
    $(".container").removeClass("right-panel-active");
});

$(document).on("click", "#signUp", function() {
    $(".container").addClass("right-panel-active");
});

function fn_mbtlnumChk(mbtlnum){
    var regExp = /^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$/;
    if(!regExp.test(mbtlnum)){
        alert("휴대폰번호가 올바르지 않습니다.");
        return false;
    }
    return true;
}

$(function () {

    $("#sign_up_phone").focusout(function() {
        if(this.value !== ""){
            fn_mbtlnumChk(this.value);
        }
    });

    $(".sign_up_form > .btn").click(function() {
        sign_up_user();
    });

});