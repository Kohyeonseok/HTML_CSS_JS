package com.wonder.ex.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wonder.ex.dao.Dao;
import com.wonder.ex.dto.Dto;

public class JoinOkCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Dao dao = Dao.getDao();
        Dto dto = new Dto();
        
        
        dto.setName(request.getParameter("name"));
        dto.setId(request.getParameter("id"));
        dto.setNickName(request.getParameter("nickName"));
        dto.setPw(request.getParameter("password"));
        dto.setEmail(request.getParameter("email"));
        dto.setPostcode(request.getParameter("sample4_postcode"));
        dto.setRoadAddress(request.getParameter("sample4_roadAddress"));
        dto.setJibunAddress(request.getParameter("sample4_jibunAddress"));
        dto.setDetailAddress(request.getParameter("sample4_detailAddress"));
        dto.setExtraAddress(request.getParameter("sample4_extraAddress"));
        dto.setBirthYear(Integer.parseInt(request.getParameter("birthYear")));
        dto.setBirthMonth(Integer.parseInt(request.getParameter("birthMonth")));
        dto.setBirthDay(Integer.parseInt(request.getParameter("birthDay")));
        dto.setPhoneNum(request.getParameter("phoneNum"));
        dto.setGender(request.getParameter("gender"));
        
        dao.joinMember(dto);
  
    }

}
