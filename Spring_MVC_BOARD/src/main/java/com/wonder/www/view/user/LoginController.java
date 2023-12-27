package com.wonder.www.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wonder.www.user.UserVO;
import com.wonder.www.user.UserDAO;

@Controller
public class LoginController{

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO,HttpSession session) {
		System.out.println("로그인 처리");
		
		vo = userDAO.getUser(vo);
		
		if(vo != null) { 
			session.setAttribute("logID",vo);
			return "getBoardList.do";
		}
		else return "login.jsp";
	}
}