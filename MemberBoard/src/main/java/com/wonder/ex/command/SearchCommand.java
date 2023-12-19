package com.wonder.ex.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

@WebServlet("/SearchCommand")
public class SearchCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = Dao.getDao();
		Dto dto = new Dto();

		String searchOpt = request.getParameter("select");
		String searchInfo = request.getParameter("search");
		
		dto.setSearchInfo(searchInfo);
		dto.setSelectOpt(searchOpt);
		
		ArrayList<Dto> list = dao.searchPost(dto);
		request.setAttribute("sList", list);

	}

}
