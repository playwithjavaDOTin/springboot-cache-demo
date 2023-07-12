package playwithjava.in.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResilienceDemoApiException extends RuntimeException{

    Long errorCode;

    public ResilienceDemoApiException(String message, Long errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
