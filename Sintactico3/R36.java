package Sintactico3;

public class R36 extends Nodo{
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

	@Override
	public void validaDatos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void validaTipos(){
		if(tablasimbolos.varLocalDefinida(simbolo, Nodo.ambito)){
			tablasimbolos.buscaIdentificador(simbolo);
			tipoDato=tablasimbolos.varLocal.tipo;
		}
		else if(tablasimbolos.varGlobalDefinida(simbolo)){
			tablasimbolos.buscaIdentificador(simbolo);
			tipoDato=tablasimbolos.varGlobal.tipo;
		}
		else{
			tablasimbolos.listaErrores.add("Error: la variable \""+simbolo+"\" no esta definida "+Nodo.ambito);
			tipoDato='v';
		}
	}
	
	public String generaCodigo(){
		return "push "+simbolo+"_"+Nodo.ambito+"\n";
	}
}
