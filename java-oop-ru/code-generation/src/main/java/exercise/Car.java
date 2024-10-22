package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static Car deserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
