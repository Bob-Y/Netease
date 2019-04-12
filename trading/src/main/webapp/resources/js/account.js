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
                    handleList(data.bill);
                }
            }
        });
    }
    function handleList(data) {
        var html = '';
        data.map(function(item, index) {
            html += '<tr>' +
                '<a href="../WEB-INF/html/productDetail.html" class="thumbnail">'+
                '<td>' + '<img src="\' + item.orderProduct.getproductImgAddr() + \'" alt="暂时无法显示" />' + '</td>' +
                '<td>' + item.orderProduct.getProductTitle() + '</td>' +
                '</a>' +
                '<td>' + item.orderTime + '</td>' +
                '<td>' + item.orderQuantity + '</td>' +
                '<td>' + item.orderPrice + '</td>' +
                '</tr>'
        });
        $('#orders_list').html(html);
    }
});
