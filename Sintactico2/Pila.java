package Sintactico2;

import java.util.Stack;

public class Pila {
	
	private Stack<Alumno> stack;
	
	public Pila(){
		stack=new Stack<Alumno>();
	}
	
	public void push(Alumno x){
		stack.push(x);
	}
	
	public Alumno pop(){
		return stack.pop();
	}
	
	public Alumno top(){
		return stack.peek();
	}
	
	public void muestra(){
		
		System.out.print("Pila: \n");
		for(int i=0;i<stack.size();i++){
			stack.elementAt(i).muestra();
		}
		System.out.println();
	}

}
