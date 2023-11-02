package luiz_dev.apivoos.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(ObjectNotFoundException ex){
        ExceptionResponse e = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), "The requested object could not be found. Try modifying the search variables.");
        return e;
    }

    @ExceptionHandler(ObjectNotCreatedException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ExceptionResponse noCreatedException(ObjectNotCreatedException ex){
        ExceptionResponse e = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), "Object Not Could created. Try modify the invalid informations.");
        return e;
    }
}
