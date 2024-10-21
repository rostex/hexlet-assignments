package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> childTag;

    public PairedTag(String tagName, Map<String, String> attribute, String tagBody, List<Tag> childTag) {
        super(tagName, attribute);
        this.tagBody = tagBody;
        this.childTag = childTag;
    }

    @Override
    public String toString() {
        var childTagValue = childTag.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        return String.format("<%s%s>%s%s</%s>", getTagName(), getAttributesAsString(), tagBody, childTagValue, getTagName());
    }
}
// END
