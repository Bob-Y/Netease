$(function() {
    var initUrl = '/trading/product/getCart/2';
    getlist();
    function getlist() {
        $.ajax({
            url : initUrl,
            type : "get",
            dataType : "json",
            success : function(data) {
                if (data.success) {
                    handleList(data.cart);
                }
            }
        });
    }
    function handleList(data) {
        var html = '';
        data.map(function(item, index) {
            html += '<tr >' +
                '<td>'+item.productName+'</td>'+
                '<td>'+item.count+'</td>'+
                '<td>'+item.price+'</td>'+
                '</tr>'
        });
        $('#cart_list').html(html);
    }
});