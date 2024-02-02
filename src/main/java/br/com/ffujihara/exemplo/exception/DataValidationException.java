package br.com.ffujihara.exemplo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataValidationException extends RuntimeException{

        public DataValidationException(String message){
            super(message);
        }
}
