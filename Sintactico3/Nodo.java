package Sintactico3;

public abstract class Nodo {
	
	protected String simbolo;
	public Nodo sig;
	
	public Nodo(){
		sig=null;
	}
	
	public abstract void muestra();

}

class Expresion extends Nodo{
	
	protected Expresion izq,der;
	
	public Expresion(){
		super();
		izq=der=null;
	}
	
	public void muestra(){
		
	}
}

class R1 extends Nodo{
	
	public R1(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R3 extends Expresion{
	
	public R3(Pila pila){
		pila.pop();
		izq=(Expresion)((NoTerminal)pila.pop()).nodo;
		pila.pop();
		der=(Expresion)((NoTerminal)pila.pop()).nodo;
	}
}

class R4 extends Nodo{
	
	public R4(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R5 extends Nodo{
	
	public R5(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R6 extends Nodo{
	
	public R6(Pila pila){
		pila.pop();
	}
	
	public void muestra(){
		
	}
}