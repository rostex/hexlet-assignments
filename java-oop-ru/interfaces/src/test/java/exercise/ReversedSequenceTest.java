package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    @Test
    void testReversedSequence() {
        CharSequence text = new ReversedSequence("abcdef");

        var toStringExpected = "fedcba";
        var charAtExpected = 'e';
        var lengthExpected = 6;
        var subSequenceExpected = "edc";

        assertThat(text.toString()).isEqualTo(toStringExpected);
        assertThat(text.charAt(1)).isEqualTo(charAtExpected);
        assertThat(text.length()).isEqualTo(lengthExpected);
        assertThat(text.subSequence(1, 4).toString()).isEqualTo(subSequenceExpected);


    }
}
