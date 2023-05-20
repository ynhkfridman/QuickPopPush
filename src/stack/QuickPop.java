package stack;


import collection.LinkedList;

public class QuickPop<T extends Comparable<T>> {

	LinkedList<T> QuickPopList;

	public QuickPop() {
		QuickPopList = new LinkedList<T>();
	}

	public synchronized T pop() {
		if (QuickPopList.size() == 0) {
			return null;
		}
		T head = QuickPopList.extract();
		return head;
	}

	public synchronized void push(T t) {
		if (QuickPopList.size() == 0) {
			QuickPopList.insert(t);
		} else {
			boolean valInserted = false;
			for (int i = 0; i < QuickPopList.size(); i++) {
				T current = QuickPopList.getValueAtIndex(i);
				if (current.compareTo(t) <= 0) {
					QuickPopList.insertAtIndex(t, i);
					valInserted = true;
					break;
				}
			}
			if (!valInserted) {
				QuickPopList.insert(t);
			}
		}
	}

	public synchronized void print() {
		for (int i = 0; i < QuickPopList.size(); i++) {
			System.out.print(QuickPopList.getValueAtIndex(i) + " ");
		}
		System.out.println(".");
	}

}
