$(function() {
    // 获取orderlist URL
    var initUrl = '/trading//bill';
    getlist();
    function getlist() {
        $.ajax({
            url : initUrl,
            type : "get",
            dataType : "json",
            success : function(data) {
                if (data.success) {
                    handleList(data.orderList);
                }
            }
        });
    }
    function handleList(data) {
        var html = '';
        data.map(function(item, index) {
            html += '<div class="col-sm-6 col-md-3">' +
                '<a href="../WEB-INF/html/buyer/account.html" class="thumbnail">'+
                '<div class="caption">'+
                '<h4>'+ item.orderId + '</h4>'+
                '<p>' + item.orderTime + '</p>'+
                '<p>'+item.orderProduct +'</p>'+
                '<p>'+item.orderQuantity + '个</p>'+
                '<p>'+item.orderPrice +'元</p>'+
                '</div>'+
                '</a>'+
                '</div>'
        });
        $('#orders_list').html(html);
    }
});
