$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var userProductUrl = baseUrl + 'product/' + productId;
    $.getJSON(userProductUrl, function(data) {
        if (data.success) {
            var userProduct = data.product;
            $('#product-img').attr('src',userProduct.productImgAddr);
            $('#product-title').text(userProduct.productTitle);
            $('#product-abstract').text(userProduct.productAbstract);
            $('#product-price').text(userProduct.productPrice);
            $('#product-detail').text(userProduct.productDetail);
            var html = '';
            if (userProduct.hasBought) {
                html += '<button type="button" disabled="disabled">已购买</button>'
            } else {
                html += '<button type="button" id="add-to-cart">加入购物车</button>'
            }
            $('#user-button').html(html);
        }
    })
});
