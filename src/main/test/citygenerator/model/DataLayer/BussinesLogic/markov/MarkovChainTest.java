package citygenerator.model.DataLayer.BussinesLogic.markov;

import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testTools.TestDataLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MarkovChainTest {

    MarkovChain textGenerator;
    Stack<String> data;
    boolean setup = false;

    @Before
    public void setUpOnce() {
        if(setup == false){
            TestDataLoader loader = new TestDataLoader("/markovTestData.xml", "testName");
            data = new Stack<>();
            try {
                data.addAll(loader.getValues());
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            setup = true;
        }
        this.textGenerator = new MarkovChain(data,3,0.0, new AtomicLong(6556523423L));
    }

    @Test
    public void generateNameTest() {
        String s = textGenerator.generateName();
        Assert.assertEquals("dale-gberka-hclig", s);
        s = textGenerator.generateName();
        Assert.assertEquals("gberald", s);
    }

    @Test
    public void generateNamesTest() {
        ArrayList<String> names = new ArrayList<>();
        names.addAll(textGenerator.generateNames(30));
        assertThat(names.size(), is(30));
    }
}