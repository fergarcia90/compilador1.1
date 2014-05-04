package Sintactico2;

public abstract class Alumno{
	protected String codigo;
	
	public abstract void muestra();
}

class Bachillerato extends Alumno{
	protected String preparatoria;
	
	public Bachillerato(String codigo,String preparatoria){
		this.codigo=codigo;
		this.preparatoria=preparatoria;
	}
	
	public void muestra(){
		System.out.println("Alumno Bachillerato");
		System.out.println("Codigo: "+codigo);
		System.out.println("Preparatoria: "+preparatoria);
		System.out.println();
	}
	
}

class Licenciatura extends Alumno{
	
	protected String carrera;
	protected int creditos;
	
	public Licenciatura(String codigo, String carrera, int creditos){
		this.codigo=codigo;
		this.carrera=carrera;
		this.creditos=creditos;
	}
	
	public void muestra(){
		System.out.println("Alumno Licenciatura");
		System.out.println("Codigo: "+codigo);
		System.out.println("Carrera: "+carrera);
		System.out.println("Creditos: "+creditos);
		System.out.println();
	}
}