package Sintactico3;

public abstract class ElementoPila {
	
	protected int elemento;
	
	public abstract void muestra();

}

class Terminal extends ElementoPila{
	
	String id;
	
	public Terminal(String id,int elemento){
		this.id=id;
		this.elemento=elemento;
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}
	
}

class NoTerminal extends ElementoPila{
	String id;
	Nodo nodo;
	
	public NoTerminal(String id,int elemento){
		this.id=id;
		this.elemento=elemento;
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}
}

class Estado extends ElementoPila{
	
	public Estado(int elemento){
		this.elemento=elemento;
	}
	
	public void muestra(){
		System.out.print(elemento+" ");
	}
}