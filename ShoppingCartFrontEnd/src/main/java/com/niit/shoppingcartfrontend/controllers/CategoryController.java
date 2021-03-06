package com.niit.shoppingcartfrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.util.Util;

@Controller
public class CategoryController {

@Autowired
private Category category;

@Autowired
private CategoryDAO categoryDAO;



@RequestMapping(value = "/categories", method = RequestMethod.GET)
public String listCategories(Model model) {
	model.addAttribute("category", category);
	model.addAttribute("categoryList", this.categoryDAO.list());
	return "category";
	
}

@RequestMapping(value = "/category/add", method = RequestMethod.POST)
public String addCategory(@ModelAttribute("category") Category category) {

	Util util = new Util();
	String id=  util.replace(category.getId(), ",", "");
	category.setName(id);
	categoryDAO.saveOrUpdate(category);
	return "redirect:/manageCategories";

}

@RequestMapping("category/remove/{id}")
public String deleteCategory(@PathVariable("id") String id, ModelMap model) {
		categoryDAO.delete(id);
		return "redirect:/manageCategories";
}


@RequestMapping("category/edit/{id}")
public String editCategory(@PathVariable("id") String id, Model model) {
	System.out.println("editCategory");
	model.addAttribute("category", this.categoryDAO.get(id));
	model.addAttribute("listCategorys", this.categoryDAO.list());
	return "category";
}
}
