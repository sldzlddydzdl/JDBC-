package day20210530;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class BookDto {
	
	// Dto : Data transfer object 
	// 데이타베이스 테이블에 있는 내용을 담아주는 역할
	
	// Table 명에서 books 의 필드를 담을수 객체를 만들어준다.
	
	private int bookId;
	private String title;
	private String sub_title;
	private String publisher;
	private int price;
	private LocalDate publicationDate;
	private LocalDateTime regDate;
	public BookDto(int bookId, String title, String sub_title, String publisher, int price, LocalDate publicationDate,
			LocalDateTime regDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.sub_title = sub_title;
		this.publisher = publisher;
		this.price = price;
		this.publicationDate = publicationDate;
		this.regDate = regDate;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSub_title() {
		return sub_title;
	}
	
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", title=" + title + ", sub_title=" + sub_title + ", publisher="
				+ publisher + ", price=" + price + ", publicationDate=" + publicationDate + ", regDate=" + regDate
				+ "]";
	}
	
	
	

}
