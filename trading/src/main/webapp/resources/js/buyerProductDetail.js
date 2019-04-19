$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var userProductUrl = baseUrl + 'product/userproduct/' + productId;
    $.getJSON(userProductUrl, function(data) {
        if (data.success) {
            var userProduct = data.product;
            $('#product-img').attr('src',userProduct.productImgAddr);
            $('#product-title').text(userProduct.productTitle);
            $('#product-abstract').text(userProduct.productAbstract);
            $('#product-price').text(userProduct.productPrice);
            $('#product-detail').text(userProduct.productDetail);
            var html = '';
            if(userProduct.hasBought) {
                html += '<button type="button" disabled="disabled">已购买</button>'
            } else {
                html += '<button type="button" id="add-to-cart">加入购物车</button>'
            }
            $('#user-button').html(html);
            $('#add-to-cart').click(function() {
                var cartItemDto = {};
                // 获取表单里的数据并填充进对应的店铺属性中
                cartItemDto.productId = productId;
                cartItemDto.productName = $('#product_title').val();
                cartItemDto.count = $('#count').val();
                cartItemDto.price = $('#product-price').val();
                var addToCartUrl = baseUrl + 'product/addToCart/2';
                $.ajax({
                    url : addToCartUrl,
                    type : 'POST',
                    data : JSON.stringify(cartItemDto),
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
        }
    });
    var priceUrl = baseUrl + 'product/price/' + productId;
    $.getJSON(priceUrl, function(data) {
        if (data.success) {
            $('#order-price').text(data.price);
        }
    });

});
