package playwithjava.in.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.service.ResilienceTestService;

@Slf4j
@RestController
@RequestMapping("/resilienceTestController")
public class ResilienceTestController {


    @Autowired
    ResilienceTestService resilienceTestService;


   // @Retry(name = "default",fallbackMethod = "callme")
    @CircuitBreaker(name = "default",fallbackMethod = "callme")
    @GetMapping("getEmpById/{empId}")
    public String getEmpData(@PathVariable Long empId){
        EmployeeResponse res=resilienceTestService.getEmpData(empId);

        return res.getEmail();
      // return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public String callme(Exception e){
        log.info("############  Fallback method called ...");
        return "falback-call ...";
    }

}
