package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JdbcUtil;

public class BoardDAO {

	private JdbcUtil ju;
	
	//삽입(C)
	public int insert(BoardVO vo) {
		Connection conn;
		PreparedStatement pstmt;
		String sql = "INSERT INTO \"BOARD\"(\"NUM\", \"TITLE\", \"WRITER\", \"CONTENT\", \"REGDATE\", \"CNT\") "
				+ "VALUES(\"BOARD_SEQ\".nextval, ?, ?, ?, SYSDATE, 0)";
		
		try {
			conn = ju.getConnection();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}// try-catch
		
		return 0;
		
	}//insert(BoardVO vo)
	
	//수정(R)
	
	
	//조회(U)
	
	
	//삭제(D)
	
}//end class
