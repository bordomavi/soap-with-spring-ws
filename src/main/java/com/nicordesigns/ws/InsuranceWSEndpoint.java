package com.nicordesigns.ws;

import com.nicordesigns.spring_ws_insurance.InsuranceRequest;
import com.nicordesigns.spring_ws_insurance.InsuranceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class InsuranceWSEndpoint {


    public static final String NAMESPACE_URI = "http://www.nicordesigns.com/spring-ws-insurance";

     @Autowired
     private InsuranceService insuranceService;

//    private InsuranceService insuranceService;
//    @Autowired
//    public InsuranceWSEndpoint(InsuranceService insuranceService){
//
//        this.insuranceService = insuranceService;
//    }

//  from branch conclusion2

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsuranceRequest")
    @ResponsePayload
    public InsuranceResponse InsuranceApplication(@RequestPayload InsuranceRequest request) throws Exception{
        if(request != null){
            insuranceService.writeInsuranceApplication(request);
        }

        return insuranceService.processInsuranceApplication(request);
    }




}
