$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var productUrl = baseUrl+'/product/' + productId;
    $.getJSON(productUrl, function(data) {
        if (data.success) {
            var product = data.product;
            $('#product-img').attr('src',product.productImgAddr);

            $('#product-title').text(product.productTitle);
            $('#product-abstract').text(product.productAbstract);
            $('#product-price').text(product.productPrice);

            $('#product-Detail').text(product.productDetail);
        }
    })
})
