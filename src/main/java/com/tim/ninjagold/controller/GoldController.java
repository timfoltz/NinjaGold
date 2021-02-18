package com.tim.ninjagold.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {

	String pattern = "MMMMM dd yyyy hh:mm a";
	SimpleDateFormat  timeStamp = new SimpleDateFormat(pattern);
	String now = timeStamp.format(new Date());
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("newVisit")==null) {
			session.setAttribute("myGold", 0);
			session.setAttribute("activities", "No activities "+ now + ",     ");
			session.setAttribute("newVisit", false);
			String activites = (String) session.getAttribute("activites");
			return "index.jsp";
			
		}
		String activites = (String) session.getAttribute("activites");
		System.out.println(now);
		return "index.jsp";
	}
	
	@RequestMapping(path="/findGold", method=RequestMethod.POST)
	public String findGold(HttpSession session, @RequestParam String place) {
		System.out.println(place);
		session.setAttribute("place", place);
		String activities = (String) session.getAttribute("activities");
		Random n = new Random();
		Integer myGold = (Integer) session.getAttribute("myGold");
		
		if(place.equals("farm")) {
			Integer gold = n.nextInt(20-10)+10;
			session.setAttribute("activities", "Farmed " + gold + " gold " + now + ",     " + activities);
			session.setAttribute("myGold", myGold + gold );
			return "redirect:/";
		}
		if(place.equals("cave")) {
			Integer gold = n.nextInt(11-5)+5;
			session.setAttribute("activities", "Caved " + gold + " gold " + now + ",     " + activities);
			session.setAttribute("myGold", myGold + gold);
			return "redirect:/";
		}
		if(place.equals("house")) {
			Integer gold = n.nextInt(11-5)+5;
			session.setAttribute("activities", "Housed " + gold + " gold " + now + ",     " + activities);

			session.setAttribute("myGold", myGold + gold);
			return "redirect:/";
		}
		else {
			Integer gold = n.nextInt(50+50)-50;
			session.setAttribute("activities", "Casino " + gold + " gold " + now + ",     " + activities);
			session.setAttribute("myGold", myGold + gold );
			return "redirect:/";
		}
	
	
		
		
	}
	
		
		
	
	
	@RequestMapping("/reset")
	public String reset(HttpSession session, Model model) {
		
			
			session.setAttribute("newVisit", null);
			return "redirect:/";
		
		
	}
	
	
}
