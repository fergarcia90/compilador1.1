package Sintactico3;

public class R9 extends Nodo{
	public String simbolo1[]=new String[4];
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
	
	public void validaTipos(){
		tipoDato=dameTipo();
		Nodo.ambito=simbolo1[2];
		if(tablasimbolos.funcionDefinida(Nodo.ambito))
			tablasimbolos.listaErrores.add("Error: funcion \""+Nodo.ambito+"\" redefinida");
		else
			tablasimbolos.agrega(this);
		
		if(izq!=null)
			izq.validaTipos();
		if(der!=null){
			der.tipoDato=tipoDato;
			der.validaTipos();
		}
		ambito="";
		}
	
	public char dameTipo(){
		if(simbolo1[3].compareTo("int")==0) return 'i';
		if(simbolo1[3].compareTo("float")==0) return 'f';
		if(simbolo1[3].compareTo("string")==0) return 's';
		if(simbolo1[3].compareTo("void")==0) return 'v';
		return ' ';
	}
}
