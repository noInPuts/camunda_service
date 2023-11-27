package cphbusiness.noInPuts.camunda_process_engine.soap;

import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationRequest;
import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationResponse;
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

    private final ProcessService processService;

    @Autowired
    public CamundaApplicationEndpoint(ProcessService processService) {
        this.processService = processService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StartRestaurantApplicationRequest")
    @ResponsePayload
    public StartRestaurantApplicationResponse startRestaurantApplication(@Valid @RequestPayload StartRestaurantApplicationRequest restaurantForm) {
        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("name", restaurantForm.getName());
        processVariables.put("email", restaurantForm.getEmail());
        processVariables.put("phone", restaurantForm.getPhone());
        processVariables.put("postcode", restaurantForm.getPostcode());
        processVariables.put("restaurant_age", restaurantForm.getRestaurantAge());

        processService.startRestaurantApplication(processVariables);

        StartRestaurantApplicationResponse response = new StartRestaurantApplicationResponse();
        response.setApplicationStatus("Process started successfully");
        return response;
    }
}
