package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import stack.QuickPop;

public class BasicFunctionalityQuickPopTest{
	//do I need to use @Parameterized?
	
	@Test
	void customObj() {
		
		class Dot implements Comparable<Dot>{
			
			private int x;
			private int y;
			
			public Dot(int x, int y) {
				this.x = x;
				this.y = y;
			}
			
			@Override
			public int compareTo(Dot o) {
				return 0;
			}			
		}
		
		Dot a = new Dot(1,2);
		Dot b = new Dot(2,3);
		QuickPop<Dot> dotQuickPop = new QuickPop<Dot>();
		dotQuickPop.push(a);
		dotQuickPop.push(b);
		dotQuickPop.push(a);
		assertTrue(dotQuickPop.pop().equals(a));
		assertTrue(dotQuickPop.pop().equals(b));
		assertTrue(dotQuickPop.pop().equals(a));
	}

	@Test
	void intOneVar() {
		QuickPop<Integer> intQuickPop=new QuickPop<Integer>();
		intQuickPop.push(2);
		assertTrue(2 == intQuickPop.pop());
		assertTrue(null == intQuickPop.pop());
	}

	@Test
	void intOrder() {
		QuickPop<Integer> intQuickPop=new QuickPop<Integer>();
		intQuickPop.push(2);
		intQuickPop.push(9);
		intQuickPop.push(7);
		intQuickPop.push(7);
		intQuickPop.push(0);
		intQuickPop.push(3);
		assertTrue(9 == intQuickPop.pop());
		assertTrue(7 == intQuickPop.pop());
		assertTrue(7 == intQuickPop.pop());
		assertTrue(3 == intQuickPop.pop());	        
		assertTrue(2 == intQuickPop.pop());
		assertTrue(0 == intQuickPop.pop());
		assertTrue(null == intQuickPop.pop());
	}

	@Test
	void intOrderNegative() {
		QuickPop<Integer> intQuickPop=new QuickPop<Integer>();
		intQuickPop.push(-2);
		intQuickPop.push(-9);
		intQuickPop.push(-7);
		intQuickPop.push(-7);
		intQuickPop.push(-0);
		intQuickPop.push(-3);
		assertTrue(0 == intQuickPop.pop());
		assertTrue(-2 == intQuickPop.pop());
		assertTrue(-3 == intQuickPop.pop());
		assertTrue(-7 == intQuickPop.pop());
		assertTrue(-7 == intQuickPop.pop());
		assertTrue(-9 == intQuickPop.pop());
		assertTrue(null == intQuickPop.pop());
	}

	@Test
	void intOrderNegativeAndPozitive() {
		QuickPop<Integer> intQuickPop=new QuickPop<Integer>();
		intQuickPop.push(-2);
		intQuickPop.push(9);
		intQuickPop.push(-7);
		intQuickPop.push(7);
		intQuickPop.push(0);
		intQuickPop.push(-3);
		assertTrue(9 == intQuickPop.pop());
		assertTrue(7 == intQuickPop.pop());
		assertTrue(0 == intQuickPop.pop());
		assertTrue(-2 == intQuickPop.pop());
		assertTrue(-3 == intQuickPop.pop());
		assertTrue(-7 == intQuickPop.pop());
		assertTrue(null == intQuickPop.pop());
	}

	@Test
	void dateOrder() {
		QuickPop<Date> dateQuickPop=new QuickPop<Date>();
		Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		Date date3 = new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime();
		Date date2 = new GregorianCalendar(2014, Calendar.DECEMBER, 20).getTime();
		Date date4 = new GregorianCalendar(2015, Calendar.DECEMBER, 20).getTime();
		Date date5 = new GregorianCalendar(2018, Calendar.DECEMBER, 22).getTime();
		dateQuickPop.push(date1);
		dateQuickPop.push(date2);
		dateQuickPop.push(date3);
		dateQuickPop.push(date4);
		dateQuickPop.push(date5);
		assertTrue(dateQuickPop.pop().equals(date5));
		assertTrue(dateQuickPop.pop().equals(date4));
		assertTrue(dateQuickPop.pop().equals(date2));
		assertTrue(dateQuickPop.pop().equals(date3));
		assertTrue(dateQuickPop.pop().equals(date1));	      
		assertTrue(dateQuickPop.pop() == null);
	}

	@Test
	void stringOrder() {
		QuickPop<String> strQuickPop=new QuickPop<String>();
		String str1 = new String("a");
		String str2 = new String("a");		 
		String str3 = new String("aa");
		String str4 = new String("ert");	
		String str5 = new String("y");
		strQuickPop.push(str1);
		strQuickPop.push(str2);
		strQuickPop.push(str3);
		strQuickPop.push(str4);
		strQuickPop.push(str5);
		assertTrue(strQuickPop.pop().equals(str5));
		assertTrue(strQuickPop.pop().equals(str4));
		assertTrue(strQuickPop.pop().equals(str3));
		assertTrue(strQuickPop.pop().equals(str2));
		assertTrue(strQuickPop.pop().equals(str1));	      
		assertTrue(strQuickPop.pop() == null);
	}
}
