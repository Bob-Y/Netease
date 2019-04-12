package com.netease.trading.web.productadmin;

import com.netease.trading.dao.OrderDao;
import com.netease.trading.dao.ProductDao;
import com.netease.trading.dao.UserDao;
import com.netease.trading.dto.CartItemDto;
import com.netease.trading.dto.UserProduct;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.Product;
import com.netease.trading.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        int result = productDao.updateProduct(newResource);
        return result;
    }

    @GetMapping("/{id}/all")
    public List<UserProduct> all(@PathVariable Integer id) {
        return productDao.queryUserProduct(id);
    }

    @GetMapping("/{id}/unBought")
    public List<Product> unBought(@PathVariable Integer id) {
        return productDao.queryUnBought(id);
    }

    @GetMapping("/{id}/bill")
    public ModelMap bill(@PathVariable Integer id) {
        ModelMap modelMap = new ModelMap();
        List<Order> orders = orderDao.queryUserOrder(id);
        double total_price = 0.0;
        for (Order order : orders) {
            total_price += order.getOrderPrice() * order.getOrderQuantity();
        }
        modelMap.addAttribute("bill", orders);
        modelMap.addAttribute("price", total_price);
        return modelMap;
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    private ModelMap addOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");
        String username = (String) session.getAttribute("user");
        User user = userDao.findUser(username);
        for(CartItemDto item: cart) {
            int result = orderDao.addOrder(item, user.getUserId());
        }
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

}
