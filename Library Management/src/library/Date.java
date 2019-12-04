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
		String[] splitDate = str.split("/");
		if((splitDate[0].length()>2)||Integer.parseInt(splitDate[0])>12) {
			throw new ImproperFormatException("Invalid month");
		}
		if(splitDate[1].length()>2) {
			throw new ImproperFormatException("Invalid day");
		}
		int ecm =0;
		int ecd=0;
		int ecy=0;
		try {
			ecm = Integer.parseInt(splitDate[0]);
			ecd = Integer.parseInt(splitDate[1]);
			ecy = Integer.parseInt(splitDate[2]);
		}
		catch(NumberFormatException e) {
			throw new ImproperFormatException("Date format must be mm/dd/yyyy in digits");
		}
		int febLength=28;
		if(ecm==2) {
			if(isLeapYear(ecy)) {
				febLength=29;
			}
			else if(ecd>febLength) {
				throw new ImproperFormatException("Invalid day");
			}
		}
		else if((ecm==1)||(ecm==3)||(ecm==5)||(ecm==7)||(ecm==8)||(ecm==10)) {
			if(ecd>31) {
				throw new ImproperFormatException("Invalid day");
			}
		}
		else if((ecm==4)||(ecm==6)||(ecm==9)||(ecm==11)) {
			if(ecd>30) {
				throw new ImproperFormatException("Invalid day");
			}
		}
		else if(ecm==12) {
			if(ecd>31) {
				throw new ImproperFormatException("Invalid day");
			}
		}
		
	}
	
	public Boolean isLessThan(Date inputDate) {
		int inputedDate=Integer.parseInt(String.format("%04d%02d%02d", inputDate.getYear(),inputDate.getMonth(),inputDate.getDay()));
		int thisDate=Integer.parseInt(String.format("%04d%02d%02d", y,m,d));
		return(thisDate<inputedDate);
	}
}