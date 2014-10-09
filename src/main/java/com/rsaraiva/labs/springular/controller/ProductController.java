package com.rsaraiva.labs.springular.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rsaraiva.labs.springular.dao.ProductDAO;
import com.rsaraiva.labs.springular.model.Product;

@Controller
public class ProductController {

	@RequestMapping("/product/lista")
	public ModelAndView lista() {
		List<Product> products = new ProductDAO().lista();
		ModelAndView mv = new ModelAndView("product/lista");
		mv.addObject("products", products);
		return mv;
	}
	
	@RequestMapping("/product/form")
	public String form() {
		return "product/form";
	}
	
	@RequestMapping("/product/save")
	public String save(Product product) {
		new ProductDAO().adiciona(product);
		return "redirect:lista";
	}
	
	@RequestMapping("/product/remove")
	public String remove(Product product) {
		new ProductDAO().remove(product);
		return "redirect:lista";
	}
}
