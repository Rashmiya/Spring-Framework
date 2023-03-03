package lk.ijse.spring.Advicer;

import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {   /*handle exceptions in Application*/

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   /*lebenne error msg ekak bawa penweemata*/
    @ExceptionHandler({RuntimeException.class})  /*Exception hierarchy eke thiyena one class ekak denna pluwn*/

    public ResponseUtil handleException(RuntimeException e){
        return new ResponseUtil(500,e.getMessage(),null);
    }
}
