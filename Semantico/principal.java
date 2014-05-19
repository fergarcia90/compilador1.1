package Semantico;
import Sintactico3.*;
import Lexico.*;


public class principal {
	
	public static void main(String args[]){
		Nodo.tablasimbolos=null;
		Nodo.ambito="";
		Lexico lexico=new Lexico("void main(){int a; a=2+2+2;}");
		Sintactico sintactico=new Sintactico();
		Semantico semantico=new Semantico();
		semantico.analiza(sintactico.analiza(lexico));
	}
	
	

}
