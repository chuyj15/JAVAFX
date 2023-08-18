package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Board {

	private SimpleIntegerProperty boardNo;
	private SimpleStringProperty title;
	private SimpleStringProperty writer;
	private SimpleStringProperty content;
	private SimpleStringProperty regDate;
	private SimpleStringProperty updDate;
	
	public Board() {
		
	}
	
	public Board(int boardNo, String title, String writer,
			String  content, String regDate, String updDate) {
		this.boardNo = new SimpleIntegerProperty(boardNo);
		this.title =new SimpleStringProperty(title);
		this.writer = new SimpleStringProperty(writer);
		this.content = new SimpleStringProperty(content);
		this.regDate = new SimpleStringProperty(regDate);
		this.updDate = new SimpleStringProperty(updDate);
	}
	public int getBoardNo() {
		return boardNo.get();
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = new SimpleIntegerProperty(boardNo);
	}
	public String getTitle() {
		return title.get();
	}
	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}
	public String getWriter() {
		return writer.get();
	}
	public void setWriter(String writer) {
		this.writer = new SimpleStringProperty(writer);
	}
	public String getContent() {
		return content.get();
	}
	public void setContent(String content) {
		this.content = new SimpleStringProperty(content);
	}
	public String getRegDate() {
		return regDate.get();
	}
	public void setRegDate(String  regDate) {
		this.regDate = new SimpleStringProperty(regDate);
	}
	public String getUpdDate() {
		return updDate.get();
	}
	public void setUpdDate(String updDate) {
		this.updDate = new SimpleStringProperty(updDate);
	}
	
	
	
	
}
