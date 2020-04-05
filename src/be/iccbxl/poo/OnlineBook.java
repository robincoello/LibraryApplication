package be.iccbxl.poo;

import java.util.UUID;

public class OnlineBook extends Book {
	private byte maxpeople; 
	private String content;
	public OnlineBook(UUID id, String title, String author, short totalPages, String language, byte maxpeople,
			String content) {
		super(id, title, author, totalPages, language);
		this.maxpeople = maxpeople;
		this.content = content;
	}
	public byte getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(byte maxpeople) {
		this.maxpeople = maxpeople;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "OnlineBook [maxpeople=" + maxpeople + ", content=" + content + "]";
	} 	
}
