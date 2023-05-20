package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import stack.QuickPush;

public class BasicFunctionalityQuickPushTest {
	//do I need to use @Parameterized?
	
	@Test
	void intOneVarible() {
		QuickPush<Integer> intQuickPush=new QuickPush<Integer>();
		intQuickPush.push(2);
		assertTrue(2 == intQuickPush.pop());
		assertTrue(null == intQuickPush.pop());
	}

	@Test
	void intOrder() {
		QuickPush<Integer> intQuickPush=new QuickPush<Integer>();
		intQuickPush.push(2);
		intQuickPush.push(9);
		intQuickPush.push(7);
		intQuickPush.push(7);
		intQuickPush.push(0);
		intQuickPush.push(3);
		assertTrue(9 == intQuickPush.pop());
		assertTrue(7 == intQuickPush.pop());
		assertTrue(7 == intQuickPush.pop());
		assertTrue(3 == intQuickPush.pop());	        
		assertTrue(2 == intQuickPush.pop());
		assertTrue(0 == intQuickPush.pop());
		assertTrue(null == intQuickPush.pop());
	}

	@Test
	void intOrderNegative() {
		QuickPush<Integer> intQuickPush=new QuickPush<Integer>();
		intQuickPush.push(-2);
		intQuickPush.push(-9);
		intQuickPush.push(-7);
		intQuickPush.push(-7);
		intQuickPush.push(-0);
		intQuickPush.push(-3);
		assertTrue(0 == intQuickPush.pop());
		assertTrue(-2 == intQuickPush.pop());
		assertTrue(-3 == intQuickPush.pop());
		assertTrue(-7 == intQuickPush.pop());
		assertTrue(-7 == intQuickPush.pop());
		assertTrue(-9 == intQuickPush.pop());
		assertTrue(null == intQuickPush.pop());
	}

	@Test
	void intOrderNegativeAndPozitive() {
		QuickPush<Integer> intQuickPush=new QuickPush<Integer>();
		intQuickPush.push(-2);
		intQuickPush.push(9);
		intQuickPush.push(-7);
		intQuickPush.push(7);
		intQuickPush.push(0);
		intQuickPush.push(-3);
		assertTrue(9 == intQuickPush.pop());
		assertTrue(7 == intQuickPush.pop());
		assertTrue(0 == intQuickPush.pop());
		assertTrue(-2 == intQuickPush.pop());
		assertTrue(-3 == intQuickPush.pop());
		assertTrue(-7 == intQuickPush.pop());
		assertTrue(null == intQuickPush.pop());
	}

	@Test
	void dateOrder() {
		QuickPush<Date> dateQuickPush=new QuickPush<Date>();
		Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		Date date2 = new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime();
		Date date3 = new GregorianCalendar(2014, Calendar.DECEMBER, 20).getTime();
		Date date4 = new GregorianCalendar(2015, Calendar.DECEMBER, 20).getTime();
		Date date5 = new GregorianCalendar(2018, Calendar.DECEMBER, 22).getTime();
		dateQuickPush.push(date1);
		dateQuickPush.push(date2);
		dateQuickPush.push(date3);
		dateQuickPush.push(date4);
		dateQuickPush.push(date5);
		assertTrue(dateQuickPush.pop().equals(date5));
		assertTrue(dateQuickPush.pop().equals(date4));
		assertTrue(dateQuickPush.pop().equals(date3));
		assertTrue(dateQuickPush.pop().equals(date2));
		assertTrue(dateQuickPush.pop().equals(date1));
		assertTrue(dateQuickPush.pop() == null);
	}

	@Test
	void stringOrder() {
		QuickPush<String> strQuickPush=new QuickPush<String>();
		String str1 = new String("a");
		String str2 = new String("a");		 
		String str3 = new String("aa");
		String str4 = new String("ert");	
		String str5 = new String("y");
		strQuickPush.push(str1);
		strQuickPush.push(str2);
		strQuickPush.push(str3);
		strQuickPush.push(str4);
		strQuickPush.push(str5);
		assertTrue(strQuickPush.pop().equals(str5));
		assertTrue(strQuickPush.pop().equals(str4));
		assertTrue(strQuickPush.pop().equals(str3));
		assertTrue(strQuickPush.pop().equals(str2));
		assertTrue(strQuickPush.pop().equals(str1));	      
		assertTrue(strQuickPush.pop() == null);
	}
}
