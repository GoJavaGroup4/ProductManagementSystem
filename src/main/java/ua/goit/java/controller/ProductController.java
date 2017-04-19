package ua.goit.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.java.model.Product;
import ua.goit.java.service.ProductService;

/**
 * Created by Mala on 4/14/2017.
 */
@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productList", this.productService.getAll());
        return "products";
    }


    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", this.productService.getByID(id));
        model.addAttribute("productList", this.productService.getAll());
        return "products";
    }

    @RequestMapping("productdata/{id}")
    public String productData(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", this.productService.getByID(id));
        return "productdata";
    }
}
