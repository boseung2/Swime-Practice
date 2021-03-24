package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controller_method {
	
	void processCookie(String id, String remember_id, HttpServletResponse response, HttpServletRequest request) {
		boolean check = remember_id != null;
		Cookie[] cookies = request.getCookies();
		
		if (check) {
			Cookie c = new Cookie("id", id);
			c.setMaxAge(60 * 60);
			c.setPath("/");
			response.addCookie(c);
		}
		else if (!check && cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("id")) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
					break;
				}
			}
		}
	} // end method processCookie
	

	
	void print_page(HttpServletRequest request) {
		System.out.println(new SimpleDateFormat("HH:MM").format(new Date()) + " | " + request.getServletPath());
	}
	
} // class
