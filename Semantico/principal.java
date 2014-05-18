package Semantico;
import Sintactico3.*;
import Lexico.*;


public class principal {
	
	public static void main(String args[]){
		Nodo.tablasimbolos=null;
		Nodo.ambito="";
		Lexico lexico=new Lexico(
								 "int func(int c, int g){"
								+ "}"
								+ "int main(){"
								+ "int m,j;"
								+ "m= 2 + 2;"
								+ "j=m;"
								+ "}");
		Sintactico sintactico=new Sintactico();
		Semantico semantico=new Semantico();
		semantico.analiza(sintactico.analiza(lexico));
	}
	
	

}
