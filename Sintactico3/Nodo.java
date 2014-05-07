package Sintactico3;

public abstract class Nodo {
	
	protected String simbolo,id;
	public Nodo sig,der,izq;
	int tamSangria;
	char tipoDato;
	
	public Nodo(){
		sig=null;
		izq=null;
		der=null;
		tamSangria=0;
	}
	
	public abstract void muestra();
	
	public abstract void validaDatos();

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
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Programa>";
		//tamSangria=7;
	}
							
	public void muestra(){
		System.out.print(id+" ");
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R3 extends Nodo{
	
	public R3(Pila pila){
		super();
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq= ((NoTerminal)pila.pop()).nodo;
		id="<Definiciones> ";
		//tamSangria=7;
	}
	public void muestra(){
		System.out.print(id+" ");
	}
	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R4 extends Nodo{
	
	public R4(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Definicion> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R5 extends Nodo{
	
	public R5(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Definicion> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" ");
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R6 extends Nodo{
	String simbolo1[]=new String[3];
	
	public R6(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<DefVar> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+" "+simbolo1[0]);
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R8 extends Nodo{
	String simbolo1[]=new String[2];
	public R8(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<ListaVar> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]);
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R9 extends Nodo{
	String simbolo1[]=new String[4];
	public R9(Pila pila){
		super();
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
		id="<DefFunc> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[3]+" "+simbolo1[2]+" "+simbolo1[1]+" "+" "+simbolo1[0]);
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R11 extends Nodo{
	String simbolo1[]=new String[2];
	public R11(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		id="<Parametros> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R13 extends Nodo{
	String simbolo1[]=new String[3];
	public R13(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<ListaParam> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R14 extends Nodo{
	String simbolo1[]=new String[2];
	public R14(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<BloqFunc> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+" "+simbolo1[0]);
	}
}

class R16 extends Nodo{
	public R16(Pila pila){
		super();
		pila.pop();
		der= ((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<DefLocales> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R17 extends Nodo{
	public R17(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<DefLocal> ";
		//tamSangria=2;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R18 extends Nodo{
	public R18(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<DefLocal> ";
		//tamSangria=2;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R20 extends Nodo{
	public R20(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Sentencias> ";
		//tamSangria=2;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R21 extends Nodo{
	String simbolo1[]=new String[3];
	public R21(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<Sentencia> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R22 extends Nodo{
	String simbolo1[]=new String[3];
	public R22(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<Sentencia> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R23 extends Nodo{
	String simbolo1[]=new String[3];
	public R23(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<Sentencia> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[2]+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R24 extends Nodo{
	String simbolo1[]=new String[2];
	public R24(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<Sentencia> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R25 extends Nodo{
	public R25(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Sentencia> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R27 extends Nodo{
	public R27(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Otro> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R28 extends Nodo{
	String simbolo1[]=new String[2];
	public R28(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<Bloque> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R30 extends Nodo{
	public R30(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<ValorRegresa> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R32 extends Nodo{
	public R32(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Argumentos> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R34 extends Nodo{
	public R34(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<ListaArgumentos> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R35 extends Nodo{
	public R35(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Termino> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R36 extends Nodo{
	public R36(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Termino> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R37 extends Nodo{
	public R37(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Termino> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R38 extends Nodo{
	public R38(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Termino> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R39 extends Nodo{
	public R39(Pila pila){
		super();
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Termino> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R40 extends Nodo{
	String simbolo1[]=new String[3];
	public R40(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		pila.pop();
		simbolo1[2]=((Terminal)pila.pop()).id;
		id="<LlamadaFuncion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(simbolo1[2]+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R41 extends Nodo{
	public R41(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<SentenciaBloque> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R42 extends Nodo{
	public R42(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<SentenciaBloque> ";
		//tamSangria=3;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}

class R43 extends Nodo{
	String simbolo1[]=new String[2];
	public R43(Pila pila){
		super();
		pila.pop();
		simbolo1[0]=((Terminal)pila.pop()).id;
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo1[1]=((Terminal)pila.pop()).id;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo1[1]+" "+simbolo1[0]);
	}
}

class R44 extends Nodo{
	public R44(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R45 extends Nodo{
	public R45(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R46 extends Nodo{
	public R46(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R47 extends Nodo{
	public R47(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R48 extends Nodo{
	public R48(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R49 extends Nodo{
	public R49(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R50 extends Nodo{
	public R50(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R51 extends Nodo{
	public R51(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}
}

class R52 extends Nodo{
	public R52(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		id="<Expresion> ";
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id);
	}
}