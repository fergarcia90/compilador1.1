package Sintactico;
import Lexico.Lexico;
import Lexico.TipoSimbolo;

public class Sintactico {
	int tablaLR[][]={
			{2 , 0 , 0 , 1},
			{0 , 0 ,-1 , 0},
			{0 , 3 ,-3 , 0},
			{2 , 0 , 0 , 4},
			{0 , 0 ,-2 , 0}
	};
	
	int idReglas[]={3,3};
	int ionReglas[]={3,1};
	
	public void ejemplo1(){
		Pila pila=new Pila();
		
		pila.push(2);
		pila.push(3);
		pila.push(4);
		pila.push(5);
		pila.muestra();
		
		System.out.println(pila.top());
		System.out.println(pila.top());
		System.out.println(pila.pop());
		System.out.println(pila.pop());
	}
	
	public void ejemplo2(){
		Lexico lexico=new Lexico("a");
		
		while(!lexico.terminado()){
			lexico.sigSimbolo();
			System.out.println(lexico.simbolo);
		}
	}
	
	public void ejemplo3(){
		Pila pila=new Pila();
		int fila,columna,accion;
		boolean aceptacion=false;
		Lexico lexico=new Lexico("a");
		
		pila.push(TipoSimbolo.PESOS);
		pila.push(0);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.push(lexico.tipo);
		pila.push(accion);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.pop();
		pila.pop();
		
		fila=pila.top();
		columna=2;
		accion=tablaLR[fila][columna];
		
		pila.push(2);
		pila.push(accion);
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		fila= pila.top();
		columna= lexico.tipo;
		accion= tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		aceptacion= accion == -1;
		if (aceptacion) System.out.println("aceptacion");
		
	}
	
	public void ejercicio1(){
		Pila pila=new Pila();
		int fila,columna,accion;
		boolean aceptacion=false;
		Lexico lexico=new Lexico("a+b");
		
		pila.push(TipoSimbolo.PESOS);
		pila.push(0);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.push(lexico.tipo);
		pila.push(accion);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.push(lexico.tipo);
		pila.push(accion);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.push(lexico.tipo);
		pila.push(accion);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		pila.pop();
		pila.pop();
		pila.pop();
		pila.pop();
		pila.pop();
		pila.pop();
		
		fila=pila.top();
		columna=3;
		accion=tablaLR[fila][columna];
		
		pila.push(3);
		pila.push(accion);
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		aceptacion= accion==-1;
		if(aceptacion) System.out.println("Aceptacion");
		
	}
	
	public void ejercicio2(){
		Pila pila=new Pila();
		Lexico lexico=new Lexico("a+b+c");
		int fila,columna,accion;
		
		pila.push(TipoSimbolo.PESOS);
		pila.push(0);
		lexico.sigSimbolo();
		
		fila=pila.top();
		columna=lexico.tipo;
		accion=tablaLR[fila][columna];
		pila.muestra();
		System.out.println("entrada: "+lexico.simbolo);
		System.out.println("accion: "+accion);
		
		
		while(accion!=0 && accion!=-1){
			if(accion>0){
				pila.push(lexico.tipo);
				pila.push(accion);
				lexico.sigSimbolo();
				fila=pila.top();
				columna=lexico.tipo;
				accion=tablaLR[fila][columna];
				pila.muestra();
				System.out.println("entrada: "+lexico.simbolo);
				System.out.println("accion: "+accion);
			}
			else
			if(accion<0){
				int regla=(accion+2)*-1;
				for(int i=0;i<ionReglas[regla]*2;i++){
					pila.pop();
				}
				fila=pila.top();
				columna=idReglas[regla];
				accion=tablaLR[fila][columna];
				pila.push(idReglas[regla]);
				pila.push(accion);
				pila.muestra();
				System.out.println("entrada: "+lexico.simbolo);
				System.out.println("accion: "+accion);
				fila=pila.top();
				columna=lexico.tipo;
				accion=tablaLR[fila][columna];
				pila.muestra();
				System.out.println("entrada: "+lexico.simbolo);
				System.out.println("accion: "+accion);
			}
		}
		
		if(accion==-1) System.out.println("Aceptacion");
		if(accion==0) System.out.println("Error");
	}
	
	

}
