package citygenerator.markov;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class MarkovModelTest extends Model {

    Model model;

    private int order;
    private float prior;
    private ArrayList<String> alphabet;
    private Stack<String> data;


    @Before
    public void setUp() throws Exception {
        order = 8;
        prior = 0;
        alphabet = new ArrayList<>();
        data = new Stack<>();
        model = new Model(data, order, prior, alphabet);
    }

    @Test
    public void createModel() {
        super.createModel();
    }

    @Test
    public void generate() {
    }

    @Test
    public void retrain() {
    }

    @Test
    public void train() {
        this.data.push("TEST");
        this.data.push("DATA");
        this.data.push("TESTING");
        this.data.push("WORDS");
        model.train();
    }

    @Test
    public void buildChains() {
    }

    @Test
    public void countMatches() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("a");
        arr.add("a");
        arr.add("a");
        arr.add("a");
        arr.add("o");
        String v = "lorem ipsum";
        Assert.assertEquals(1, super.countMatches(arr, v));
    }

    @Test
    public void countDoubleOMatches() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("a");
        arr.add("o");
        arr.add("a");
        arr.add("a");
        arr.add("o");
        String v = "lorem ipsum o";
        Assert.assertEquals(2, super.countMatches(arr, v));
    }

    /* I am not 100% sure about whether this method works correctly yet.
    *  This test only proves that it works as intended for this particular case
    *  I'll come back to it while I understand a bit more.*/
    @Test
    public void selectIndex() {
        ArrayList<Float> chain = new ArrayList<>();
        chain.add(0.2f);
        chain.add(0.8f);
        chain.add(0.1f);
        super.setSeed(12345);
        Assert.assertEquals(1, super.selectIndex(chain));
    }

    @Test
    public void convertStringArrayToStack() {

    }
}