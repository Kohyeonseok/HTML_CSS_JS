package com.wonder.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wonder.www.user.UserVO;
import com.wonder.www.user.impl.UserDAO;

@Controller
public class LoginController{
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("테스트로그인");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인");
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else return "login.jsp";
	}
//	
//	@RequestMapping(value="/login.do", method=RequestMethod.POST)
//	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
//		System.out.println("로그인");
//		UserVO user = userDAO.getUser(vo);
//		if(user != null) {
//			session.setAttribute("userName", user.getName());
//			return "getBoardList.do";
//		}
//		else return "login.jsp";
//	}
}