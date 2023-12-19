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


@WebServlet("/ContentReplyCommand")
public class ContentReplyCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		Dao dao = Dao.getDao();
		Dto dto = new Dto();
		Dto sDto = new Dto();
		
		HttpSession session = request.getSession();
		
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		
		
		dao.selectPost(dto);
		sDto = dao.selectInfo((String)session.getAttribute("logId"));
		
		request.setAttribute("dto", dto);
		request.setAttribute("sDto", sDto);
    }

}
