package Sintactico3;
import Semantico.Semantico;

public class R11 extends Nodo{
	public String simbolo1[]=new String[2];
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	public void validaTipos(){
		tipoDato=dameTipo();
		if(tablasimbolos.varLocalDefinida(simbolo1[1], ambito))
			tablasimbolos.listaErrores.add("Error: variable local \""+simbolo1[1]+"\" redefinida");
		else if(tablasimbolos.varGlobalDefinida(simbolo1[0]))
			tablasimbolos.listaErrores.add("Error: variable global \""+simbolo1[1]+"\" redefinida");
		else{
			tablasimbolos.agrega(this);
			R9.parametros=simbolo1[0]+" "+simbolo1[1];
		}
		if(sig!=null)
			sig.validaTipos();
	}
	
	public char dameTipo(){
		if(simbolo1[0].compareTo("int")==0) return 'i';
		if(simbolo1[0].compareTo("float")==0) return 'f';
		if(simbolo1[0].compareTo("string")==0) return 's';
		if(simbolo1[0].compareTo("void")==0) return 'v';
		return ' ';
	}
	
	@Override
	public String generaCodigo(){
		String codigo;
		codigo=simbolo1[1]+"_"+Nodo.ambito+" dd ?";
		Semantico.listaVariables.add(codigo);
		codigo="mov eax,[ebp+"+(8+(Nodo.contpar*4))+"]\n";
		codigo+="mov "+simbolo1[1]+"_"+Nodo.ambito+",eax\n";
		if(sig!=null){
			Nodo.contpar++;
			codigo+=sig.generaCodigo();
		}
		return codigo;
	}
}
