package be.iccbxl.poo;

import java.util.UUID;

public class GraphicNovel extends Book {
	private String cartoonist; // Why dont use a person?
	private boolean color;
	public GraphicNovel(UUID id, String title, String author, short totalPages, String language, String cartoonist,
			boolean color) {
		super(id, title, author, totalPages, language);
		this.cartoonist = cartoonist;
		this.color = color;
	}
	public String getCartoonist() {
		return cartoonist;
	}
	public void setCartoonist(String cartoonist) {
		this.cartoonist = cartoonist;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "GraphicNovel [cartoonist=" + cartoonist + ", color=" + color + "]";
	} 
	

}
