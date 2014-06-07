package Sintactico3;
import Semantico.Semantico;

public class R6 extends Nodo{
	public String simbolo1[]=new String[3];
	
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
	
	public void validaTipos(){
		tipoDato=dameTipo();
		if(ambito.equals("")){
			if(tablasimbolos.varGlobalDefinida(simbolo1[1]))
				tablasimbolos.listaErrores.add("Error: variable global \""+simbolo1[1]+"\" redefinida");
			else
				tablasimbolos.agrega(this);
		}
		else
		if(tablasimbolos.varLocalDefinida(simbolo1[1], ambito))
			tablasimbolos.listaErrores.add("Error: variable local \""+simbolo1[1]+"\" redefinida");
		else
			tablasimbolos.agrega(this);
		if(sig!=null){
			sig.tipoDato=dameTipo();
			sig.validaTipos();
		}
	}
	
	public char dameTipo(){
		if(simbolo1[2].compareTo("int")==0) return 'i';
		if(simbolo1[2].compareTo("float")==0) return 'f';
		if(simbolo1[2].compareTo("string")==0) return 's';
		if(simbolo1[2].compareTo("void")==0) return 'v';
		return ' ';
	}
	
	public String generaCodigo(){
		String codigo;
		if(Nodo.ambito.equals(""))
			codigo=simbolo1[1]+" dd ?";
		else
			codigo=simbolo1[1]+"_"+Nodo.ambito+" dd ?";
		Semantico.listaVariables.add(codigo);
		return "";
	}
}
