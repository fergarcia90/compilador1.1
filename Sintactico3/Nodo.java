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

class Identificador extends Expresion{
	
	public Identificador(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		System.out.print(simbolo+" ");
	}
}

class Entero extends Expresion{
	
	public Entero(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		System.out.print(simbolo+" ");
	}
}

class Suma extends Expresion{
	
	public Suma(Pila pila){
		super();
		pila.pop();
		der=(Expresion)((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=(Expresion)((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		System.out.print(simbolo+" ");
	}
}

class Multiplicacion extends Expresion{
	
	public Multiplicacion(Pila pila){
		super();
		pila.pop();
		der=(Expresion)((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=(Expresion)((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		System.out.print(simbolo+" ");
	}
}