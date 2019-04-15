$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var productUrl = baseUrl+'/product/' + productId;
    $.getJSON(productUrl, function(data) {
        if (data.success) {
            var product = data.product;
            $('#product_title').val(product.productTitle);
            $('#product_abstract').val(product.productAbstract);
            $('#product_price').val(product.productPrice);
            $('#product_detail').val(product.productPrice);
        }
    });

    var modifyProductUrl = '/trading/product/'+productId;
    // 提交按钮的事件响应
    $('#submit').click(function() {
        // 创建product对象
        var product = {};
        // 获取表单里的数据并填充进对应的店铺属性中
        product.productTitle = $('#product_title').val();
        product.productAbstract = $('#product_abstract').val();
        product.productDetail = $('#product_detail').val();
        product.productPrice = $('#product_price').val();
        product.productImgAddr = $('#product_image_address').val();
        product.product_imgType = $('#product_imgType').val();
        // if ($('#product_imgType').val().isEqual("1")) {
        //     product.product_imgType = 1;
        // } else {
        //     product.product_imgType = 2;
        // }
        // 将数据提交至后台处理相关操作
        $.ajax({
            url : modifyProductUrl,
            type : 'PUT',
            data : JSON.stringify(product),
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