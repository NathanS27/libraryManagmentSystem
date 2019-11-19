package library;

public class Book {

	private String title;
	private String author;
	//true means available, false means checked out
	private Boolean status = true;
	private String checkOutDate;
	private String dueDate;
	private String borrowerName;
	
	public Book(String ttl, String writer) {
	 title=ttl;
	 author=writer;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean b) {
		status=b;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String str) {
		dueDate=str;
	}
	
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String str) {
		checkOutDate=str;
	}
	
	public String getBorrower() {
		return borrowerName;
	}
	public void setBorrower(String str) {
		borrowerName=str;
	}
	
}
