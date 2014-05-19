package Semantico;

import java.util.ArrayList;
import Sintactico3.Nodo;

public class Semantico {
	protected ArrayList<String> listaErrores;
	protected Nodo arbol;
	TablaSimbolos tablasimbolos;
	
	public Semantico(){
		listaErrores=new ArrayList<String>();
		Nodo.tablasimbolos=tablasimbolos=new TablaSimbolos(listaErrores);
	}
	
	public void analiza(Nodo arbol){
		this.arbol=arbol;
		arbol.validaTipos();
		tablasimbolos.muestra();
		muestraErrores();
		if(listaErrores.isEmpty())
			System.out.println(arbol.generaCodigo());
	}
	
	public void muestraErrores(){
		if(listaErrores.isEmpty()) return;
		
		String cad;
		System.out.println("Errores Semanticos");
		for(int i=0; i<listaErrores.size(); i++){
			cad=listaErrores.get(i);
			System.out.println(cad);
		}
	}
	
	public boolean existenErrores(){
		return !listaErrores.isEmpty();
	}

}
