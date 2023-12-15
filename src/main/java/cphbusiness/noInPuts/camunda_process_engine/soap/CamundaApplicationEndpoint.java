package cphbusiness.noInPuts.camunda_process_engine.soap;

import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationRequest;
import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationResponse;
import cphbusiness.noInPuts.camunda_process_engine.facades.ServiceFacade;
import cphbusiness.noInPuts.camunda_process_engine.service.ProcessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class CamundaApplicationEndpoint {
    public static final String NAMESPACE_URI = "http://cphbusiness.noInPuts.camunda_process_engine/soap";

    private final ServiceFacade serviceFacade;

    @Autowired
    public CamundaApplicationEndpoint(ServiceFacade serviceFacade) {
        this.serviceFacade = serviceFacade;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StartRestaurantApplicationRequest")
    @ResponsePayload
    public StartRestaurantApplicationResponse startRestaurantApplication(@Valid @RequestPayload StartRestaurantApplicationRequest restaurantForm) {
        return serviceFacade.startRestaurantApplicationProcess(restaurantForm);
    }
}
