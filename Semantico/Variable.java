package Semantico;

public class Variable extends ElementoTabla{
	protected boolean local;
	
	public String ambito;
	
	public Variable(char tipo, String simbolo, String ambito){
		this.tipo=tipo;
		this.simbolo=simbolo;
		this.ambito=ambito;
		local=(this.ambito.compareTo("") != 0);
	}
	
	public boolean esVariable(){
		return true;
	}
	
	public boolean esVarLocal(){
		return local;
	}
	
	public boolean esFuncion(){
		return false;
	}
	
	public void muestra(){
		System.out.print("Variable "+simbolo+" tipo= "+tipo);
		if(local) System.out.println(" local ");
		else System.out.println(" global ");
	}
}