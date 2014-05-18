package Semantico;

import java.util.ArrayList;
import Sintactico3.*;


public class TablaSimbolos {
	protected ArrayList<ArrayList<ElementoTabla>> tabla;
	public Variable varLocal;
	public Variable varGlobal;
	public Funcion funcion;
	
	public ArrayList<String> listaErrores;
	
	public TablaSimbolos(ArrayList<String> listaErrores){
		this.listaErrores=listaErrores;
		tabla=new ArrayList<ArrayList<ElementoTabla>>();
		for(int i=0;i<211;i++){
			tabla.add(new ArrayList<ElementoTabla>());
		}
	}
	
	public int dispersion(String simbolo){
		int h=0;
		char c;
		char alfa=4;
		
		for(int i=0; i<simbolo.length() ; i++ ){
			c=simbolo.charAt(i);
			h+=alfa*c;
			h=h % 211;
		}
		
		return h%211;
	}
	
	public void agrega(ElementoTabla elemento){
		int ind=dispersion(elemento.simbolo);
		tabla.get(ind).add(elemento);	
	}
	
	public void agrega(R6 defvar){
		char tipo=defvar.dameTipo();
		String identificador=defvar.simbolo1[1];
		ElementoTabla elem;
		
		elem=new Variable(tipo,identificador,Nodo.ambito);
		agrega(elem);
	}
	
	public void agrega(R8 listavar){
		char tipo=listavar.tipoDato;
		String identificador=listavar.simbolo1[0];
		ElementoTabla elem;
		
		elem=new Variable(tipo,identificador,Nodo.ambito);
		agrega(elem);
	}
	
	public void agrega(R9 defFun){
		char tipo=defFun.dameTipo();
		String identificador=defFun.simbolo1[2];
		ElementoTabla elem;
		
		elem=new Funcion(tipo,identificador,"");
		agrega(elem);
	}
	
	public void agrega(R11 parametros){
		char tipo=parametros.dameTipo();
		String identificador=parametros.simbolo1[0];
		ElementoTabla elem;
		
		elem=new Variable(tipo,identificador,Nodo.ambito);
		agrega(elem);
	}
	
	public void agrega(R13 parametros){
		char tipo=parametros.dameTipo();
		String identificador=parametros.simbolo1[1];
		ElementoTabla elem;
		
		elem=new Variable(tipo,identificador,Nodo.ambito);
		agrega(elem);
	}
	
	public void muestra(){
		System.out.println("*** Tabla de Simbolos ***");
		
		for(int i=0; i<211 ; i++){
			if(!tabla.get(i).isEmpty()){
				
				for(int j=0;j<tabla.get(i).size(); j++){
					System.out.println("Lista= ");
					tabla.get(i).get(j).muestra();
				}
			}
		}
	}
	
	public boolean funcionDefinida(String funcion){
		int ind=dispersion(funcion);
		for(int i=0; i<tabla.get(ind).size(); i++){
			if(tabla.get(ind).get(i).esFuncion()){
				if(tabla.get(ind).get(i).simbolo.compareTo(funcion)==0) return true;
			}
		}
		
		return false;
	}
	
	public boolean varGlobalDefinida(String variable){
		int ind=dispersion(variable);
		for(int i=0; i<tabla.get(ind).size(); i++){
			if(tabla.get(ind).get(i).esVariable() && !tabla.get(ind).get(i).esVarLocal()){
				if(tabla.get(ind).get(i).simbolo.compareTo(variable)==0) return true;
			}
		}
		
		return false;
	}
	
	public boolean varLocalDefinida(String variable, String funcion){
		int ind=dispersion(variable);
		ArrayList<ElementoTabla> lista=tabla.get(ind);
		ElementoTabla elem;
		for(int i=0; i<lista.size(); i++){
			elem=lista.get(i);
			if(elem.esVariable() && elem.esVarLocal()){
				if(((Variable)elem).ambito.compareTo(funcion)==0 && elem.simbolo.compareTo(variable)==0) return true;
			}
		}
		return false;
	}
	
	public void buscaIdentificador(String simbolo){
		int ind=dispersion(simbolo);
		ArrayList<ElementoTabla> lista=tabla.get(ind);
		ElementoTabla elem;
		
		varLocal=null;
		varGlobal=null;
		funcion=null;
		
		for(int i=0; i<lista.size();i++){
			elem=lista.get(i);
			if(elem.simbolo.compareTo(simbolo)==0){
				if(elem.esVariable()){
					if(elem.esVarLocal()) varLocal=(Variable)elem;
					else varGlobal=(Variable)elem;
				}
				else
					funcion=(Funcion)elem;
			}
		}
	}
	
	public void buscaFuncion(String simbolo){
		int ind=dispersion(simbolo);
		ArrayList<ElementoTabla> lista=tabla.get(ind);
		ElementoTabla elem;
		
		varLocal=null;
		varGlobal=null;
		funcion=null;
		
		for(int i=0; i<lista.size(); i++){
			elem=(Funcion)lista.get(i);
			if(elem.simbolo.compareTo(simbolo)==0 && elem.esFuncion()){
				funcion=(Funcion)elem;
				return;
			}
		}
	}
}

abstract class ElementoTabla{
	public String simbolo;
	public char tipo;
	
	public abstract boolean esVariable();
	public abstract boolean esVarLocal();
	public abstract boolean esFuncion();
	
	public abstract void muestra();
	
	
}