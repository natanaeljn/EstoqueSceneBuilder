package model.exceçõesEstoque;

import javax.lang.model.type.NullType;

public class elementoNulo extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public elementoNulo(String msg) {
		super(msg);
	}

}
