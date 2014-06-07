package Semantico;

import java.util.ArrayList;
import Sintactico3.Nodo;

public class Semantico {
	protected ArrayList<String> listaErrores;
	protected Nodo arbol;
	TablaSimbolos tablasimbolos;
	public static ArrayList<String> listaVariables;
	
	public Semantico(){
		listaErrores=new ArrayList<String>();
		listaVariables=new ArrayList<String>();
		Nodo.tablasimbolos=tablasimbolos=new TablaSimbolos(listaErrores);
	}
	
	public void analiza(Nodo arbol){
		this.arbol=arbol;
		String codigo;
		arbol.validaTipos();
		tablasimbolos.muestra();
		muestraErrores();
		if(listaErrores.isEmpty()){
			codigo=arbol.generaCodigo();
			System.out.println(".386\n"+
					".model flat\n"+
					"printf  proto c :ptr BYTE, :VARARG\n"+
					"exit proto c :dword\n"+

					"CStr macro text:VARARG\n"+
					"local x\n"+
					".const\n"+
					"x   db text,0\n"+
					".code\n"+
					"exitm <offset x>\n"+
					"endm\n");
			System.out.println(".data");
			variables();
			System.out.println(".code\n"
					+ "_start:\n"
					+ "call main\n"
					+ "invoke exit, 0\n");
			System.out.println(codigo+
					"\nend _start");
		}
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
	
	public void variables(){
		if(!listaVariables.isEmpty()){
			for(int i=0; i<listaVariables.size() ; i++){
				System.out.println(listaVariables.get(i));
			}
		}
	}

}
