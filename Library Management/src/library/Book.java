package library;

public class Book {

	private String title;
	private String author;
	private Date checkOutDate = new Date();
	private Date dueDate = new Date();
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
	
	public Boolean isAvailable() {
		return borrowerName==null;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	public void setCheckOutDate(Date inputDate) throws ImproperFormatException {
		checkOutDate = inputDate;
		dueDate= new Date(inputDate);
		dueDate.dateAdd(14);
	}
	
	public String getBorrower() {
		return borrowerName;
	}
	public void setBorrower(String str) {
		borrowerName=str;
	}
	
	public Boolean isOverdue() {
		//if dueDate is before today 
		return getDueDate().isLessThan(new Date().today());
	}
	
	private String statusCheck(Boolean b) {
		if(b) {
			return " <font color='green'> AVAILABLE</font>";
		}
		return "<font color='red'> CHECKED OUT</font>";
	}
	
	public String displayBook() {
		return String.format("<html>%s, %s: %s<html>", getTitle(),getAuthor(),statusCheck(isAvailable()));
	}
	
}


