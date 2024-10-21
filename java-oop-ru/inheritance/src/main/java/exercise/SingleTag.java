package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{

    public SingleTag(String tagName, Map<String, String> attribute) {
        super(tagName, attribute);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", getTagName(), getAttributesAsString());
    }
}
// END
