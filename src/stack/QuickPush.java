package stack;

import collection.LinkedList;


public class QuickPush<T extends Comparable<T>>  {	

	LinkedList<T> QuickPushList;

	public QuickPush() {			
		QuickPushList=new LinkedList<T>();
	}

	public synchronized T pop() {
		if(QuickPushList.size()==0) {
			return null;
		}
		T temp = QuickPushList.getValueAtIndex(0);
		int tempIndex = 0;
		for(int i=0; i<QuickPushList.size() ; i++) {
			T current = QuickPushList.getValueAtIndex(i);
			if(current.compareTo(temp) > 0) {
				temp = current;
				tempIndex = i;
			}
		}
		QuickPushList.extractAtIndex(tempIndex);
		return temp;
	}		


	public synchronized void push(T t) {
		QuickPushList.insert(t);
	}

	public synchronized void print() {
		for(int i=0; i<QuickPushList.size() ; i++) {
			System.out.print(QuickPushList.getValueAtIndex(i) + " ");
		}
		System.out.println(".");
	}


}