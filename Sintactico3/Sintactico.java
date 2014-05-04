package Sintactico3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import Lexico.Lexico;
import Lexico.TipoSimbolo;

public class Sintactico {
	int tablaLR[][];
	String idReglas[];
	int nReglas[];
	int ionReglas[];
	File archivo;
	FileReader lector;
	BufferedReader bf;
	StringTokenizer st;
	
	/*int tablaLR[][]={
			{2 , 0 , 0 , 0 , 1},
			{0 , 3 , 4 ,-1 , 0},
			{0 ,-4 ,-4 ,-4 , 0},
			{2 , 0 , 0 , 0 , 5},
			{2 , 0 , 0 , 0 , 6},
			{0 ,-2 ,-2 ,-2 , 0},
			{0 , 3 ,-3 ,-3 , 0}
	};
	
	String idReglas[]={"E","E","E"};
	int nReglas[]={4,4,4};
	int ionReglas[]={3,3,1};*/
	
	public Sintactico(){
		archivo=new File("c:/Users/LuisFernando/Documents/Taller Compiladores/gramaticaCompilador/gramaticasEjemplo/ejemplo7.lr");
		try {
			lector= new FileReader(archivo);
			bf=new BufferedReader(lector);
			int i=Integer.parseInt(bf.readLine());
			idReglas= new String[i];
			nReglas= new int[i];
			ionReglas= new int[i];
			for(int j=0;j<i;j++){
				st=new StringTokenizer(bf.readLine());
				nReglas[j]=Integer.parseInt(st.nextToken());
				ionReglas[j]=Integer.parseInt(st.nextToken());
				idReglas[j]=st.nextToken();
			}
			st=new StringTokenizer(bf.readLine());
			int filas=Integer.parseInt(st.nextToken());
			int columnas=Integer.parseInt(st.nextToken());
			tablaLR= new int[filas][columnas];
			for(int j=0;j<filas;j++){
				st=new StringTokenizer(bf.readLine());
				for(int k=0;k<columnas;k++){
					tablaLR[j][k]=Integer.parseInt(st.nextToken());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			
		}
	}
	
	public void analiza(Lexico lexico){
		Pila pila=new Pila();
		ElementoPila fila,columna,accion;
		Nodo nodo=null;
		NoTerminal nt=null;
		
		pila.push(new Terminal("$",TipoSimbolo.PESOS));
		pila.push(new Estado(0));
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=new Terminal(lexico.simbolo,lexico.tipo);
		accion=new Estado(tablaLR[fila.elemento][columna.elemento]);
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion.elemento);
		
		
		while(accion.elemento!=0 && accion.elemento!=-1){
			if(accion.elemento>0){
				pila.push(new Terminal(lexico.simbolo,lexico.tipo));
				pila.push(accion);
				lexico.sigSimbolo();
				fila=pila.top();
				columna=new Terminal(lexico.simbolo,lexico.tipo);
				accion=new Estado(tablaLR[fila.elemento][columna.elemento]);
				pila.muestra();
				System.out.println("entrada: "+lexico.simbolo);
				System.out.println("accion: "+accion.elemento);
			}
			else
			if(accion.elemento<0){
				int regla=(accion.elemento+2)*-1;
				
				switch(regla+1){
				case 1://Multiplicacion 
					nodo=new Multiplicacion(pila);
					break;
				
				case 2://Suma
					nodo=new Suma(pila);
					break;
					
				case 3://<Expresion>::=<Termino>
					pila.pop();
					nodo=((NoTerminal)pila.pop()).nodo;
					break;
					
				case 4://Identificador
					nodo=new Identificador(pila);
					break;
					
				case 5://Entero
					nodo=new Entero(pila);
					break;
					
				default:
					for(int i=0;i<ionReglas[regla]*2;i++) pila.pop();
					break;
				}
				//transicion
				fila=pila.top();
				columna=new NoTerminal(idReglas[regla],nReglas[regla]);
				System.out.println(columna.elemento+" "+fila.elemento);
				accion=new Estado(tablaLR[fila.elemento][columna.elemento]);
				nt=new NoTerminal(idReglas[regla],nReglas[regla]);
				nt.nodo=nodo;
				pila.push(nt);
				pila.push(accion);
				pila.muestra();
				System.out.println("Transicion: "+accion.elemento);
				fila=pila.top();
				columna=new Terminal(lexico.simbolo,lexico.tipo);
				accion=new Estado(tablaLR[fila.elemento][columna.elemento]);
				pila.muestra();
				System.out.println("entrada: "+lexico.simbolo);
				System.out.println("accion: "+accion.elemento);
			}
		}
		
		if(accion.elemento==-1){
			System.out.println("Aceptacion");
			imprimeArbol((Expresion)nt.nodo);
			new Grafico().setVisible(true);
		}
		if(accion.elemento==0) System.out.println("Error");
	}
	
	
	public void imprimeArbol(Expresion E){
		if(E==null) return;
		ArrayDeque<Expresion> currentlevel,nextlevel;
		currentlevel=new ArrayDeque<Expresion>();
		nextlevel=new ArrayDeque<Expresion>();
		
		currentlevel.add(E);
		while(!currentlevel.isEmpty()){
			Expresion currNode=currentlevel.poll();
			if(currNode!=null){
				currNode.muestra();
				if(currNode.izq!=null)
				nextlevel.add(currNode.izq);
				if(currNode.der!=null)
				nextlevel.add(currNode.der);
			}
			if(currentlevel.isEmpty()){
				System.out.println();
				ArrayDeque<Expresion> c;
				c=currentlevel;
				currentlevel=nextlevel;
				nextlevel=c;
			}
		}
	}
	
	
	public static void main(String args[]){
		Lexico lexico=new Lexico("a+b+c+4");
		Sintactico sint=new Sintactico();
		sint.analiza(lexico);
	}

}
