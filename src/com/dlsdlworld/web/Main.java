package com.dlsdlworld.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlsdlworld.web.Entities.Member;
import com.dlsdlworld.web.Service.MemberService;


@WebServlet("/main")
public class Main extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member;
		MemberService ms = new MemberService();
		request.setCharacterEncoding("UTF-8"); //��û Encoding ����
		response.setCharacterEncoding("UTF-8"); //���� Encoding ����
		response.setContentType("text/html; charset=UTF-8"); //������ Encoding ����
		
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNick = request.getParameter("userNick");
		member = new Member(userId, userPw, userNick);
		ms.memberInsert(member);
		
		
//		//������Ʈ ��
//		String beforeId = "whiteuserface";
//		String beforePw = "1234";
//		String updateId = "dlsdlworld";
//		String updatePw = "1234";
//		String updateNick = "dlsdl";
//		member = new Member(updateId, updatePw, updateNick);
//		ms.memberUpdate(member, beforeId, beforePw);
//		
//		//���� �� 
//		String deleteId = "dlsdlworld";
//		String deletePw = "1234";
//		ms.memberDelete(deleteId, deletePw);
//		
//		//Id������ȸ ��
//		ArrayList<String> tmp = new ArrayList<>();
//		String findInformationId = "dlsdlworld";
//		String findInformationPw = "1234";
//		tmp = ms.getIdInfomation(findInformationId, findInformationPw);
//		
//		for(String info : tmp) {
//			System.out.println(info);
//		}
	}
}
