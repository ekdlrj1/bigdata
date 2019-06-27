package com.gg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gg.vo.MemberVO;

public class DBClass {
	// 멤버 변수
	Connection conn = null;
	PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
	ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
	// 멤버 메소드
	// db 연결 테스트

	public void dbConnect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/mydb";
		conn = DriverManager.getConnection(url, "root", "1234");
		System.out.println("연결 성공");
	}

	// db insert 테스트
	public void dbInsert(MemberVO vo) throws Exception {
		String SQL = "INSERT INTO member (userid, passwd, name) VALUES (?, ?, ?)";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, vo.getEmail());
		pstmt.setString(2, vo.getPasswd());
		pstmt.setString(3, vo.getName());
		int r = pstmt.executeUpdate();
		System.out.println("변경된 row : " + r);
	}

	// db select
	public MemberVO dbSelect(String email, String pw) throws Exception {
		MemberVO vo = new MemberVO();
		String SQL = "SELECT * FROM member WHERE userid = ? AND passwd = ?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, email);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			vo.setEmail(rs.getString("userid"));
			vo.setName(rs.getString("passwd"));
			vo.setPasswd(rs.getString("name"));
		}
		return vo;
	}

	public void dbUpdate(String name, String price) throws Exception {
		String SQL = "UPDATE cup_lm_tb SET price=? WHERE  name=?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, price);
		pstmt.setString(2, name);
		int r = pstmt.executeUpdate();
		System.out.println("변경된 row : " + r);
	}

	public void dbDelete(String name) throws Exception {
		String SQL = "DELETE FROM cup_lm_tb WHERE  name=?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, name);
		int r = pstmt.executeUpdate();
		System.out.println("변경된 row : " + r);
	}

	public void closeAll() {
		// 사용순서와 반대로 close 함
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
