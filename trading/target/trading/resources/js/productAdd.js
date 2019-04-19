/**
 * 
 */
$(function() {
	
	var addProductUrl = '/trading/productadmin/addproduct';
	// 提交按钮的事件响应
	$('#submit').click(function() {
		// 创建product对象
		var product = {};
		// 获取表单里的数据并填充进对应的店铺属性中
		product.productTitle = $('#product_title').val();
		product.productAbstract = $('#product_abstract').val();
		product.productDetail = $('#product_detail').val();
		product.productPrice = $('#product_price').val();
		// product.productImgAddr = $('#product_image_address').val();
        product.productImgType = $("input[name='product_imgType']:checked").val();
        if ($('#product_imgType').val().isEqual("1")) {
            product.productImgAddr=$('product_image_address').val();
        } else {
            product.productImgAddr=$('product_image_local').attr("src");
        }
		var formData = new FormData();
		// 将shop json对象转成字符流保存至表单对象key为shopStr的的键值对里
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