
var urlHead="http://localhost:8080/OESPF_war_exploded/"
var price;
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
                html += "<div class=\"thumbnail col-md-2 ssm-courses\" style=\'margin-right: 40px\'><img style='height: 150px;width: 180px' src=\'" +arr[i].img
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
            price=data.data.money;
            var courses=data.data;
            $("#teacher_by").append(courses.teachBy)
            $("#coursesName").append(courses.coursesName)

            $("#sp_img").append("<img style='width: 300px;height: 200px' src=\""+data.data.img+"\" />")
            $("#sp_content").append("<p>\n"+data.data.text +"</p> ")


        }
    })
}
function signIn(){
    data={
        "username": $('#login_username').val(),
        "password": $('#login_password').val(),
    }
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
    console.log("have courses")
}
function getList(){
    var arr;
    var urlData=GetRequest();
    var coursesId=urlData.name;
    var crr=urlData.currentNr;
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
                    "<td><button class='btn btn-default urlLink'  onclick='urlForTakeC(this)' id='"+arr[i].currentNumber+"'>" +
                    "<span class='glyphicon glyphicon-play-circle'></span></button></td></tr>"
            }

            $("#coursesList").append(html);
            console.log(arr[crr].url)
            $("#video").attr("src",arr[crr].url)
        }
    })

    return arr;
}

function queryIfBuy(e){
    var urlData=GetRequest();
    var coursesId=urlData.name;
    var username=localStorage.username;
    $.ajax({
        type:"POST",
        url:urlHead+"RNcourses/query",
        data:{
            "coursesId":coursesId,
            "username":username
        },
        success:function(res){
            msg=JSON.parse(res)
            if(msg.code!=200){
                alert(msg.data)

                $(".urlLink").prop("disabled", true);
                // window.location.reload()

            }else {
                $(".urlLink").prop("disabled",false)
                $("#buy").remove();

            }
        }
    })
}
function buyCourses(){
    var urlData=GetRequest();
    var coursesId=urlData.name;
    var username=localStorage.username;
    var price2 =price;
    console.log(price)
    $.ajax({
        type:"POST",
        url:urlHead+"payment/addPayment",
        data:{
            "coursesId":coursesId,
            "username":username,
            "price":price2
        },
        success:function (res) {
            var msg=JSON.parse(res)
           if(msg.data.code==200){
              alert("订单已生成，请前往订单中心支付")
           }else{
               alert(msg.data.msg);
           }
        }
    })
}
function status(status) {
    if(status==1){
        return "待支付"
    }else if(status==2){
        return "已支付"

    }else if(status==4){

        return "订单取消"
    }
}

function payfor(e){
    var id=$(e).attr("id");

    $.ajax({

        type:"POST",
        url:urlHead+"payment/pay",
        data:{
            "id":id,
            "username":localStorage.username
        },
        success:function (res) {
            msg=JSON.parse(res)

            if(msg.data.code==200){
                alert("支付成功")
            }else{
                console.log(msg.data.msg)
                alert(msg.data.msg)
            }
        }
    })
}

function cancleOrder(e) {
    var id=$(e).attr("id");
    $.ajax({

        type:"POST",
        url:urlHead+"payment/cancle",
        data:{
            "id":id,
            "username":localStorage.username
        },
        success:function (res) {
            msg=JSON.parse(res)

            if(msg.data.code==200){
                alert("订单已取消")
            }else{
                console.log(msg.data.msg)
                alert(msg.data.msg)
            }
        }
    })
}
function queryOrder(){
    var username=localStorage.username
    $.ajax({
        type:"POST",
        url:urlHead+"payment/queryList",
        data:{
            "username":username
        },
        success:function(res){
            var arr=JSON.parse(res)
            var html=""
            for(i=0;i<arr.length;i++){
                html+="<tr><td>"+arr[i].id +"</td><td>"+arr[i].username+"</td><td>" +
                    arr[i].coursesId+"</td>><td>" +
                    arr[i].price+"</td><td>" +
                    status(arr[i].status)+"</td>"
                if(arr[i].status!=1){
                    html+="<td><button disabled='disabled' class=\"order_op btn btn-sm btn-success\">支付</button>"
                        + "<button class=\"order_op btn btn-sm btn-danger\" disabled='disabled'>取消</button></td>"
                }else {
                    html+="<td><button id='"+arr[i].id +"' class=\"order_op btn btn-sm btn-success\" onclick='payfor(this)'>支付</button>" +
                    "<button id=\'"+arr[i].id +"\' class=\"order_op btn btn-sm btn-danger\"  onclick='cancleOrder(this)'>取消</button></td>"
                }
                html+="</tr>"
            }
            $("#order_all_TB>tbody").html(html)
        }
    })
}
function queryOrderFinished(){
    var username=localStorage.username
    $.ajax({
        type:"POST",
        url:urlHead+"payment/queryOther",
        data:{
            "username":username,
            "status":2
        },
        success:function(res){
            var arr=JSON.parse(res)
            var html=""
            for(i=0;i<arr.length;i++){
                html+="<tr><td>"+arr[i].id +"</td><td>"+arr[i].username+"</td><td>" +
                    arr[i].coursesId+"</td>><td>" +
                    arr[i].price+"</td></tr>"

            }
            $("#order_finished_TB>tbody").html(html)
        }
    })
}
function queryOrderCancled(){
    var username=localStorage.username
    $.ajax({
        type:"POST",
        url:urlHead+"payment/queryOther",
        data:{
            "username":username,
            "status":4
        },
        success:function(res){
            var arr=JSON.parse(res)
            var html=""
            for(i=0;i<arr.length;i++){
                html+="<tr><td>"+arr[i].id +"</td><td>"+arr[i].username+"</td><td>" +
                    arr[i].coursesId+"</td>><td>" +
                    arr[i].price+"</td></tr>"

            }
            $("#order_cancle_TB>tbody").html(html)
        }
    })
}

function queryOrderUnfinished(){
    var username=localStorage.username
    $.ajax({
        type:"POST",
        url:urlHead+"payment/queryOther",
        data:{
            "username":username,
            "status":1
        },
        success:function(res){
            var arr=JSON.parse(res)
            var html=""
            for(i=0;i<arr.length;i++){
                html+="<tr><td>"+arr[i].id +"</td><td>"+arr[i].username+"</td><td>" +
                    arr[i].coursesId+"</td>><td>" +
                    arr[i].price+"</td><td>" +
                    status(arr[i].status)+"</td>"
                if(arr[i].status!=1){
                    html+="<td><button disabled='disabled' class=\"order_op btn btn-sm btn-success\">支付</button>"
                        + "<button class=\"order_op btn btn-sm btn-danger\" disabled='disabled'>取消</button></td>"
                }else {
                    html+="<td><button id='"+arr[i].id +"' class=\"order_op btn btn-sm btn-success\" onclick='payfor(this)'>支付</button>" +
                        "<button id=\'"+arr[i].id +"\' class=\"order_op btn btn-sm btn-danger\"  onclick='cancleOrder(this)'>取消</button></td>"
                }
                html+="</tr>"
            }
            $("#order_unfinish_TB>tbody").html(html)
        }
    })
}

function queryListAll() {
    $.ajax({
        type:"POST",
        url:urlHead+"Courses/allCourses",
        success:function(res){
            msg=JSON.parse(res)
            arr=msg.data

            var html=""
            for(i=0;i<arr.length;i++){
                html+="<li><a id=\'"+arr[i].id +"\' onclick='loadFormData(this)'>"+arr[i].coursesName +"</a></li>"
            }
            html+="<li><a class=\"btn-sm btn-success\" style='padding: 1px 2px;' onclick='addNew(this)'>添加新课程</a></li>"

            html="<ol>" +html +"</ol>"
            $("#exsit_courses").html(html);

        }
    })

}
function loadFormData(e) {
    var id = $(e).attr("id");
    localStorage.id=id;
    $("#addCourses").hide()
    $("#modiCourses").show()
    $.ajax({
        type: "POST",
        url: urlHead + "Courses/getSpInfo",
        data: {
            id: id
        },
        success: function (res) {
            arr = JSON.parse(res)

            msg=arr.data
            $("#Courses_name").val(msg.coursesName)
            $("#Courses_text").val(msg.text)
            $("#Courses_price").val(msg.money)
            $("#Courses_teacher").val(msg.teachBy)
            $("#Courses_number").val(msg.coursesNumber)
            $("#courses_type").val(msg.examType)
        }
    })
}
function addNew(e){
    $("#addCourses").show()
    $("#modiCourses").hide()
    $("#Courses_name").val(" ")
    $("#Courses_text").val(" ")
    $("#Courses_price").val(" ")
    $("#Courses_teacher").val(" ")
    $("#Courses_number").val(" ")
    $("#courses_type").val(" ")
}
function addCourses(){
    arr={
        "coursesName": $("#Courses_name").val(),
        "text":$("#Courses_text").val(),
        "examType": $(':radio[name="type"]:checked').val(),
        "coursesNumber": $("#Courses_number").val(),
        "money":$("#Courses_price").val(),
        "teachBy":$("#Courses_teacher").val(),
        "img":localStorage.url
    }
    $.ajax({
        type:"POST",
        // contentType: "multipart/form-data",
        data:arr,
        url:urlHead+"Courses/addCourses",
        success: function (res) {
            msg = JSON.parse(res);

            console.log(msg.data.msg)
            alert(msg.data.msg);

        },
        error: function (e) {
            alert('上传失败!请重试');
        },complete:function () {

        }
    })



}
function modifyCourses() {
    arr={
        "id":localStorage.id,
        "coursesName": $("#Courses_name").val(),
        "text":$("#Courses_text").val(),
        "examType": $(':radio[name="type"]:checked').val(),
        "coursesNumber": $("#Courses_number").val(),
        "money":$("#Courses_price").val(),
        "teachBy":$("#Courses_teacher").val(),
        "img":localStorage.url
    }
    $.ajax({
        type:"POST",
        // contentType: "multipart/form-data",
        data:arr,
        url:urlHead+"Courses/setCourses",
        success: function (res) {
            msg = JSON.parse(res);

            console.log(msg.data.msg)
            alert(msg.data.msg);
            location.reload(true)
        },
        error: function (e) {
            alert('上传失败!请重试');
        }
    })
}
var arr1=new Array();
var arr=new Array();


function allCoursesForTree(){
    $.ajax({
        type:"POST",
        url:urlHead+"Courses/allCourses",
        success:function(res) {
            msg=JSON.parse(res)
            for (i=0;i<msg.data.length;i++){
                treeData.push({
                    "title":msg.data[i].coursesName,
                    "id":msg.data[i].id,
                    children:[]
                })
            }

        }
    })
}
function addLecture(coursesId,totalNumber,currentNumber,lectureName) {
    data= {
        "coursesId": coursesId,
        "totalNumber": totalNumber,
        "currentNumber": currentNumber,
        "url": "#",
        "lectureName":lectureName
    }
    $.ajax({
        type:"POST",
        url:urlHead+"CoursesURL/addLecture",
        data:data,
        succuss:function (res) {
            console.log(res)
        }
    })
}
function recharge(){
    $.ajax({
        type:"POST",
        url:urlHead+"user/addBalance",
        data:{
            "username":localStorage.username,
            "balance":5000
        },
        success:function (res) {

            console.log("success",res)
        },
        complete:function (res) {
            console.log("complete",res)
        }
    })
}
