package com.wonder.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

@WebServlet("/ContentReplyOkCommand")
public class ContentReplyOkCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
      @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
         Dao dao = Dao.getDao();
         Dto dto = new Dto();
         
         //group step indent id title contents
         
         dto.setId(request.getParameter("id"));
         dto.setTitle(request.getParameter("title"));
         dto.setContents(request.getParameter("contents"));
         dto.setGroupNum(Integer.parseInt(request.getParameter("groupNum")));
         dto.setStepNum(Integer.parseInt(request.getParameter("stepNum")));
         dto.setIndentNum(Integer.parseInt(request.getParameter("indentNum")));
         
         dao.insertReply(dto);
         
    }

}
