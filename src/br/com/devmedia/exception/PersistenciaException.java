package br.com.devmedia.exception;

public class PersistenciaException extends Exception {
	
	private static final long serialVersionUID = 4497209784510459294L;

	public PersistenciaException(String msg , Exception exception){
		super(msg,exception);
	}
	
	public PersistenciaException(String msg){
		super(msg);
	}
}
