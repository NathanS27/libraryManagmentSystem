package library;

public class Date {

	private int[] startDate = new int[3];
	
	public Date(int m, int d, int y) {
		startDate = new int[3];
		startDate[0]=m;
		startDate[1]=d;
		startDate[2]=y;
	}
	public Date(String dateInput) {
		String[] dateRaw =dateInput.split("/");
		startDate[0]=Integer.parseInt(dateRaw[0]);
		startDate[1]=Integer.parseInt(dateRaw[1]);
		startDate[2]=Integer.parseInt(dateRaw[2]);
	}
	public String getStartDate() {
		return print(startDate);
	}
	public String getDueDate() {
		return print(dateAdd(14,startDate));
	}
	
	private String print(int[] date) {
		return date[0]+"/"+date[1]+"/"+date[2];
	}
	
	private int[] dateAdd(int days,int[] date) {
		int daysOver;
		date[1]+=days;
//		February2 - 28 days in a common year and 29 days in leap years
		if(date[0]==2) {
			
		}
//		January1,March3,May5,July7,August8,October10,December12 - 31 days
		else if((date[0]==1)||(date[0]==3)||(date[0]==5)||(date[0]==7)||(date[0]==8)||(date[0]==10)) {
			if(date[1]>31) {
				daysOver=date[1]-31;
				date[1]=daysOver;
				date[0]++;
			}
		}
//		April4,June6,September9,November11 - 30 days
		else if((date[0]==4)||(date[0]==6)||(date[0]==9)||(date[0]==11)) {
			if(date[1]>30) {
				daysOver=date[1]-30;
				date[1]=daysOver;
				date[0]++;
			}
		}
		//december12 31
		else if(date[0]==12) {
			if(date[1]>31) {
				date[0]=1;
				daysOver=date[1]-31;
				date[1]=daysOver;
				date[2]++;
			}
		}
	return date;
	}
	
}
