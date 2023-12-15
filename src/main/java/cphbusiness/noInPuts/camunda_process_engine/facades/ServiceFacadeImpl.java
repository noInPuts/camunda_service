package cphbusiness.noInPuts.camunda_process_engine.facades;

import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationRequest;
import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationResponse;
import cphbusiness.noInPuts.camunda_process_engine.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceFacadeImpl implements ServiceFacade {

    private final ProcessService processService;

    @Autowired
    public ServiceFacadeImpl(ProcessService processService) {
        this.processService = processService;
    }

    @Override
    public StartRestaurantApplicationResponse startRestaurantApplicationProcess(StartRestaurantApplicationRequest restaurantForm) {        Map<String, Object> processVariables = new HashMap<>();
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
