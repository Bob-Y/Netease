$(function() {
    // 获取orderlist URL
    var initUrl = '/trading/product/2/bill';
    getlist();
    function getlist() {
        $.ajax({
            url : initUrl,
            type : "get",
            dataType : "json",
            success : function(data) {
                if (data.success) {
                    handleList(data.bill);
                    $('#account').text(data.price);
                }
            }
        });
    }
    function handleList(data) {
        var html = '';
        data.map(function(item, index) {
            html += '<tr>' +
                '<td>' +
                '<img src="'+ item.orderProduct.productImgAddr + '" alt="暂时无法显示" />' +
                '</td>' +
                '<td>' +
                '<a href="/trading/html/buyer/buyerProductDetail?id='+item.orderProduct.productId+'" class="thumbnail">'+
                item.orderProduct.productTitle +
                '</a>' +
                '</td>' +
                '<td>' + new Date(item.orderTime) + '</td>' +
                '<td>' + item.orderQuantity + '</td>' +
                '<td>' + item.orderPrice + '</td>' +
                '</tr>'
        });
        $('#account_list').html(html);
    }
});
