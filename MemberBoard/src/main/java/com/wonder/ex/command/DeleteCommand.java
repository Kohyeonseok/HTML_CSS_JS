package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.dao.Dao;

@WebServlet("/DeleteCommand")
public class DeleteCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	Dao dao = Dao.getDao();
    	
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	dao.deletePost(no);
    }

}
