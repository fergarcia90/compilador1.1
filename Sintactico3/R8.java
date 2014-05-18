package Sintactico3;

public class R8 extends Nodo{
	public String simbolo1[]=new String[2];
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
	
	@Override
	public void validaTipos(){
		if(tablasimbolos.varGlobalDefinida(simbolo1[0]) || tablasimbolos.varLocalDefinida(simbolo1[0], ambito))
			tablasimbolos.listaErrores.add("Error: variable \""+simbolo1[0]+"\" redefinida");
		else
			tablasimbolos.agrega(this);
	}
}
