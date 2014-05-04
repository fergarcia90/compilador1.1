package Lexico;

public class Lexico {
	private String fuente;
	private int ind;
	private boolean continua;
	private char c;
	private int estado;
	
	public String simbolo;
	public int tipo;
	
	public Lexico(String f){
		fuente=f;
		simbolo="";
		ind=0;
	}
	
	public Lexico(){
		ind=0;
	}
	
	public String tipoAcad(int tipo){
		String cad="";
		
		switch(tipo){
		case TipoSimbolo.IDENTIFICADOR:
            cad= "Identificador";
            break;
            
       case TipoSimbolo.OPSUMA:
            cad= "Op. Adicion";
            break;

       case TipoSimbolo.OPMUL:
            cad= "Op. Multiplicacion";
            break;            

       case TipoSimbolo.PESOS:
            cad= "Fin de la Entrada";
            break;            

      /* case TipoSimbolo.ENTERO:
            cad= "Entero";
            break;*/
		
	   case TipoSimbolo.REAL:
		   cad= "Real";
		   break;

	   case TipoSimbolo.ASIGNACION:
		   cad = "Asignacion";
		   break;

	   case TipoSimbolo.OPRELAC:
		   cad = "Operador Relacional";
		   break;

	   case TipoSimbolo.OPAND:
		   cad = "Operador And";
		   break;

	   case TipoSimbolo.OPOR:
		   cad = "Operador Or";
		   break;

	   case TipoSimbolo.OPNOT:
		   cad = "Operador Not";
		   break;

	   case TipoSimbolo.PARENTESIS1:
		   cad = "Parentesis";
		   break;

	   case TipoSimbolo.PARENTESIS2:
		   cad = "Parentesis";
		   break;

	   case TipoSimbolo.LLAVE1:
		   cad = "Llave";
		   break;

	   case TipoSimbolo.LLAVE2:
		   cad = "Llave";
		   break;

	   case TipoSimbolo.PUNTOYCOMA:
		   cad = "Punto y coma";
		   break;

	   case TipoSimbolo.TIPO:
		   cad = "Tipo";
		   break;

	   case TipoSimbolo.IF:
		   cad = "if";
		   break;

	   case TipoSimbolo.WHILE:
		   cad = "while";
		   break;

	   case TipoSimbolo.RETURN:
		   cad = "return";
		   break;

	   case TipoSimbolo.ELSE:
		   cad = "else";
		   break;

	   case TipoSimbolo.ERROR:
		   cad = "Error";
		   break;

	   case TipoSimbolo.CADENA:
		   cad = "Cadena";
		   break;
		}
		
		return cad;
	}
	
	public void entrada(String f){
		ind=0;
		simbolo="";
		fuente=f;
	}
	
	public int sigSimbolo(){
		 estado=0;
		    continua= true;
		    simbolo= "";
		    
		    //Inicio del Automata
		    while (continua){
		      c= sigCaracter();
		      
		      switch (estado){
			  case 0: 
				  if (Character.isLetter(c)) sigEstado(1);
				  else
				  if (Character.isDigit(c)) sigEstado(2);
				  else
				  if (c == '+' || c == '-') aceptacion(5);
				  else
				  if (c == '*' || c == '/') aceptacion(6);
				  else
				  if (c == '=') sigEstado(7);
				  else
				  if (c == '<' || c == '>') sigEstado(9);
				  else
				  if (c == '&') sigEstado(10);
				  else
				  if (c == '|') sigEstado(12);
				  else
				  if (c == '!') sigEstado(14);
				  else
				  if (c == '(') aceptacion(15);
				  else
				  if (c == ')') aceptacion(16);
				  else
				  if (c == '{') aceptacion(17);
				  else
				  if (c == '}') aceptacion(18);
				  else
				  if (c == ';') aceptacion(19);
				  else
				  if (c == '$') aceptacion(20);
				  else
				  if (c == '"') sigEstado(21);
				  
				  break;

			  case 1:
				  if (Character.isLetter(c) || Character.isDigit(c)) sigEstado(1);
				  else
					  retroceso();
				  break;

			  case 2:
				  if (Character.isDigit(c)) sigEstado(2);
				  else
				  if (c == '.') sigEstado(3);
				  else
					  retroceso();
				  break;

			  case 3:
				  if (Character.isDigit(c)) sigEstado(4);
				  else
					  aceptacion(-1);
				  break;
				  
			  case 4:
				  if (Character.isDigit(c)) sigEstado(4);
				  else
					  retroceso();
				  break;

			  case 7:
				  if (c == '=') aceptacion(8);
				  else
					  retroceso();
				  break;

			  case 9:
				  if (c == '=') aceptacion(8);
				  else
					  retroceso();
				  break;

			  case 10:
				  if (c == '&') aceptacion(11);
				  else
					  aceptacion(-1);
				  break;

			  case 12:
				  if (c == '|') aceptacion(13);
				  else
					  aceptacion(-1);
				  break;

			  case 14:
				  if (c == '=') aceptacion(8);
				  else
					  retroceso();
				  break;

			  case 21:
				  if (c != '"') sigEstado(21);
				  else
					  aceptacion(22);
				  break;

			 }  
		           
		   }    
		    //Fin del Automata
		    
		      switch (estado){
		              
		         case 1:
		              tipo= TipoSimbolo.IDENTIFICADOR;
					  if (simbolo.equals("int")  || simbolo.equals("float")  || simbolo.equals("void") ) tipo = TipoSimbolo.TIPO;
					  if (simbolo.equals("if") ) tipo = TipoSimbolo.IF;
					  if (simbolo.equals("while") ) tipo = TipoSimbolo.WHILE;
					  if (simbolo.equals("return") ) tipo = TipoSimbolo.RETURN;
					  if (simbolo.equals("else") ) tipo = TipoSimbolo.ELSE;
		              break;

				 case 2:
					 tipo = TipoSimbolo.ENTERO;
					 break;

				 case 4:
					 tipo = TipoSimbolo.REAL;
					 break;

				 case 5:
					 tipo = TipoSimbolo.OPSUMA;
					 break;

				 case 6:
					 tipo = TipoSimbolo.OPMUL;
					 break;

				 case 7:
					 tipo = TipoSimbolo.ASIGNACION;
					 break;

				 case 8:
					 tipo = TipoSimbolo.OPRELAC;
					 break;

				 case 9:
					 tipo = TipoSimbolo.OPRELAC;
					 break;

				 case 11:
					 tipo = TipoSimbolo.OPAND;
					 break;

				 case 13:
					 tipo = TipoSimbolo.OPOR;
					 break;

				 case 14:
					 tipo = TipoSimbolo.OPNOT;
					 break;

				 case 15:
					 tipo = TipoSimbolo.PARENTESIS1;
					 break;

				 case 16:
					 tipo = TipoSimbolo.PARENTESIS2;
					 break;

				 case 17:
					 tipo = TipoSimbolo.LLAVE1;
					 break;

				 case 18:
					 tipo = TipoSimbolo.LLAVE2;
					 break;

				 case 19:
					 tipo = TipoSimbolo.PUNTOYCOMA;
					 break;

				 case 20:
					 tipo = TipoSimbolo.PESOS;
					 break;

				 case 22:
					 tipo = TipoSimbolo.CADENA;
					 break;
		              
		        default:                 
		              tipo= TipoSimbolo.ERROR;
					  break;
		      }
		    		
			return tipo;
	}
	
	private char sigCaracter(){
		if(terminado()) return '$';
		
		return fuente.charAt(ind++);
	}
	
	private void sigEstado(int estado){
		this.estado=estado;
		simbolo+=c;
	}
	
	private void aceptacion(int estado){
		sigEstado(estado);
		continua=false;
	}
	
	public boolean terminado(){
		return ind >= fuente.length();
	}
	
	private void retroceso(){
		if(c!='$') ind--;
		continua=false;
	}

}


