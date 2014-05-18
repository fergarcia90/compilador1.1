package Semantico;
import Sintactico3.*;
import Lexico.*;


public class principal {
	
	public static void main(String args[]){
		Nodo.tablasimbolos=null;
		Nodo.ambito="";
		Lexico lexico=new Lexico("int a;"
								+ "int func(){"
								+ "a=0;"
								+ "int b;"
								+ "b=a;"
								+ "return a;"
								+ "}"
								+ "int main(){"
								+ "int f;"
								+ "f=func();"
								+ "}");
		Sintactico sintactico=new Sintactico();
		Semantico semantico=new Semantico();
		semantico.analiza(sintactico.analiza(lexico));
	}
	
	

}
