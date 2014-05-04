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
	
	protected Nodo izq,der;
	
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
		izq= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
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
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+="<DefVar> "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R8 extends Nodo{
	
	public R8(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R9 extends Expresion{
	
	public R9(Pila pila){
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" <Parametros> "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
}

class R11 extends Nodo{
	
	public R11(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R13 extends Nodo{
	
	public R13(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R14 extends Nodo{
	
	public R14(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R16 extends Expresion{
	public R16(Pila pila){
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
}

class R17 extends Nodo{
	public R17(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R18 extends Nodo{
	public R18(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R20 extends Expresion{
	public R20(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R21 extends Nodo{
	public R21(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" Expresion "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R22 extends Expresion{
	public R22(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
}

class R23 extends Expresion{
	public R23(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" <Expresion> "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
}

class R24 extends Nodo{
	public R24(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R25 extends Nodo{
	public R25(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R27 extends Nodo{
	public R27(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R28 extends Nodo{
	public R28(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" <Sentencias> "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R30 extends Nodo{
	public R30(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R32 extends Expresion{
	public R32(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
}

class R34 extends Expresion{
	public R34(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
}

