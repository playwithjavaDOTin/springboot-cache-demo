package playwithjava.in.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import playwithjava.in.bean.ErrorBean;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBean> handleAppException(Exception exception){
        //log.info("##############  Some Error  ");
        ErrorBean errorBean=ErrorBean.builder()
                //.errorMsg(exception.getLocalizedMessage())
                .errorCode("400")
                .build();

        return new ResponseEntity<>(errorBean, HttpStatus.BAD_REQUEST);


    }
}
