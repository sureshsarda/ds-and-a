package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GroupAnagramTest {

    Random rand = new Random(42);

    public void testGroupAnagrams() {
        List<List<String>> var = GroupAnagram.groupAnagrams(randomInput(3, 10, 100000));
        System.out.println(var);
    }

    public String[] randomInput(int minLength, int maxLength, int samples) {
        String[] inputs = new String[samples];
//
//        for (int i = 0; i < samples; i++) {
//            inputs[i] = RandomStringUtils.randomAlphabetic(minLength, maxLength);
//        }
//
        return inputs;


    }


    @Test
    public void testConvertToKey() {
        assertEquals("e1h1l2o1", GroupAnagram.convertToKey("hello"));
        assertEquals("a2b2c1", GroupAnagram.convertToKey("abbca"));
    }

}
