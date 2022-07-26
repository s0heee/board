package board;

import java.util.Date;

public class BoardVO {

	private Integer num;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private Integer cnt;
	
	
	public BoardVO() {
	
	}//default 생성자
	
	public BoardVO(Integer num, String title, String writer, String content, Date regdate, Integer cnt) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}// 생성자
	
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}//toString()
	
	
}// end class
