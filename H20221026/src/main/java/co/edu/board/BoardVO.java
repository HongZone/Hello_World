package co.edu.board;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private int clickCnt;
	private String image;
}
