package com.gg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("*.gg")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
//		StringBuffer url = request.getRequestURL();

//		System.out.println(uri);
//		System.out.println(request.getContextPath());
//		System.out.println("내 context 길이? " + request.getContextPath().length());
//		
//		System.out.println(uri.substring(request.getContextPath().length()+1));
		String site = "";
		String uri2 = uri.substring(request.getContextPath().length() + 1);
		if (uri2.equals("main.gg")) {
			site = "MainServlet";
		} else if (uri2.equals("login.gg")) {
			site = "LoginServlet";
		} else if (uri2.equals("login_ok.gg")) {
			site = "LoginOkServlet";
		} else if (uri2.equals("logout.gg")) {
			site = "LogoutServlet";
		} else if (uri2.equals("reg.gg")) {
			site = "RegServlet";
		} else if (uri2.equals("reg_ok.gg")) {
			site = "RegOkServlet";
		} else if (uri2.equals("start.gg")) {
			site = "StartServlet";
		} else if (uri2.equals("nvapi.gg")) {
			site = "NvAPIServlet";
		} else if (uri2.equals("daum.gg")) {
			site = "DaumMovieServlet";
		} else if (uri2.equals("today.gg")) {
			site = "TodayServlet";
		} else if (uri2.equals("naver.gg")) {
			site = "NaverServlet";
		} else {
			site = "잘못된 요청";
		}
		System.out.println(site);
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
