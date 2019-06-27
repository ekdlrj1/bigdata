package com.gg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gg.db.DBClass;
import com.gg.vo.MemberVO;

/**
 * Servlet implementation class LoginOkServlet
 */
@WebServlet("/RegOkServlet")
public class RegOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String passwd = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println(email);
		System.out.println(passwd);
		System.out.println(name);
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPasswd(passwd);
		vo.setName(name);
		
		DBClass dbc = new DBClass();
		try {
			dbc.dbConnect();
			dbc.dbInsert(vo);
			dbc.closeAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("login.gg");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
