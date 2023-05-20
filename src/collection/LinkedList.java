package collection;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insert(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    public void insertAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }
    
    public T extract() {
        if (head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    public T extractAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            return extract();
        }

        Node previous = null;
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        T data = current.data;
        previous.next = current.next;
        size--;
        return data;
    }

    public T extractFromTail(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node previous = null;
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        T data = current.data;
        previous.next = current.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public T getValueAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }
  
}
