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
				
				case 1:
					nodo=new R1(pila);
					break;
					
				case 3:
					nodo=new R3(pila);
					break;
					
				case 4:
					nodo=new R4(pila);
					break;
					
				case 5:
					nodo=new R5(pila);
					break;
					
				case 6:
					nodo=new R6(pila);
					break;
					
				case 8:
					nodo=new R8(pila);
					break;
					
				case 9:
					nodo=new R9(pila);
					break;
					
				case 11:
					nodo=new R11(pila);
					break;
					
				case 13:
					nodo=new R13(pila);
					break;
					
				case 14:
					nodo=new R14(pila);
					break;
					
				case 16:
					nodo=new R16(pila);
					break;
					
				case 17:
					nodo=new R17(pila);
					break;
					
				case 18:
					nodo=new R18(pila);
					break;
					
				case 20:
					nodo=new R20(pila);
					break;
					
				case 21:
					nodo=new R21(pila);
					break;
					
				case 22:
					nodo=new R22(pila);
					break;
					
				case 23:
					nodo=new R23(pila);
					break;
					
				case 24:
					nodo=new R24(pila);
					break;
					
				case 25:
					nodo=new R25(pila);
					break;
					
				case 27:
					nodo=new R27(pila);
					break;
					
				case 28:
					nodo=new R28(pila);
					break;
					
				case 30:
					nodo=new R30(pila);
					break;
					
				case 32:
					nodo=new R32(pila);
					break;
					
				case 34:
					nodo=new R34(pila);
					break;
					
				case 35:
					nodo=new R35(pila);
					break;
					
				case 36:
					nodo=new R36(pila);
					break;
					
				case 37:
					nodo=new R37(pila);
					break;
					
				case 38:
					nodo=new R38(pila);
					break;
					
				case 39:
					nodo=new R39(pila);
					break;
					
				case 40:
					nodo=new R40(pila);
					break;
					
				case 41:
					nodo=new R41(pila);
					break;
					
				case 42:
					nodo=new R42(pila);
					break;
					
				case 43:
					nodo=new R43(pila);
					break;
					
				case 44:
					nodo=new R44(pila);
					break;
					
				case 45:
					nodo=new R45(pila);
					break;
					
				case 46:
					nodo=new R46(pila);
					break;
					
				case 47:
					nodo=new R47(pila);
					break;
					
				case 48:
					nodo=new R48(pila);
					break;
					
				case 49:
					nodo=new R49(pila);
					break;
					
				case 50:
					nodo=new R50(pila);
					break;
					
				case 51:
					nodo=new R51(pila);
					break;
					
				case 52:
					nodo=new R52(pila);
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
			//imprimeArbol((Expresion)nt.nodo);
			new Grafico().setVisible(true);
		}
		if(accion.elemento==0) System.out.println("Error");
	}
	
	
	/*public void imprimeArbol(Expresion E){
		if(E==null) return;
		ArrayDeque<Nodo> currentlevel,nextlevel;
		currentlevel=new ArrayDeque<Nodo>();
		nextlevel=new ArrayDeque<Nodo>();
		
		currentlevel.add(E);
		while(!currentlevel.isEmpty()){
			Nodo currNode=currentlevel.poll();
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
	*/
	
	public static void main(String args[]){
		Lexico lexico=new Lexico("a+b+c+4");
		Sintactico sint=new Sintactico();
		sint.analiza(lexico);
	}

}
