package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) {
        String serializeCar = Car.serialize(car);
        try {
            Files.writeString(filePath, serializeCar, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Car extract(Path pathFile) {
        String content;
        try {
            content = Files.readString(pathFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.deserialize(content);

    }
}
// END
