package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    public String tagName;
    public Map<String, String> attribute;

    public Tag(String tagName, Map<String, String> attribute) {
        this.tagName = tagName;
        this.attribute = attribute;
    }

    public String getTagName() {
        return tagName;
    }


    public Map<String, String> getAttribute() {
        return attribute;
    }


    public String getAttributesAsString() {
        StringBuilder result = new StringBuilder();
        for (var entry : attribute.entrySet()) {
            result.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
        }
        return String.valueOf(result);
    }
}
// END
