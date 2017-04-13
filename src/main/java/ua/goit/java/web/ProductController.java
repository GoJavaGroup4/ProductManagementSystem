package ua.goit.java.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.goit.java.model.Product;
import ua.goit.java.service.ProductService;

@Controller
@RequestMapping(value = { "/api/product" })
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public void add(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		productService.save(product);
    }
}
