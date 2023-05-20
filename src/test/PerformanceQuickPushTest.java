package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stack.QuickPush;

public class PerformanceQuickPushTest {
	
	private static Integer AMOUNT_OF_ACTIONS = 800;
	private static Integer AMOUNT_OF_lOOPS = 20;
	private static Long MISTAKE_RANG_LINEAR_INSERTION = Long.MAX_VALUE ;
	private static Long MISTAKE_RANG_LINEAR_POPOUT = Long.MAX_VALUE ;
	
	 @BeforeAll
		public static void initializeValues() {		
			Scanner reader = new Scanner(System.in); 
			System.out.println("Enter basic amout of actions (pop/push) you would like to set : ");
			AMOUNT_OF_ACTIONS = reader.nextInt(); 
			System.out.println("Enter amout of jumps you would like to set for the mass linear check : ");
			AMOUNT_OF_lOOPS = reader.nextInt();
			reader.close();
		}
	
	 @Test
	    void linearInsertionQuickPush() {
		 QuickPush<Integer> intQuickPush = new QuickPush<Integer>();
		 Long min = Long.MAX_VALUE;
		 Long max = Long.MIN_VALUE;
		 for(int i = 0; i<AMOUNT_OF_ACTIONS; i++) {
			 long startTime = System.nanoTime();
			 intQuickPush.push(i);
			 long elapsedNanos = System.nanoTime() - startTime;
			 if(elapsedNanos > max) {
				 max = elapsedNanos;
			 }
			 if(elapsedNanos < min) {
				 min = elapsedNanos;
			 }
		 }
		 Long maxDiff = max - min;
		 assertTrue(MISTAKE_RANG_LINEAR_INSERTION > maxDiff, "The maximum diff that found at push is : " + maxDiff);
	    }
	 
	 @Test
	    void linearExtractionQuickPush() {
		 ArrayList<Long> results = new ArrayList<Long>(AMOUNT_OF_lOOPS+1);
		 for(int theMultipleNumber = 1; theMultipleNumber <= AMOUNT_OF_lOOPS; theMultipleNumber++) {
			 int currentAmountOfVariables = AMOUNT_OF_ACTIONS * theMultipleNumber;
			 QuickPush<Integer> intQuickPush = new QuickPush<Integer>();
			 fillQuickStack(intQuickPush, currentAmountOfVariables);
			 //let's test the pop()
			 long startTime = System.nanoTime();
			 emptyQuikStack(intQuickPush);
			 long elapsedNanos = Math.abs(System.nanoTime() - startTime);
			 results.add(elapsedNanos);
		 }
		 for(int i = 1; i <= AMOUNT_OF_lOOPS; i++) {
			 int identToCorrespondIndex = i-1;
			 assertTrue(Math.abs(results.get(identToCorrespondIndex)/i - results.get(0)) < MISTAKE_RANG_LINEAR_POPOUT,
					 "Pop of " + AMOUNT_OF_ACTIONS*i + " takes : " + results.get(identToCorrespondIndex) + ", devide at : " + i + ", it's : " + results.get(identToCorrespondIndex)/i);
			 
		 }
	 }

	private void emptyQuikStack(QuickPush<Integer> intQuickPush) {
		Integer curr = 0;
		while(curr !=  null) {
			curr = intQuickPush.pop();
		}		
	}

	private void fillQuickStack(QuickPush<Integer> intQuickPush, int currentAmountOfVariables) {
		for(int i = 0; i < currentAmountOfVariables; i++) {
			intQuickPush.push(i);
		}		
	}
}
