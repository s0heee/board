package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JdbcUtil;

public class BoardDAO {

	private JdbcUtil ju;
	
	
	public BoardDAO() {
		ju = JdbcUtil.getInstance();
	}//생성자
	
	
	//삽입(C)
	public int insert(BoardVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO \"BOARD\"(\"NUM\", \"TITLE\", \"WRITER\", \"CONTENT\", \"REGDATE\", \"CNT\") "
				+ "VALUES(\"BOARD_SEQ\".nextval, ?, ?, ?, SYSDATE, 0)";
		
		int ret = -1;
		
		try {
			conn = ju.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
		}// try-catch-finally
		
		return ret;
		
	}//insert(BoardVO vo)
	
	
	//조회(R)
	public List<BoardVO> selectAll(){
		Connection conn = null;
		
		String sql = "SELECT \"NUM\", \"TITLE\", \"WRITER\", \"CONTENT\", \"REGDATE\", \"CNT\"\r\n"
				+ "FROM BOARD ";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = ju.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				
				list.add(vo);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
		}// try-catch-finally
		
		return list;
		
	}// selectOne()
	
	public BoardVO selectOne(int num){
		Connection conn = null;
		
		String sql = "SELECT \"NUM\", \"TITLE\", \"WRITER\", \"CONTENT\", \"REGDATE\", \"CNT\"\r\n"
				+ "FROM BOARD "
				+ "WEHER ?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		BoardVO vo = null;
		
		try {
			conn = ju.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
			}//if
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}// try-catch
			}// if
			
		}// try-catch-finally
		
		return vo;
		
	}// selectOne()
	
	
	//수정(U)
	
	
	
	//삭제(D)
	
}//end class
