package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

// BEGIN
@AllArgsConstructor
@Getter
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
            return mapper.writeValueAsString(Car.class);
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
