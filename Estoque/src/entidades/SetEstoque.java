package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetEstoque {

	private ArrayList<EstoqueClasse>est;
	public SetEstoque() {
		est = new ArrayList<EstoqueClasse>();
	}
	public void add (EstoqueClasse e ) {
		if(e!= null) {
			est.add(e);
		}
	}
    public ArrayList<EstoqueClasse> get(){
    	return est;
    }
}
