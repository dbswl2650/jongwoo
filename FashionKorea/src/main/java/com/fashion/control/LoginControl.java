package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("로그인 시도: ID=" + id + ", PW=" + pw);
		System.out.println(id + pw);
		
		LoginDAO ldao = new LoginDAO();
		MemberVO loginResult = ldao.login(id, pw);
		if (loginResult != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", id);
			session.setAttribute("member_no", loginResult.getMemberNo());
			
			// 로그인 성공 시 메인 페이지로 이동
			response.sendRedirect("main.ko");		
		} else {
			// 로그인 실패 시 로그인 폼으로 이동
			response.sendRedirect("loginForm.ko");
		}
	}

}
