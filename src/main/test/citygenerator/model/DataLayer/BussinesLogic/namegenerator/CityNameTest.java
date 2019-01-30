package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testTools.TestDataLoader;

import java.io.IOException;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

public class CityNameTest {

    private Stack<String> data;
    private boolean setup = false; //workaround for JUnit4 which @Before doesn't work like it does in 5
    private CityName name;


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
        this.name = new CityName(data,3,0.0, new AtomicLong(6556523423L));
    }

    @Test
    public void setSeed() {
        name.setSeed(new AtomicLong(2423523532L));
        Assert.assertEquals(2423523532L, name.getSeed());
    }

    @Test
    public void getName() {
        Assert.assertEquals("dale-gberka-hclig", name.getName());
    }

    @Test
    public void getNames() {
        Assert.assertArrayEquals(new String[]{"dale-gberka-hclig",
                "gberald", "daquiihu"}, name.getNames(3).toArray());
    }
}