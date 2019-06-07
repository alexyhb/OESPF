
var urlHead="http://localhost:8080/OESPF_war_exploded/"
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function getCourses(type){
    $.ajax({
        type: "POST",
        url: urlHead+"Courses/typelist",
        data:{
            type:type
        },
        success: function (res) {
            var arr=JSON.parse(res)
            var html="";
            for(i=0;i<arr.length;i++){
                html += "<div class=\"thumbnail col-md-2 ssm-courses\" style=\'margin-right: 40px\'><img alt=\"300x200\" src=\'" +arr[i].img
                    +" \'/><div class=\"caption\"><h3><a onclick='urlForSp(this)' id=\'"+arr[i].id+"\'>"+arr[i].coursesName+"</a></h3><p>"+arr[i].text+"</p></div></div>"


            }
            $(".coursesInfo").html(html)

        }
    })
}
function urlForSp(e){
    var name=$(e).attr("id");
    window.open("coursesSp.html?name="+name)
}


function getCoursesSPinfo(name) {

    $.ajax({
        type:"POST",
        url:urlHead+"Courses/getSpInfo",
        data:{
            id:name
        },
        success:function (res) {
            var data=JSON.parse(res);
            console.log(data.data)
            var courses=data.data;
            $("#teacher_by").append(courses.teachBy)
            $("#coursesName").append(courses.coursesName)

        }
    })
}
function signIn(data){
    $.ajax({
        type: "POST",
        url: 'http://localhost:8080/OESPF_war_exploded/user/Login',
        data: data,
        success: function (res) {
            if(res.info.code==200){

                window.location.href="../../index.html"
                localStorage.username = data.username
            }else{
                alert(res.info.msg)
            }

        }
    })
}
function signUp(data){
    $.ajax({
        type: "POST",
        url: 'http://localhost:8080/OESPF_war_exploded/user/regist',
        data: data,
        success: function (res) {
            var ress=JSON.parse(res);

            if(ress.code==200){
                alert("注册完成请登陆");
                window.location.href="../../index.html"
            }else{
                alert(ress.msg)
            }
            // if(res.info.code==200){

            //
            //
            // }else{
            //     alert(res.info.msg)
            // }

        }
    })
}
function urlForTakeC(e){
    var currentNr=$(e).attr("id");
    var urlData=GetRequest();
    var name=urlData.name;
    window.open("TakeCourses.html?name="+name+"&currentNr="+currentNr)
}
function getList(){
    var arr;
    var urlData=GetRequest();
    var coursesId=urlData.name;
    $.ajax({
        type:"POST",
        url:urlHead+"CoursesURL/getList",
        data:{
            "coursesId":coursesId
        },
        success:function(res){
            arr=JSON.parse(res);

            var html=""
            for(i=0;i<arr.length;i++){
                html+="<tr><td>"+arr[i].currentNumber+"</td><td>"+arr[i].lectureName+"</td>" +
                    "<td><button class='btn btn-default' onclick='urlForTakeC(this)' id='"+arr[i].currentNumber+"'>" +
                    "<span class='glyphicon glyphicon-play-circle'></span></button></td></tr>"
            }

            $("#coursesList").append(html);

        }
    })

    return arr;
}
