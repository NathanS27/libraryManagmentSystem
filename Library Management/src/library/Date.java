package library;

import java.util.Calendar;

public class Date {
	private int m,d,y;
	
	public Date(int month, int day, int year) {
		m=month;
		d=day;
		y=year;
	}
	
	public Date(String dateInput) throws ImproperFormatException {
		if(dateInput!=null) {
			String[] dateRaw =dateInput.split("/");
			errorCheck(dateInput);
			try {
			m=Integer.parseInt(dateRaw[0]);
			d=Integer.parseInt(dateRaw[1]);
			y=Integer.parseInt(dateRaw[2]);
			}
			catch(NumberFormatException e) {
				throw new ImproperFormatException("Date must be integers");
			}
		}
		else {
			throw new ImproperFormatException("Date must be entered");
		}
	}
	
	public Date() {	
	}
	
	public Date(Date newDate) {
		m=newDate.getMonth();
		d= newDate.getDay();
		y=newDate.getYear();
	}
	
	
	public int getMonth() {
		return m;
	}
	public int getDay() {
		return d;
	}
	public int getYear() {
		return y;
	}
	
	public String toString() {
		return m+"/"+d+"/"+y;
	}
	
	private Boolean isLeapYear(int year) {
		return((year%4==0)&&(year%100!=0)||(year%400==0));
	}
	
	public void dateAdd(int days) {
		int daysOver;
		int febLength=28;
		d+=days;
//		February2 - 28 days in a common year and 29 days in leap years
		if(m==2) {
			if(isLeapYear(y)) {
				febLength=29;
			}
			if(d>febLength) {
				daysOver=d-febLength;
				d=daysOver;
				m++;
			}
		}
//		January1,March3,May5,July7,August8,October10,December12 - 31 days
		else if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)) {
			if(d>31) {
				daysOver=d-31;
				d=daysOver;
				m++;
			}
		}
//		April4,June6,September9,November11 - 30 days
		else if((m==4)||(m==6)||(m==9)||(m==11)) {
			if(d>30) {
				daysOver=d-30;
				d=daysOver;
				m++;
			}
		}
		//december12 31
		else if(m==12) {
			if(d>31) {
				m=1;
				daysOver=d-31;
				d=daysOver;
				y++;
			}
		}
	}
	
	public Date today() {
		int currentMonth=Calendar.getInstance().get(Calendar.MONTH) + 1;
		int currentDay=Calendar.getInstance().get(Calendar.DATE);
		int currentYear=Calendar.getInstance().get(Calendar.YEAR);
		return new Date(currentMonth,currentDay,currentYear);
	}

	private void errorCheck(String str) throws ImproperFormatException {
		if(str.length()>10) {
			throw new ImproperFormatException("Date format must be mm/dd/yyy");
		}
	}

	private Long timeInMiliseconds() {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m, d);
		return cal.getTimeInMillis();
	}
	public Boolean isLessThan(Date d) {
		return(timeInMiliseconds()<d.timeInMiliseconds());
	}
}