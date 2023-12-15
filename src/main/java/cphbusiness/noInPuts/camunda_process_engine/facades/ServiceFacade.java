package cphbusiness.noInPuts.camunda_process_engine.facades;

import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationRequest;
import camunda_process_engine.noinputs.cphbusiness.soap.StartRestaurantApplicationResponse;

import java.util.Map;

public interface ServiceFacade {
    StartRestaurantApplicationResponse startRestaurantApplicationProcess(StartRestaurantApplicationRequest restaurantForm);
}
