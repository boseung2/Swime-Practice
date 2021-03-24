package org.zerock.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CustomDao;
import dao.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	String msg = "";
	controller_method cm = new controller_method();
	CustomDao cd = new CustomDao(); 
	
	@RequestMapping(value = {"/*","/*/*"})
	public String defaultPage(HttpServletRequest request,
			@ModelAttribute("from") String from,
			@ModelAttribute("msg") String msg,
			@ModelAttribute User user) {
		cm.print_page(request);
		return request.getServletPath();
	}

//	@RequestMapping("/index")
//	public void index(HttpServletRequest request) {
//		cm.print_page(request);
//	}
//
//	@RequestMapping("/LoginForm")
//	public void LoginForm(@ModelAttribute("from") String from, HttpServletRequest request) {
//		cm.print_page(request);
//	}

	@RequestMapping("/LoginAction")
	public String LoginAction(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, 
			@ModelAttribute("from") String from, String id, String password, String remember_id) {
		cm.print_page(request);

		try {
			Object[] isnull = cd.isNull_value(id, password);
			boolean is_idpw = cd.isIdPw(id, password);
			
			
			// 아이디 널체크
			if ((boolean) isnull[0]) {
				model.addAttribute("msg", (String) isnull[1]);
				return "/LoginForm";
			}
			// 아이디, 비밀번호가 틀리면
			else if (!is_idpw) {
				model.addAttribute("msg", "Please check ID and Password");
				return "/LoginForm";
			}
			// 아이디, 비밀번호가 맞으면
			else if (is_idpw) {
				session.setAttribute("MEMBERID", id);
				cm.processCookie(id, remember_id, response, request);
				return "".equals(from) ? "/index" : from;
			}
		}
		catch (Exception e) {
			model.addAttribute("msg", "에러가 발생했습니다" + e);
			return "/LoginForm";
		}
		
		return "/index";
	}

	@RequestMapping("/Logout")
	public String Logout(HttpServletRequest request, HttpSession session) {
		cm.print_page(request);
		session.invalidate();
		return "/index";
	}

//	@RequestMapping("/Resister")
//	public void Resister(HttpServletRequest request, String msg, 
//			@ModelAttribute User user) {
//		cm.print_page(request);
//	}

	@RequestMapping("/ResisterAction")
	public String ResisterAction(HttpServletRequest request, Model model, 
			@ModelAttribute User user) {
		cm.print_page(request);
		
		try {
			Object[] check_null = cd.isNull_value(user);
			boolean already = cd.alreadyId(user.getId());
			boolean result = cd.ismakeUser(user);
			
			if((boolean) check_null[0]) {
				model.addAttribute("msg", (String)check_null[1]);
				return "/Resister";
			}
			else if(already) {
				model.addAttribute("msg", "Please another ID");
				return "/Resister";
			}
			else if (result) {
				model.addAttribute("msg", "success Make ID");
				return "/LoginForm";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "에러가 발생했습니다" + e);
			return "/Resister";
		}
		
		return "";
	}
	
	@RequestMapping("/Board/*")
	public String board(HttpSession session, HttpServletRequest request, Model model) {
		cm.print_page(request);
		String url = request.getServletPath();
		boolean login = session.getAttribute("MEMBERID") != null;
		
		if(!login) {
			model.addAttribute("from", url);
			return "/LoginForm";
		}else {
			return url;
		}
	}
	
	
	
	
	
	@RequestMapping("/test/*")
	public String testpage(HttpServletRequest request, Model model,
			@ModelAttribute("msg") String msg, String redirect, String modelmsg, @ModelAttribute("hrefmsg") String hrefmsg,String hrefmsg2) {
		cm.print_page(request);
		
		if (redirect != null) {
			model.addAttribute("modelmsg", "test1234");
			System.out.println("테스트 페이지 리다이렉트");
			return "redirect:"+request.getServletPath();
		} else {
			return request.getServletPath();
		}
	}
	
//	@RequestMapping("/StudyInfomation/*")
//	public String request(HttpServletRequest request) {
//		cm.print_page(request);
//		return request.getServletPath();
//	}
	
	
	
	
/*
	@RequestMapping("/hello2")
	// 매개변수로 필요한것들을 선언하면 디스패쳐서블릿이 채워줌
	public void main2(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>hello</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@RequestMapping("/hello3")
	public void main3(HttpServletResponse response, HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>id = " + id + "</h1>");
		out.println("<h1>pwd = " + pwd + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@RequestMapping("/hello4")
	public String main4(String id, String pwd, Model model) throws IOException {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "hello";
	}

	@RequestMapping("/hello5")
	public void main5(String name, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
	}

	@RequestMapping("/hello6")
	public void main6(String name, int age, @DateTimeFormat(pattern = "yyyy/MM/dd") int birth, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("birth", birth);
	}

	@RequestMapping("/hello7")
	public String main7(@ModelAttribute("name") String name, @ModelAttribute("age") int age,
			@ModelAttribute("birth") Date birth, Model model) {
//		model.addAttribute("name",name);
//		model.addAttribute("age",age);
//		model.addAttribute("birth",birth);
		return "hello6";
	}
*/


} // end class
