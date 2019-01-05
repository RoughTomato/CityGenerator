package citygenerator.util;

import citygenerator.markov.MarkovChain;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class ListToolsTest {

    String[] str = {"A", "B", "C", "A" };

    @Test
    public void removeDuplicates() {
        ArrayList list = new ArrayList<>();
        String[] expected = {"A", "B", "C"};
        list.addAll(Arrays.asList(str));
        list = (ArrayList<String>) ListTools.removeDuplicates(list);
        Assert.assertEquals(list.toArray(), expected);
    }
}