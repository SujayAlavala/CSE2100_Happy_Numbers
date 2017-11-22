/*
 * Sujay Alavala
 * Wei Wei
 * 9/23/16
 * CSE2100
 */



//This is the Linked list class, and it creates the skeleton for the linked list.
//I used the code from lecture to create the linked list. 
public class Linkedlist<E> {
	
	public static class Node<E>{
		private E element;
		private Node<E>next;
		public Node(E e, Node<E> n){ //Creates the node that has one element and then points to another node.
			element = e;
			next = n;
		}
		public Node<E> getNext(){return next;} //returns the next node.
		public void setNext(Node<E> n) {next = n;} //Sets up the next node
		private Node<E> head = null; //Sets the first element in the linked list as null
		private Node<E> tail = null; //Sets the last element in the linked list as null
		private int size = 0; //The size of the linked list is 0 nodes to start
		public boolean isEmpty(){return size == 0;} //Returns true if the linked list has a size of 0, returns false if the linked list has a size > 0.
		public void Linkedlist(){} //Constuctor for this class
		public void addLast(E e){ //Method lets you add a new node at the end of a linked list with the element 'e' and sets the next node as null. 
			                      //In other words, sets a new tail
			Node<E> newnode = new Node<>(e,null);
			if(isEmpty())
				head = newnode;
			else
				tail.setNext(newnode);
			tail = newnode;
			size++; // increases the size 
		}
		public boolean contains(String number){ // Runs through the linked list and returns true if the list contains
												//the String.
			if(isEmpty()){
				return false;
			}
			else{
				Node<E> test = head;
				String test2 = "" + test;
				while (number != null){
					if(test2 == number){
						return true;
					}
					else{
						test = test.getNext();
					}
				}
				return false;
			}
		}
	}

	

}
