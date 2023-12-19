package com.wonder.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonder.ex.command.Command;
import com.wonder.ex.command.ContentCommand;
import com.wonder.ex.command.ContentModifyCommand;
import com.wonder.ex.command.ContentReplyCommand;
import com.wonder.ex.command.ContentReplyOkCommand;
import com.wonder.ex.command.DeleteCommand;
import com.wonder.ex.command.IdCheckCommand;
import com.wonder.ex.command.JoinOkCommand;
import com.wonder.ex.command.ListCommand;
import com.wonder.ex.command.LogOkCommand;
import com.wonder.ex.command.LogOutCommand;
import com.wonder.ex.command.ModifyCommand;
import com.wonder.ex.command.ModifyOkCommand;
import com.wonder.ex.command.SearchCommand;
import com.wonder.ex.command.WriteOkCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		String commandName = request.getServletPath();
		String viewPage = null;
		Command command = null;
		Boolean flag = true;
		
		if(commandName.equals("/login.do")) {
			viewPage="login.jsp";
			flag=false;
		}else if(commandName.equals("/join_view.do")) {
			viewPage="join_view.jsp";
		}else if(commandName.equals("/joinOK.do")) {
			command = new JoinOkCommand();
			command.execute(request, response);
			viewPage="login.do";
			flag=false;
		}else if(commandName.equals("/LogOK.do")) {
			command = new LogOkCommand();
			command.execute(request, response);
			viewPage="login.do";
			flag=false;
		}else if(commandName.equals("/logout.do")) {
			command = new LogOutCommand();
			command.execute(request, response);
			viewPage = "login.do";
		}else if(commandName.equals("/modify.do")) {
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "modify.jsp";
			flag=false;
		}else if(commandName.equals("/modifyOK.do")) {
			command = new ModifyOkCommand();
			command.execute(request, response);
			viewPage = "login.do";
		}else if(commandName.equals("/list.do")) {
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			flag=false;
		}else if(commandName.equals("/write.do")) {
			viewPage = "write.jsp";
		}else if(commandName.equals("/WriteOk.do")) {
			command = new WriteOkCommand();
			command.execute(request, response);
			viewPage = "list.do?no=1";
		}else if(commandName.equals("/content_view.do")) {
			command = new ContentCommand();
			command.execute(request,response);
			viewPage="content.jsp";
			flag = false;
		}else if(commandName.equals("/delete.do")) {
			command = new DeleteCommand();
			command.execute(request,response);
			viewPage="list.do?no=1";
		}else if(commandName.equals("/contentModify.do")) {
			command = new ContentModifyCommand();
			command.execute(request, response);
			viewPage="list.do?no=1";
		}else if(commandName.equals("/reply.do")) {
			command = new ContentReplyCommand();
			command.execute(request, response);
			viewPage="reply.jsp";
			flag=false;
		}else if(commandName.equals("/contentReplyOK.do")) {
			command = new ContentReplyOkCommand();
			command.execute(request, response);
			viewPage="list.do?no=1";
		}else if(commandName.equals("/searchPost.do")) {
			command = new SearchCommand();
			command.execute(request, response);
			viewPage="search.jsp";
			flag=false;
		}else if(commandName.equals("/idCheck.do")) {
			command = new IdCheckCommand();
			command.execute(request, response);
			viewPage="idCheck.jsp";
			flag=false;
		}
		
		
		if(flag) {
			response.sendRedirect(viewPage);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
