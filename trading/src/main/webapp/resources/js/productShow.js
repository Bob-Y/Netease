/**
 * 
 */

	$(function() {
		// 获取productlist URL
		var initUrl = '/trading/productadmin/getproductlist';
//		alert(initUrl)
		getlist();
		function getlist() {
			$.ajax({
				url : initUrl,
				type : "get",
				dataType : "json",
				success : function(data) {
					if (data.success) {
//						alert("success")
						handleList(data.productList);
						//handleCount(data.count)
					}
				}
			});
		}
		function handleCount(data) {
			$('#count').text(data);
		}
		function handleList(data) {
//			var html = '<div class="row">';
			var html = '';
			data.map(function(item, index) {
				html += '<div class="col-sm-6 col-md-3">' + 
							'<div href="#" class="thumbnail">'+
								'<img src="'+
								item.productImgAddr + '" alt="暂时无法显示" />' +
								'<div class="caption">'+
									'<h4>'+ item.productTitle + '</h4>'+
									'<p>'+item.productPrice +'元</p>'+
								'</div>'+
							'</div>'+
						'</div>'

			});
//			html += '</div>'
			$('#products_list').html(html);
		}
	});
