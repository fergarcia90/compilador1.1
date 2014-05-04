package Sintactico;

import java.util.Stack;

public class Pila {
	
	private Stack<Integer> stack;
	
	public Pila(){
		stack=new Stack<Integer>();
	}
	
	public void push(int x){
		stack.push(x);
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public int top(){
		return stack.peek();
	}
	
	public void muestra(){
		
		System.out.print("Pila: ");
		for(int i=0;i<stack.size();i++){
			System.out.print(stack.elementAt(i)+" ");
		}
		System.out.println();
	}

}
