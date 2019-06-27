package com.gg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gg.vo.MovieVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class NaverServlet
 */
@WebServlet("/NaverServlet")
public class NaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public ArrayList<MovieVO> getNaver() {
		String selector = "";
		String selector2 = "";
		Document doc = null;
		try {
			// 1. URL 선언
			String connUrl = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=장마";
			// 2. HTML 가져오기
			selector = "a._sp_each_title";
			selector2 = "div.thumb img";
			doc = Jsoup.connect(connUrl).get();
			// 3. 가져온 HTML Document 를 확인하기​
			System.out.println(doc.toString());
		} catch (IOException e) {
			// Exp : Connection Fail
			e.printStackTrace();
		}
		Elements titles = doc.select(selector);
		Elements img = doc.select(selector2);// 2. doc에서 selector의 내용을 가져와 Elemntes 클래스에 담는다.
		String findstr = "http";
		int cnt = 0;

		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		for (Element element : titles) { // 3. Elemntes 길이만큼 반복한다.
			MovieVO mv = new MovieVO();
			Element ele = img.get(cnt++);
			String imgsrc = ele.attr("src");
			mv.setImg(imgsrc.substring(imgsrc.indexOf(findstr)));
			mv.setTitle(element.text());
			mv.setLink(element.attr("href"));// 4. 원하는 요소가 출력된다.
			list.add(mv);
		}
		return list;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MovieVO> list = getNaver();
		Gson gson = new Gson();
		String jsonPlace = gson.toJson(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonPlace);

		
		request.setAttribute("mvlist", jsonPlace);
//		RequestDispatcher dis = request.getRequestDispatcher("daum.jsp");
//		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
