package Lexico;

public class Principal {
	
	public static void main(String args[]){
		
		Lexico lexico=new Lexico("x1 3 3.98\"hola\"int +*>=||&&!==;(){}=if while return \"hola\"");
		
		System.out.println("Resultado de Analisis Lexico");
		System.out.println("Simbolo\t\tTipo");
		
		while(!lexico.simbolo.equals("$")){
			lexico.sigSimbolo();
			System.out.println(lexico.simbolo+"\t\t"+lexico.tipoAcad(lexico.tipo));
		}
	}
}
