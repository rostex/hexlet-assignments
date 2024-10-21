package exercise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> nullList = new ArrayList<>();
        Class<?> aClass = object.getClass();

        Field[] fields = aClass.getDeclaredFields();
        for (var field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        nullList.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return nullList;
    }

    public static Map<String, List<String>> advancedValidate (Object object) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        Class<?> aClass = object.getClass();

        Field[] fields = aClass.getDeclaredFields();
        for (var field : fields) {
            List<String> errors = new ArrayList<>();
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        errors.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                try {
                    var fieldName = field.get(object).toString();
                    var minLength = field.getAnnotation(MinLength.class).minLength();
                    if (fieldName.length() < minLength) {
                        errors.add("length less than " + minLength);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if(!errors.isEmpty()) {
                notValidFields.put(field.getName(), errors);
            }
        }
        return notValidFields;
    }
}
// END
