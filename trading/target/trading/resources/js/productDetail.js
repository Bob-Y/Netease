$(function () {
    //从地址栏的url中获取商品id
    var productId = getQueryString('id');
    //获取商品信息的url
    var productUrl = '/trading/product/' + productId;
    $.getJSON(productUrl,function (data) {
        if (data.success){
            var product = data.product;
            $('#product-img').attr('src',product.product_image_address);

            $('#product-title').text(product.product_title);
            $('#product-abstract').text(product.product_abstract);
            $('#product-price').text(product.product_price);

            $('#product-Detail').text(product.product_detail);
        }
    })
})
