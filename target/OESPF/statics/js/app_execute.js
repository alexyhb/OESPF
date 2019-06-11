$(function(){

    /**
     * nav loading
    * */
    $(".loadnav").load("navbar.html");
    $("#recharge").click(function () {
        recharge();
    })






    /**
     * login
     * */
    $("#btn_login").click(function () {
        var data = {};


        var username =$("#login_username").val();
        var password =$("#login_password").val();

        var data={
            "username":username,
            "password":password
        };

        console.log(data)

        signIn(data);



    })


    /**
     * Sign up
     */
    $("#btn_signup").click(function(){
       var username= $("#signup_username").val()
       var password= $("#signup_PWD").val()
       var password2= $("#signup_PWD2").val();
       var role=$("input[name='role']").attr("checked", true).val();
        if(password!=password2){
            $("#signup_PWD2").attr("title","两次密码输入不一致")
        }

        var data={
            "username":username,
            "password":password,
            "role":role,
        }
        console.log(data)
       signUp(data)
    })


    /**
     * get the specific info of the courses
     */
    $(".specificInfo").click(function () {


        getCoursesSPinfo(name);

    })

})