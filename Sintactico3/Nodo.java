package Sintactico3;

public abstract class Nodo {
	
	protected String simbolo,id;
	public Nodo sig,der,izq;
	
	public Nodo(){
		sig=der=izq=null;
	}
	
	public abstract void muestra();

}

/*class Expresion extends Nodo{	
	protected Nodo izq,der;
	
	public Expresion(){
		super();
		izq=der=null;
	}
	
	public void muestra(){
		
	}
}*/

class R1 extends Nodo{
	
	public R1(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
		id="<Programa>";
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}
}

class R3 extends Nodo{
	
	public R3(Pila pila){
		pila.pop();
		izq= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		id="<Definiciones> ";
	}
	public void muestra(){
		System.out.print(id+" ");
	}
}

class R4 extends Nodo{
	
	public R4(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
		id="<Definicion> ";
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}
}

class R5 extends Nodo{
	
	public R5(Pila pila){
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
		id="<Definicion> ";
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}
}

class R6 extends Nodo{
	String simbolo1[]=new String[3];
	
	public R6(Pila pila){
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=(Nodo)((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]+=((Terminal)pila.pop()).id;
		id="<DefVar> ";
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+sig.id+" "+simbolo1[0]);
	}
}

class R8 extends Nodo{
	String simbolo1[]=new String[2];
	public R8(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<ListaVar> ";
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]+" "+sig.id);
	}
}

class R9 extends Nodo{
	String simbolo1[]=new String[4];
	public R9(Pila pila){
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		izq= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[3]=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[3]+" "+simbolo1[2]+" "+simbolo1[1]+" "+izq.id+" "+simbolo1[0]+" "+der.id);
	}
}

class R11 extends Nodo{
	String simbolo1[]=new String[2];
	public R11(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
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

class R16 extends Nodo{
	public R16(Pila pila){
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
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

class R20 extends Nodo{
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
		simbolo+=" "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R22 extends Nodo{
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
	
	public void muestra(){
		
	}
}

class R23 extends Nodo{
	public R23(Pila pila){
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
	
	public void muestra(){
		
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
		simbolo+=" "+((Terminal)pila.pop()).id;
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

class R32 extends Nodo{
	public R32(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R34 extends Nodo{
	public R34(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R35 extends Nodo{
	public R35(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R36 extends Nodo{
	public R36(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R37 extends Nodo{
	public R37(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R38 extends Nodo{
	public R38(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R39 extends Nodo{
	public R39(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R40 extends Nodo{
	public R40(Pila pila){
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
		pila.pop();
		simbolo+=" "+((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R41 extends Nodo{
	public R41(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R42 extends Nodo{
	public R42(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R43 extends Nodo{
	public R43(Pila pila){
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

class R44 extends Nodo{
	public R44(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R45 extends Nodo{
	public R45(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
	}
	
	public void muestra(){
		
	}
}

class R46 extends Nodo{
	public R46(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R47 extends Nodo{
	public R47(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R48 extends Nodo{
	public R48(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R49 extends Nodo{
	public R49(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R50 extends Nodo{
	public R50(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R51 extends Nodo{
	public R51(Pila pila){
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}

class R52 extends Nodo{
	public R52(Pila pila){
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
	}
	
	public void muestra(){
		
	}
}