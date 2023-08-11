package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		System.out.println("Current Date: " + date);
		System.out.println("Day [DD]: " + date.getDayOfMonth());
		System.out.println("Month [M]: " + date.getMonthValue());
		System.out.println("Year [YYYY]: " + date.getYear());
		System.out.println("----------------------------------");

		LocalTime time = LocalTime.now();
		System.out.println("Current Time: " + time);
		System.out.println("Hour: " + time.getHour());
		System.out.println("Minute: " + time.getMinute());
		System.out.println("Second: " + time.getSecond());
		System.out.println("NanoSecond: " + time.getNano());
		System.out.println("----------------------------------");
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Current Date-Time: " + dt);
		System.out.println("----------------------------------");
		
		LocalDateTime dt2 = LocalDateTime.of(1990,Month.AUGUST,10,15,55);
		System.out.println("Custom Date: " + dt2);
		System.out.println("Custom Date plus 15 days: " + dt2.plusDays(15));
		System.out.println("----------------------------------");
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter birth year, month, day: ");
//		int years = sc.nextInt();
//		int months = sc.nextInt();
//		int days = sc.nextInt();
//		System.out.println("Enter total expected life expectancy in years: ");
//		int exp = sc.nextInt();
//		LocalDate birthday = LocalDate.of(years,months,days);
//		LocalDate today = LocalDate.now();
//		LocalDate death = birthday.plusYears(exp);
//		Period p1 = Period.between(birthday, today);
//		Period p2 = Period.between(today, death);		
//		System.out.printf("Age is %d years, %d months, %d days\n", p1.getYears(),p1.getMonths(),p1.getDays());
//		System.out.printf("Remaining %d years, %d months, %d days\n", p2.getYears(), p2.getMonths(), p2.getDays());
		
		ZoneId z = ZoneId.systemDefault();
		System.out.println(z);
		
		ZoneId la = ZoneId.of("America/Los_Angeles");
		ZonedDateTime zt = 	ZonedDateTime.now(la);
		System.out.println(zt);
		
		
	}

}
