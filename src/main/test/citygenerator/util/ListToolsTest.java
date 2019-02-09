package citygenerator.util;

import citygenerator.model.DataLayer.BussinesLogic.markov.MarkovChain;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

public class ListToolsTest {

    String[] str = {"A", "B", "C", "A" };

    @Test
    public void removeDuplicatesTest() {
        ArrayList list = new ArrayList<>();
        String[] expected = {"A", "B", "C"};
        list.addAll(Arrays.asList(str));
        list = (ArrayList<String>) ListTools.removeDuplicates(list);
        Assert.assertArrayEquals(list.toArray(), expected);
    }
}