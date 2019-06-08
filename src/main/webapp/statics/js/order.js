$(function() {
    queryOrder()
    $("#a_all").click(function () {
        queryOrder()
    })

    $("#a_unfinish").click(function () {
        queryOrderUnfinished()
    })

    $("#a_cancle").click(function () {
        queryOrderCancled()
    })

    $("#a_finished").click(function () {
        queryOrderFinished()
    })
})