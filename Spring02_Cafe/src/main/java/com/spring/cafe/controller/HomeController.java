package com.spring.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.cafe.DAO.CafeDAO;
import com.spring.cafe.DTO.CafeDTO;

@Controller
public class HomeController {
	
	public CafeDAO cafeDAO;
	@Autowired
	public HomeController(CafeDAO cafeDAO) {
		this.cafeDAO = cafeDAO;
	}
	
	@RequestMapping("/")
	public String getHome() {
		return "home";
	}
	
	@RequestMapping("/inputMenu/{pname}/{price}")
	public String inputMenu(@PathVariable String pname, @PathVariable int price) {
		CafeDTO newCafeMenu = new CafeDTO(pname, price);
		try {
			cafeDAO.insertMenu(newCafeMenu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inputMenu";
	}
	
	@RequestMapping("/outputMenu")
	public String outputMenu(Model model) {
		try {
			List<CafeDTO> cafeMenuList  = cafeDAO.selectAllMenu();
			model.addAttribute(cafeMenuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "outputMenu";
	}
	
	@RequestMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable int id, Model model) {
		try {
			cafeDAO.deleteMenu(id);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "outputMenu";
	}
	
}
