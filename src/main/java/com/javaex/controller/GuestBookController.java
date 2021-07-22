package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping(value="/gbc", method = {RequestMethod.GET, RequestMethod.POST})
public class GuestBookController {
	
	private String test = "/gbc";
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println(this.test+"/addList");
		
		GuestBookDao guestBookDao = new GuestBookDao();
		
		List<GuestBookVo> guestBookList = guestBookDao.getList();
		
		model.addAttribute("guestBookList", guestBookList);
		
		String path = "/WEB-INF/views/addList.jsp";
		return path;
	}

	@RequestMapping(value="/insert", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute GuestBookVo guestBookInsert) {
		
		System.out.println(this.test+"/insert");
		
		GuestBookDao guestBookDao = new GuestBookDao();
		guestBookDao.insert(guestBookInsert);
		
		String url = "/gbc/addList";
		return "redirect:" + url;
	}
	
	@RequestMapping(value="/deleteForm", method={RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		System.out.println(this.test+"/deleteForm");
		
		String path = "/WEB-INF/views/deleteForm.jsp";
		return path;
	}

	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("pw") String pw, @RequestParam("no") int no) {
		
		System.out.println(this.test+"/delete");
		
		GuestBookDao guestBookDao = new GuestBookDao();
		guestBookDao.delete(pw, no);
		
		String url = "/gbc/addList";
		return url;
	}
	
}
