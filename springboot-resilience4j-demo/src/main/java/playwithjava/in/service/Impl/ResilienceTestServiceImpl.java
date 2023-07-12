package playwithjava.in.service.Impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.service.ResilienceTestService;

import java.util.Arrays;
@Slf4j
@Service
public class ResilienceTestServiceImpl implements ResilienceTestService {



    @Autowired
    RestTemplate restTemplate;





    @Override
    public EmployeeResponse getEmpData(Long empId) {
        log.info("################  Calling Remote Employee Service ...");
        String remoteUrl="http://localhost:9002/employee/emp/getEmployee/"+empId;
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<?> body = new HttpEntity<>(headers);

        ResponseEntity<EmployeeResponse> data= restTemplate.exchange(remoteUrl, HttpMethod.GET, body,EmployeeResponse.class);

        return data.getBody();
    }



}
