$(document).ready(function() {
    // $("#btn1").click(function(){
    //     if(EmailValid() && NameValid() && SurnameValid()) {
    //         $.ajax({
    //             url: "http://localhost:8080/CalendarEvents_war_exploded/adduser",
    //             type: "POST",
    //             data: {"name": $("#name").val(), "email": $("#email").val(), "surname": $("#surname").val()},
    //             beforeSend: function () {
    //                 $("#btn1").prop("disabled", true);
    //             },
    //             success: function (data) {
    //                 alert(data);
    //                 $("#btn1").prop("disabled", false);
    //                 location.reload(true);
    //             }
    //         });
    //     }
    // });

    $("#delete").click(function() {
        $.ajax({
            url:"http://localhost:8080/demo_login_war_exploded/StudentDeleteServlet",
            type:"get",
            data:{"id":$("#student_id").val()},
            beforeSend:function(){
                $("#delete").prop("disabled",true);
            },
            success:function(data){
                alert(data);
                $("#delete").prop("disabled",false);
                $(location).attr('href', "http://localhost:8080/demo_login_war_exploded/StudentsServlet?");
            }
        });
    });




    $("#btnRedact").click(function() {
        if(EmailValid() && FirstNameValid() && LastNameValid() && PasswordValid() && UrlValid() && NumberValid()) {
            $.ajax({
                url: "http://localhost:8080/demo_login_war_exploded/StudentUpdateServlet",
                type: "post",
                data: {
                    "id": $("#student_id").val(),
                    "firstname": $("#firstname").val(),
                    "lastname": $("#lastname").val(),
                    "email": $("#email").val(),
                    "password": $("#password").val(),
                    "url": $("#url").val(),
                    "number": $("#number").val()
                },
                beforeSend: function () {
                    $("#btnRedact").prop("disabled", true);
                },
                success: function (data) {
                    $("#btnRedact").prop("disabled", false);
                    alert(data);
                    location.reload(true);
                },
                error: function () {
                    alert("Servlet ERROR");
                }
            });
        }
    });


    //Email validation
    var EmailValid = function(){
        email = $('#email').val();
        atpos = email.indexOf('@');
        dotpos = email.lastIndexOf('.');
        if (email == '') {
            $('#regisErr1').text('* This field is required !');
            $('#email').focus();
            return false;
        }else{
            if(atpos < 1 || dotpos < atpos+2 || dotpos+2 >= email.length) {
                $('#regisErr1').text('It is not a valid email address!');
                $('#email').focus();
                return false;
            }
            else{
                $('#regisErr1').text('');
                return true;
            }
        }
    };


    //Name Vaildation
    var FirstNameValid = function(){
        firstname = $('#firstname').val();
        if (firstname == '') {
            $('#regisErr2').text('* This field is required !');
            $('#firstname').focus();
            return false;
        }else{
            $('#regisErr2').removeClass('error').text('');
            return true;
        }
    };

    //Surname Vaildation
    var LastNameValid = function(){
        lastname = $('#lastname').val();
        if (lastname == '') {
            $('#regisErr3').text('* This field is required !');
            $('#lastname').focus();
            return false;
        }else{
            $('#regisErr3').text('');
            return true;
        }
    };

    //Surname Vaildation
    var PasswordValid = function(){
        password = $('#password').val();
        if (password == '') {
            $('#regisErr4').text('* This field is required !');
            $('#password').focus();
            return false;
        }else{
            $('#regisErr4').text('');
            return true;
        }
    };

    //Surname Vaildation
    var UrlValid = function(){
        url = $('#url').val();
        if (url == '') {
            $('#regisErr5').text('* This field is required !');
            $('#url').focus();
            return false;
        }else{
            $('#regisErr5').text('');
            return true;
        }
    };

    //Surname Vaildation
    var NumberValid = function(){
        number = $('#number').val();
        if (number == '') {
            $('#regisErr6').text('* This field is required !');
            $('#number').focus();
            return false;
        }else{
            $('#regisErr6').text('');
            return true;
        }
    };


    $("#firstname").keyup(function(){
        FirstNameValid();
    });
    $("#lastname").keyup(function(){
        LastNameValid();
    });
    $("#email").keyup(function(){
        EmailValid();
    });
    $("#password").keyup(function(){
        PasswordValid();
    });
    $("#url").keyup(function(){
        UrlValid();
    });
    $("#number").keyup(function(){
        NumberValid();
    });

});
