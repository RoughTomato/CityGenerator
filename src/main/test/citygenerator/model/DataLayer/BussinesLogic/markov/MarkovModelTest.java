package citygenerator.model.DataLayer.BussinesLogic.markov;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class MarkovModelTest extends Model {

    Model model;

    private int order;
    private double prior;
    private AtomicLong seed;
    private ArrayList<String> alphabet;
    private Stack<String> data;

    @Before
    public void setUp() throws Exception {
        this.order = 8;
        this.prior = 0;
        this.alphabet = new ArrayList<>();
        this.data = new Stack<>();
        this.seed = new AtomicLong(0);
        model = new Model(data, order, prior, alphabet, seed);
    }

    @Test
    public void generate() {
        String[] arr = {"TEST","DATA","TESTING","WORDS" };
        String[] letters = {"A",  "B",  "D",  "T",  "S",  "R"};
        this.prior = 0.3;
        this.data.addAll(Arrays.asList(arr));
        this.alphabet.addAll(Arrays.asList(letters));
        String context = "####TEST";

        model.createModel();
        Assert.assertEquals("A", model.generate(context));
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
        ArrayList<Double> chain = new ArrayList<>();
        chain.add(0.2);
        chain.add(0.8);
        chain.add(0.1);
        model.setSeed(12345);
        Assert.assertEquals(1, model.selectIndex(chain));
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