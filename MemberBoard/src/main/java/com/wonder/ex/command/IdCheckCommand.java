package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.dao.Dao;

@WebServlet("/IdCheckCommand")
public class IdCheckCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
       
	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Dao dao = Dao.getDao();
        
        String inputId = request.getParameter("id");
        request.removeAttribute("inputResult");
        
       int result = dao.idCheck(inputId);
       
       if(result == 1) {
    	   request.setAttribute("inputResult", 1);
       }else {
    	   request.setAttribute("inputResult", 0);
    	   request.setAttribute("inputId", inputId);
       }
        
    }

}
