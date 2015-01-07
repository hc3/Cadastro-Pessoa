package br.com.devmedia.exception;

public class ValidaException extends Exception{

	private static final long serialVersionUID = 4497209784510459294L;

	public ValidaException(String msg , Exception exception){
		super(msg,exception);
	}
	
	public ValidaException(String msg){
		super(msg);
	}
	
}
