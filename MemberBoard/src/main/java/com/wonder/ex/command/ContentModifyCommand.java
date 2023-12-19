package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

@WebServlet("/ContentModifyCommand")
public class ContentModifyCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Dao dao = Dao.getDao();
        Dto dto = new Dto();
        
        dto.setNo(Integer.parseInt(request.getParameter("no")));
        dto.setTitle(request.getParameter("title"));
        dto.setContents(request.getParameter("contents"));
        
        dao.updatePost(dto);
        
    }

}
