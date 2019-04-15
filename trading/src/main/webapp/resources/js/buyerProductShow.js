$(function() {
	// 获取productlist URL
	var allProductUrl = '/trading/productadmin/getproductlist';
	var unBoughtProductUrl = '/trading/product/2/unBought';
	var initUrl = allProductUrl;
	getlist();
	function getlist() {
		$.ajax({
			url : initUrl,
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.productList);
				}
			}
		});
	}
	function handleList(data) {
		var html = '';
		data.map(function(item, index) {
                html += '<div class="col-sm-6 col-md-3">' +
                    '<a href="/trading/html/buyer/buyerProductDetail?id='+item.productId+'" class="thumbnail">'+
                    '<img src="'+ item.productImgAddr + '" alt="暂时无法显示" />' +
                    '<div class="caption">'+
                    '<h4>'+ item.productTitle + '</h4>'+
                    '<p>'+item.productPrice +'元</p>'+
                    '</div>'+
                    '</a>'+
                    '</div>'
		});
		$('#products_list').html(html);
	}
    $('#unbought-product').click(function() {
        initUrl = unBoughtProductUrl;
        getlist();
    });
});
