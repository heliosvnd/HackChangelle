package sga.services.exceptions;

public class BusinessException extends RuntimeException{
private static final long serialVersionUID = 1L;

public BusinessException(String mensaje, Exception e){
    super(mensaje, e);
  }


}
