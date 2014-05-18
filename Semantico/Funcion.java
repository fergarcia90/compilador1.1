package Semantico;

public class Funcion extends ElementoTabla{
	public String parametros;
	
	public Funcion(char tipo, String simbolo, String parametros){
		this.tipo=tipo;
		this.simbolo=simbolo;
		this.parametros=parametros;
	}
	
	public boolean esFuncion(){
		return true;
	}
	
	public boolean esVariable(){
		return false;
	}
	
	public boolean esVarLocal(){
		return false;
	}

	public void muestra() {
		System.out.println("Funcion: "+simbolo+" tipo= "+tipo+" Parametros= "+parametros);
	}
	
}
