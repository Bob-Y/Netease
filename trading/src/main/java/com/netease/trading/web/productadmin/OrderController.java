package com.netease.trading.web.productadmin;

import com.netease.trading.dao.*;
import com.netease.trading.dto.CartItemDto;
import com.netease.trading.dto.UserProduct;
import com.netease.trading.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class OrderController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @GetMapping("/{id}")
    public ModelMap get(@PathVariable Integer id) {
        System.out.println("get single product");
        Product byId = productDao.findById(id);
        ModelMap result = new ModelMap();
        if(null != byId) {
            result.put("success", true);
            result.put("product", byId);
        } else {
            result.put("success", false);
            result.put("errorMsg", "no such product");
        }
        return  result;
    }

    @GetMapping("/user/{id}")
    public Product getBought(@PathVariable Integer id) {
        return productDao.findBoughtById(id);
    }

    @PutMapping("/{id}")
    public Integer replace(@RequestBody Product newResource, @PathVariable Integer id) {
        ModelMap modelMap = new ModelMap();
        int result = productDao.updateProduct(newResource);

        return result;
    }

    @GetMapping("/{id}/all") // /trading/product/1/all
    public ModelMap all(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        List<UserProduct> userProducts = productDao.queryUserProduct(id);
        result.put("success", true);
        result.put("productList",userProducts);
        return result;
    }

    @GetMapping("/{id}/unBought")
    public ModelMap unBought(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        List<Product> products = productDao.queryUnBought(id);
        result.put("success", true);
        result.put("productList", products);
        return result;
    }

    @GetMapping("/{id}/bill")
    public ModelMap bill(@PathVariable Integer id) {
        ModelMap modelMap = new ModelMap();
        List<Order> orders = orderDao.queryUserOrder(id);
        double total_price = 0.0;
        for (Order order : orders) {
            total_price += order.getOrderPrice() * order.getOrderQuantity();
        }
        modelMap.put("success", true);
        modelMap.put("bill", orders);
        modelMap.put("price", total_price);
        return modelMap;
    }

    @RequestMapping(value = "/addOrder/{userId}", method = RequestMethod.GET)
    private ModelMap addOrder(@PathVariable Integer userId, HttpServletRequest request) {
        List<CartItemDto> cart = shoppingCartDao.getCart(userId);
        User user = userDao.findById(userId);
        Integer cart_id = shoppingCartDao.query(userId);
        for(CartItemDto item: cart) {
            int result = orderDao.addOrder(item, user.getUserId());
        }
        cartItemDao.delCart(cart_id);
        shoppingCartDao.delCart(userId);
        ModelMap modelMap = new ModelMap();
        modelMap.put("success", true);
        return modelMap;
    }

    @GetMapping("/{pid}/del")
    public ModelMap del(@PathVariable Integer pid) {
        int result = productDao.deleteProduct(pid);
        ModelMap modelMap = new ModelMap();
        if (result == 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/addToCart/{userId}", method = RequestMethod.POST)
    @ResponseBody
    private ModelMap addToCart(@RequestBody CartItemDto item, @PathVariable Integer userId, HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();

        CartItem cartItem = cartItemDao.query(item.getProductId());
        if(null != cartItem) {
            int newCount = cartItem.getCartItemQuantity() + item.getCount();
            cartItem.setCartItemQuantity(newCount);
            cartItemDao.updateCartItem(cartItem);
        } else {
            Integer cartId = shoppingCartDao.query(userId);
            if(cartId == null) {
                ShoppingCart cart = new ShoppingCart();
                User user = new User();
                user.setUserId(Long.valueOf(userId));
                cart.setShoppingCartUser(user);
                shoppingCartDao.insertShoppingCart(cart);
                cartId = shoppingCartDao.query(userId);
            }
            CartItem newOne = new CartItem();
            Product product = new Product();
            product.setProductId(Long.valueOf(item.getProductId()));
            newOne.setCartId(cartId);
            newOne.setCartItemProduct(product);
            newOne.setCartItemQuantity(item.getCount());
            cartItemDao.insertCartItem(newOne);
        }
        modelMap.put("success", true);
        return modelMap;

    }

    @RequestMapping(value = "/getCart/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getCart(@PathVariable Integer userId, HttpServletRequest request) {
        ModelMap result = new ModelMap();
        List<CartItemDto> cart = shoppingCartDao.getCart(userId);
        result.put("success", true);
        result.put("cart", 	cart);
        return result;

    }

}
