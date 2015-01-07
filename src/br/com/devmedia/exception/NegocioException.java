package br.com.devmedia.exception;

public class NegocioException extends Exception{

	private static final long serialVersionUID = 4497209784510459294L;

	public NegocioException(String msg , Exception exception){
		super(msg,exception);
	}
	
	public NegocioException(String msg){
		super(msg);
	}
	
}
