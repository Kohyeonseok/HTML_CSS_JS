package com.wonder.ex.command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

public class ListCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
         Dao dao = Dao.getDao();
         int no = Integer.parseInt(request.getParameter("no"));
         ArrayList<Dto> list = dao.listDao(no);
         
         int page = (int) Math.ceil(dao.countPost()/10.0);
         request.setAttribute("page", page);
         request.setAttribute("list", list);
    }

}
