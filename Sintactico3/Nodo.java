package Sintactico3;

import Semantico.TablaSimbolos;


public abstract class Nodo {
	
	protected String simbolo,id;
	public static int contador;
	public Nodo sig,der,izq;
	int tamSangria;
	public char tipoDato;
	public static String ambito;
	public static TablaSimbolos tablasimbolos;
	public static int contpar;
	public static int contpush;
	public static int etiquetas;
	public static boolean retur=true;
	
	public Nodo(){
		sig=null;
		izq=null;
		der=null;
		tamSangria=0;
		tipoDato='v';
		etiquetas=0;
	}
	
	public void validaTipos(){
		tipoDato='v';
		if(sig!=null) sig.validaTipos();
		if(izq!=null) izq.validaTipos();
		if(der!=null) der.validaTipos();
	}
	
	public String generaCodigo(){
		String codigo="";
		if(sig!=null) codigo+=sig.generaCodigo();
		if(izq!=null) codigo+=izq.generaCodigo();
		if(der!=null) codigo+=der.generaCodigo();
		return codigo;
	}
	
	public String sigEtiqueta(){
		return "E"+(etiquetas++);
	}
	
	public String etiquetaActual(){
		return "E"+etiquetas;
				
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.tipoDato=tipoDato;
			sig.validaTipos();
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null){
			izq.tipoDato=tipoDato;
			izq.validaTipos();
		}
		if(der!=null){
			der.tipoDato=tipoDato;
			der.validaTipos();
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.tipoDato=tipoDato;
			sig.validaTipos();
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
}

class R21 extends Nodo{
	String simbolo1[]=new String[3];
	boolean local=false;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(tablasimbolos.varLocalDefinida(simbolo1[2], ambito)){
			local=true;
			if(sig!=null){
				sig.validaTipos();
				tablasimbolos.buscaIdentificador(simbolo1[2]);
				if(tablasimbolos.varLocal.tipo==sig.tipoDato)
					tipoDato=sig.tipoDato;
				else
					tablasimbolos.listaErrores.add("Error: conflicto de tipos en asignacion de valor a variable \""
							+simbolo1[2]+ "\"");
			}
		}
		else if(tablasimbolos.varGlobalDefinida(simbolo1[2])){
			if(sig!=null){
				sig.validaTipos();
				tablasimbolos.buscaIdentificador(simbolo1[2]);
				if(tablasimbolos.varGlobal.tipo==sig.tipoDato)
					tipoDato=sig.tipoDato;
				else
					tablasimbolos.listaErrores.add("Error: conflicto de tipos en asignacion de valor a variable \""
							+simbolo1[2]+ "\"");
			}
		}
		else
			tablasimbolos.listaErrores.add("Error: variable \""+simbolo1[2]+"\" no definida");
	}
	
	@Override
	public String generaCodigo(){
		String codigo="";
		
		codigo+=sig.generaCodigo();
		if(Nodo.retur){
		if(local)
			codigo+="pop "+simbolo1[2]+"_"+Nodo.ambito+"\n";
		else
			codigo+="pop "+simbolo1[2]+"_"+Nodo.ambito+"\n";
		}
		else{
			if(local)
				codigo+="mov "+simbolo1[2]+"_"+Nodo.ambito+",eax\n";
			else
				codigo+="mov "+simbolo1[2]+"_"+Nodo.ambito+",eax\n";
		}
		
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null){
			izq.validaTipos();
			if(izq.tipoDato=='b')
				tipoDato='b';
			else
				tablasimbolos.listaErrores.add("Error: los argumentos de la funcion if deben regresar un boolean");
		}
	}
	
	@Override
	public String generaCodigo(){
		String codigo="";
		String medio=sigEtiqueta();
		String fin=sigEtiqueta();
		codigo+=izq.generaCodigo();
		codigo+=" "+medio+"\n";
		codigo+=der.generaCodigo();
		codigo+="jmp "+fin+"\n";
		codigo+=medio+":\n";
		if(sig!=null)
			codigo+=sig.generaCodigo();
		codigo+=fin+":\n";
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null){
			izq.validaTipos();
			if(izq.tipoDato=='b')
				tipoDato='b';
			else
				tablasimbolos.listaErrores.add("Error: los argumentos de la funcion if deben regresar un boolean");
		}
	}
	@Override
	public String generaCodigo(){
		String codigo="";
		String whil=sigEtiqueta();
		String fin=sigEtiqueta();
		codigo+=whil+":\n";
		codigo+=izq.generaCodigo();
		codigo+=" "+fin+"\n";
		codigo+=der.generaCodigo();
		codigo+="jmp "+whil+"\n";
		codigo+=fin+":\n";
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(ambito.compareTo("")!=0){
			tablasimbolos.buscaFuncion(Nodo.ambito);
			if(sig!=null){
				sig.validaTipos();
				if(tipoDato==sig.tipoDato)
					tipoDato=sig.tipoDato;
				else
					tablasimbolos.listaErrores.add("Error: Se debe regresar un dato tipo \""+tipoDato+"\"");
			}
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
	}
}

class R27 extends Nodo{
	public R27(Pila pila){
		super();
		pila.pop();
		sig=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		simbolo=((Terminal)pila.pop()).id;
		id="<Otro> ";
		//tamSangria=5;
	}
	
	public void muestra(){
		System.out.print(id+" "+simbolo);
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
	}
}

class R32 extends Nodo{
	public static int ind;
	public R32(Pila pila){
		super();
		pila.pop();
		der=((NoTerminal)pila.pop()).nodo;
		pila.pop();
		izq=((NoTerminal)pila.pop()).nodo;
		id="<Argumentos> ";
		ind=0;
		//tamSangria=1;
	}
	
	public void muestra(){
		System.out.print(id);
	}

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		tablasimbolos.buscaFuncion(simbolo);
		if(tablasimbolos.funcion.param.isEmpty())
			tablasimbolos.listaErrores.add("Error: conflicto de parametros en funcion \""+simbolo+"\"");
		else{
			if(izq!=null){
				izq.validaTipos();
				tablasimbolos.buscaFuncion(simbolo);
				if(tablasimbolos.funcion.param.get(ind)!=null){
					System.out.println(tablasimbolos.funcion.param.get(R32.ind).tipo+" "+izq.tipoDato);
					if(tablasimbolos.funcion.param.get(ind).tipo!=izq.tipoDato){
						tablasimbolos.listaErrores.add("Error: conflicto de parametros en funcion \""+simbolo+"\"");
					}
				}
			}
			if(der!=null){
				ind++;
				System.out.println(ind);
				der.simbolo=simbolo;
				der.validaTipos();
			}
		}
		ind=0;
	}
	
	@Override
	public String generaCodigo(){
		Nodo.contpush++;
		String codigo="";
		if(izq!=null)
			codigo+=izq.generaCodigo();
		if(der!=null)
			codigo+=der.generaCodigo();
		return codigo;	
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null){
			izq.validaTipos();
			tablasimbolos.buscaFuncion(simbolo);
			if(R32.ind<tablasimbolos.funcion.param.size()){
				System.out.println(tablasimbolos.funcion.param.get(R32.ind).tipo+" "+izq.tipoDato);
				if(tablasimbolos.funcion.param.get(R32.ind).tipo!=izq.tipoDato){
					tablasimbolos.listaErrores.add("Error: conflicto de parametros en funcion \""+simbolo+"\"");
				}
			}
			else{
				tablasimbolos.listaErrores.add("Error: conflicto de parametros en funcion \""+simbolo+"\"");
			}
		}
		if(der!=null){
			R32.ind++;
			der.simbolo=simbolo;
			der.validaTipos();
		}
	}
	
	@Override
	public String generaCodigo(){
		Nodo.contpush++;
		String codigo="";
		if(izq!=null)
			codigo+=izq.generaCodigo();
		if(der!=null)
			codigo+=der.generaCodigo();
		return codigo;	
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		tipoDato='i';
	}
	
	public String generaCodigo(){
		return "push "+simbolo+"\n";
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		tipoDato='f';
	}
	
	public String generaCodigo(){
		return "push "+simbolo+"\n";
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		tipoDato='s';
	}
	
	public String generaCodigo(){
		return "push "+simbolo+"\n";
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(tablasimbolos.funcionDefinida(simbolo1[2])){
			tablasimbolos.buscaFuncion(simbolo1[2]);
			tipoDato=tablasimbolos.funcion.tipo;
			if(sig!=null){
				sig.simbolo=simbolo1[2];
				sig.validaTipos();
			}
		}
		else{
			tablasimbolos.listaErrores.add("Error: la funcion \""+simbolo1[2]+"\" no esta definida");
		}
		
		Nodo.ambito="";
	}
	
	@Override
	public String generaCodigo(){
		String codigo="";
		Nodo.contpush=0;
		if(sig!=null)
			codigo+=sig.generaCodigo();
		codigo+="call "+simbolo1[2]+"\n";
		for(int i=0;i<Nodo.contpush;i++)
			codigo+="pop edx\n";
		Nodo.contpush=0;
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='i' || izq.tipoDato=='f') && izq.tipoDato==der.tipoDato)
			tipoDato=izq.tipoDato;
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
	}
	
	public String generaCodigo(){
		String codigo;
		
		codigo=izq.generaCodigo();
		codigo+=der.generaCodigo();
		if(simbolo.equals("*"))
			codigo+="pop eax \npop ebx \nmul ebx \npush eax\n";
		else
			codigo+="pop eax \npop ebx \ndiv ebx \npush eax\n";
		return codigo;
		
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String generaCodigo(){
		String codigo;
		codigo=izq.generaCodigo();
		codigo+=der.generaCodigo();
		if(simbolo.equals("+"))
			codigo+="pop eax \npop ebx \nadd eax,ebx \npush eax\n";
		else
			codigo+="pop eax \npop ebx \nsub eax,ebx \npush eax\n";
		return codigo;
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='i' || izq.tipoDato=='f') && izq.tipoDato==der.tipoDato)
			tipoDato=izq.tipoDato;
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='i' || izq.tipoDato=='f') && izq.tipoDato==der.tipoDato)
			tipoDato='b';
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
	}
	
	@Override
	public String generaCodigo(){
		String codigo="";
		
		codigo+=izq.generaCodigo();
		codigo+=der.generaCodigo();
		if(simbolo.equals("<"))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \njnl ";
		if(simbolo.equals(">"))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \njng ";
		if(simbolo.equals("=="))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \njne ";
		if(simbolo.equals("<="))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \njnle ";
		if(simbolo.equals(">="))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \njnge ";
		if(simbolo.equals("!="))
			codigo+="pop eax \npop ebx \ncmp ebx,eax \nje ";
		
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='i' || izq.tipoDato=='f') && izq.tipoDato==der.tipoDato)
			tipoDato='b';
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='b') && izq.tipoDato==der.tipoDato)
			tipoDato=izq.tipoDato;
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
	}
	
	@Override
	public String generaCodigo(){
		String codigo="";
		
		codigo+=izq.generaCodigo();
		codigo+=der.generaCodigo();
		codigo+="pop eax \npop ebx \nand eax,ebx \npush eax";
		return codigo;
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(izq!=null)
			izq.validaTipos();
		if(der!=null)
			der.validaTipos();
		if((izq.tipoDato=='i' || izq.tipoDato=='f') && izq.tipoDato==der.tipoDato)
			tipoDato=izq.tipoDato;
		else
			tablasimbolos.listaErrores.add("Error: no coinciden los tipos de dato");
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(sig!=null){
			sig.validaTipos();
			tipoDato=sig.tipoDato;
		}
	}
}