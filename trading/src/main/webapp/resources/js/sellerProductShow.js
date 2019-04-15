$(function() {
	// 获取productlist URL
	// var initUrl = '/trading/productadmin/getproductlist';
    var initUrl = '/trading/product/2/all';
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
			if(item.hasBought) {
                html += '<div class="col-sm-6 col-md-3">' +
                    '<a href="/trading/html/seller/sellerProductDetail?id='+item.productId+'" class="thumbnail">'+
                    '<img src="'+ item.productImgAddr + '" alt="暂时无法显示" />' +
                    '<div class="caption">'+
                    '<h4>'+ item.productTitle + '</h4>'+
                    '<p>'+item.productPrice +'元</p>'+
                    '</div>'+
                    '</a>'+
					'<div class="sell-tag">已购买</div>'+
                    '</div>'
			} else {
                html += '<div class="col-sm-6 col-md-3">' +
                    '<a href="/trading/html/seller/sellerProductDetail?id='+item.productId+'" class="thumbnail">'+
                    '<img src="'+ item.productImgAddr + '" alt="暂时无法显示" />' +
                    '<div class="caption">'+
                    '<h4>'+ item.productTitle + '</h4>'+
                    '<p>'+item.productPrice +'元</p>'+
                    '</div>'+
                    '</a>'+
                    '</div>'
			}

		});
		$('#products_list').html(html);
	}
});
