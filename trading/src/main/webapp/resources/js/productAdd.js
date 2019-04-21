$(function() {
	var addProductUrl = '/trading/productadmin/addproduct';
	// 提交按钮的事件响应
	$('#submit').click(function(e) {
        e.preventDefault();
		//创建product对象
		var product = {};
		product.productTitle = $('#product_title').val();
		product.productAbstract = $('#product_abstract').val();
		product.productDetail = $('#product_detail').val();
		product.productPrice = $('#product_price').val();
        var imgType = $("input:radio[name='product_imgType']:checked").val();
        product.productImgType = imgType;
        if (imgType == 1) {
            product.productImgAddr = $('#product_image_address').val();
            var formData = new FormData();
        } else {
            var formData = new FormData($('#product')[0]);
        }
		formData.append('productStr', JSON.stringify(product));
		// 将数据提交至后台处理相关操作
		$.ajax({
			url : addProductUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					alert('提交成功！');
				} else {
					alert('提交失败！' + data.errMsg);
				}
			}
		});
	});
});