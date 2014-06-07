package Semantico;
import Sintactico3.*;
import Lexico.*;

import java.io.*;


public class principal {
	
	public static void main(String args[]){
		Nodo.tablasimbolos=null;
		Nodo.ambito="";
		File file;
		FileReader archivo;
		BufferedReader buffer;
		String input="";
		String input1;
		file = new File("/home/fernando/entrada");
		try {
			archivo = new FileReader(file);
			buffer=new BufferedReader(archivo);
			while((input1=buffer.readLine())!=null){
				input+=input1;
			}
		} catch (FileNotFoundException e) {
			System.err.println("No Existe El archivo");
		} catch (IOException e){
			System.err.println("El archivo esta vacio");
		}
		Lexico lexico=new Lexico(input);
		Sintactico sintactico=new Sintactico();
		Semantico semantico=new Semantico();
		semantico.analiza(sintactico.analiza(lexico));
	}
	
	

}
