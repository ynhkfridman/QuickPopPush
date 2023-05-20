package stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickPop<Integer> intPop=new QuickPop<Integer>();
		intPop.push(1);		
		intPop.push(5);
		//intPop.print();		
		intPop.push(3);
		//intPop.print();		
		intPop.push(3);
		//intPop.print();		

		System.out.println(intPop.pop());
		intPop.print();
		System.out.println(intPop.pop());
		intPop.print();
		System.out.println(intPop.pop());
		intPop.print();
		System.out.println(intPop.pop());
		intPop.print();
		System.out.println(intPop.pop());
		intPop.print();
		
//		QuickPush<Integer> intPush=new QuickPush<Integer>();
//		intPush.push(1);
//		intPush.push(5);
//		intPush.print();		
//		intPush.push(3);
//		intPush.print();
//		intPush.push(3);
//		intPush.print();
//		
//		System.out.println(intPush.pop());
//		intPush.print();
//		System.out.println(intPush.pop());
//		intPush.print();
//		System.out.println(intPush.pop());
//		intPush.print();
//		System.out.println(intPush.pop());
//		intPush.print();
		
	}

}
