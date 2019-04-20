$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var productUrl = baseUrl + 'product/' + productId;
    $.getJSON(productUrl, function(data) {
        if (data.success) {
            var product = data.product;
            $('#product_title').val(product.productTitle);
            $('#product_abstract').val(product.productAbstract);
            if (product.productImgType == 1){
                // $("input[value='1']").attr("checked","checked");
                $("input:radio[name='product_imgType']").get(0).checked = true;
            } else {
                // $("input[value='2']").attr("checked","checked");
                $("input:radio[name='product_imgType']").get(1).checked = true;
            }
            $('#product_image_address').val(product.productImgAddr);
            $('#product_price').val(product.productPrice);
            $('#product_image_address').val(product.productImgAddr);
            $('#product_detail').val(product.productDetail);
        }
    });

    var modifyProductUrl = baseUrl + 'productadmin/modifyproduct/' + productId;
    // 提交按钮的事件响应
    $('#submit').click(function() {
        // 创建product对象
        var product = {};
        // 获取表单里的数据并填充进对应的商品属性中
        product.productId = productId;
        product.productTitle = $('#product_title').val();
        product.productAbstract = $('#product_abstract').val();
        product.productDetail = $('#product_detail').val();
        product.productPrice = $('#product_price').val();
        product.productImgAddr = $('#product_image_address').val();
        product.productImgType = $('#product_imgType').val();
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
            contentType : 'application/json; charset=utf-8',
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