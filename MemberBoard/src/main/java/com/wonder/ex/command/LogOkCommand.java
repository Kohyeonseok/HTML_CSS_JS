package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

@WebServlet("/LogOkCommand")
public class LogOkCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = Dao.getDao();
		Dto dto = new Dto();
		
		request.removeAttribute("logFail");
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("password"));
		
		if(dao.logMatch(dto)==0) {
			HttpSession session = request.getSession();
			session.setAttribute("logId", request.getParameter("id"));
		}else if(dao.logMatch(dto)==1){
			request.setAttribute("logFail", 1);
		}else if(dao.logMatch(dto)==2){
			request.setAttribute("logFail", 2);
		}
	}

}
