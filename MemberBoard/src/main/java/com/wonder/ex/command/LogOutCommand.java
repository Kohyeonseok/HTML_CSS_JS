package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOutCommand")
public class LogOutCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
       
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	HttpSession session = request.getSession();
		session.invalidate();
    }

}
