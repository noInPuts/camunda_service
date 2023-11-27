package cphbusiness.noInPuts.camunda_process_engine.dto;

import jakarta.validation.constraints.*;

public class RestaurantApplicationFormDTO {

    @NotBlank
    @Size(min = 1)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private int postcode;

    @NotNull
    @Min(0)
    private int restaurant_age;

    public RestaurantApplicationFormDTO(String name, String email, String phone, int postcode, int restaurant_age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.postcode = postcode;
        this.restaurant_age = restaurant_age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getRestaurant_age() {
        return restaurant_age;
    }

    public void setRestaurant_age(int restaurantAge) {
        this.restaurant_age = restaurantAge;
    }
}
