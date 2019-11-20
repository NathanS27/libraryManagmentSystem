package library;

public class Book {

	private String title;
	private String author;
	//true means available, false means checked out
	private Boolean isAvailable = true;
	private String checkOutDate;
	//make them date classes
	private String dueDate;
	private String borrowerName;
	private Date date;
	
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
	
	public String getDueDate() {
		return dueDate;
	}

	
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String str) throws ImproperFormatException {
		date = new Date(str);
		checkOutDate=date.getStartDate();
		dueDate=date.getDueDate();
	}
	
	public String getBorrower() {
		return borrowerName;
	}
	public void setBorrower(String str) {
		borrowerName=str;
	}
	
}


