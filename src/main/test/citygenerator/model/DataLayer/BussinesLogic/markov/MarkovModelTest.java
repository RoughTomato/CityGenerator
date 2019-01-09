package citygenerator.model.DataLayer.BussinesLogic.markov;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.data.push("TEST");
        this.data.push("DATA");
        this.data.push("TESTING");
        this.data.push("WORDS");
        this.prior = 0.3f;
        this.alphabet.add("A");
        this.alphabet.add("B");
        this.alphabet.add("D");
        this.alphabet.add("T");
        this.alphabet.add("S");
        this.alphabet.add("R");
        String context = "####TEST";

        model.createModel();
        Assert.assertEquals("A", model.generate(context));
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
    public void countMatches() {
        String[] arr = { "a", "a", "a", "a", "a", "o" };
        String v = "lorem ipsum o";
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        Assert.assertEquals(1, super.countMatches(list, v));
    }

    @Test
    public void countDoubleOMatches() {
        String[] arr = { "a", "a", "o", "a", "a", "o" };
        String v = "lorem ipsum o";
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        Assert.assertEquals(2, super.countMatches(list, v));
    }

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
    public void convertStringArrayToStackNullTest() {
        String[] arr = { "a", "a", "o", "a", "a", "o" };
        Stack<String> stack = Model.convertStringArrayToStack(arr);
        Assert.assertNotNull(stack);
    }

    @Test
    public void convertStringArrayToStackContentTest() {
        String[] arr = { "a", "a", "o", "a", "a", "o" };
        Stack<String> stack = Model.convertStringArrayToStack(arr);
        for(int i = 0; i < arr.length-1; i++) {
            if(stack.get(i) == null) {
                Assert.fail("Stack have less elements than array.");
            }
        }
    }
}