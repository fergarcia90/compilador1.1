package Sintactico2;

public class Principal {
	
	public void ejemplo(){
		Pila pila=new Pila();
		Alumno alumno;
		
		alumno=new Licenciatura("345678","Computacion",200);
		pila.push(alumno);
		
		pila.push(new Bachillerato("456789","Preparatoria 12"));
		pila.push(new Licenciatura("456789","Informatica",50));
		pila.muestra();
		
		System.out.println("*********************************");
		
		pila.pop();
		pila.muestra();
	}
	
	public static void main(String args[]){
		Principal prin=new Principal();
		prin.ejemplo();
	}

}
