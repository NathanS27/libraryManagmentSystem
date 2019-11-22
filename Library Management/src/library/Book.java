package library;

public class Book {

	private String title;
	private String author;
	//true means available, false means checked out
	private Boolean isAvailable = true;
	private Date date = new Date();
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
		//compare due date to current date
		return isAvailable;
	}
	public void setStatus(Boolean b) {
		isAvailable=b;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setCheckOutDate(Date inputDate) throws ImproperFormatException {
		date = inputDate;
	}
	
	public String getBorrower() {
		return borrowerName;
	}
	public void setBorrower(String str) {
		borrowerName=str;
	}
	
	public Boolean isOverdue() throws ImproperFormatException {
		if(date.isGreaterThan(date.getCurrentDate())) {
			return true;
		}
		return false;
	}
	
}


