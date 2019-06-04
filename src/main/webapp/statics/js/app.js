$(function(){
    $(".loadnav").load("navbar.html");
    $(".specificInfo").click(function () {


        getCoursesSPinfo(name);
    })

    getCourses(1);
    $("#type_1").click(function () {
        getCourses(1)
    })
    $("#type_2").click(function () {
        getCourses(2)
    })


})
var urlHead="http://localhost:8080/OESPF_war_exploded/"
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
                    +" \'/><div class=\"caption\"><h3><a onclick='urlName(this)' id=\'"+arr[i].coursesName+"\'>"+arr[i].coursesName+"</a></h3><p>"+arr[i].text+"</p></div></div>"


            }
            $(".coursesInfo").html(html)

        }
    })
}
function urlName(e){
    var name=$(e).attr("id");
    window.open("coursesSp.html?name="+name)


}

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
function getCoursesSPinfo(name) {
    $.ajax({
        type:"POST",
        url:urlHead+"Courses/getSpInfo",
        data:{
            coursesName:name
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