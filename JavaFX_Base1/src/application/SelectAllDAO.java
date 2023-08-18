package application;

import java.util.ArrayList;
import java.util.List;

public class SelectAllDAO extends JDBConnection{

	public List<Board>selectAll(){
		List<Board> boardList = new ArrayList<>();
		String sql = "SELECT no,title,writer,regDate,updDate FROM joeun.bboard";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("regDate"));
				board.setUpdDate(rs.getString("updDate"));
				
				boardList.add(board);
				
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return boardList;
	}
	
}
