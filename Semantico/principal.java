package Semantico;
import Sintactico3.*;
import Lexico.*;


public class principal {
	
	public static void main(String args[]){
		Nodo.tablasimbolos=null;
		Nodo.ambito="";
		Lexico lexico=new Lexico(""
				+ ""
				+ "float suma(float a, float b){"
				+ "float res; "
				+ "res=a*b;"
				+ "if(a<0.0)"
				+ "{a=0.0;}"
				+ "else a=0.0;"
				+ "while(a>0.0)"
				+ "{b=0.0;}	"
				+ "return 9.9;"
				+ "}"
				
				+ "void main(){float a; float x; int y; a=suma(8.9,9.9);}");
		Sintactico sintactico=new Sintactico();
		Semantico semantico=new Semantico();
		semantico.analiza(sintactico.analiza(lexico));
	}
	
	

}
