package Sintactico3;

import java.util.Stack;

public class Pila {
	
	private Stack<ElementoPila> stack;
	
	public Pila(){
		stack=new Stack<ElementoPila>();
	}
	
	public void push(ElementoPila x){
		stack.push(x);
	}
	
	public ElementoPila pop(){
		return stack.pop();
	}
	
	public ElementoPila top(){
		return stack.peek();
	}
	
	public void muestra(){
		
		System.out.print("Pila: ");
		for(int i=0;i<stack.size();i++){
			stack.elementAt(i).muestra();
		}
		System.out.println();
	}

}
