$(function () {


    /**
     * Courses switch
     * */

    $("#type_1").click(function () {
        getCourses(1)
    })
    $("#type_2").click(function () {
        getCourses(2)
    })
    var Request = GetRequest();
    var name=Request['name']
    getCoursesSPinfo(name);
    getList();
    queryIfBuy();


    /**
     * buy
     */
    $("#buy").click(function () {
        buyCourses();
    })
})