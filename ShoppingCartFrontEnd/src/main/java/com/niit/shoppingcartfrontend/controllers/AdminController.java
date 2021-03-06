package com.niit.shoppingcartfrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class AdminController {

@Autowired
Product product;

@Autowired
ProductDAO productDAO;


@Autowired
Supplier supplier;

@Autowired
SupplierDAO supplierDAO;

@Autowired
Category category;

@Autowired
CategoryDAO categoryDAO;


@RequestMapping("/manageCategories")
public ModelAndView categories() {
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("category", category);
	mv.addObject("isAdminClickedCategories", "true");
	mv.addObject("categoryList", categoryDAO.list());
	return mv;
}

@RequestMapping("/manageProducts")
public ModelAndView suppliers() {
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("product", product);
	mv.addObject("isAdminClickedProducts", "true");
	mv.addObject("productList", productDAO.list());
	return mv;
}

@RequestMapping("/manageSuppliers")
public ModelAndView products() {
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("supplier", supplier);
	mv.addObject("isAdminClickedSuppliers", "true");
	mv.addObject("supplierList", supplierDAO.list());
	return mv;
}
}
