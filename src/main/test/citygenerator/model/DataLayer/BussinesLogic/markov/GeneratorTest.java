package citygenerator.model.DataLayer.BussinesLogic.markov;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class GeneratorTest extends Generator {

    private int order;
    private float prior;
    private Stack<String> data;
    private AtomicLong seed;
    Generator generator;

    public GeneratorTest() {
        super(0, 0, new Stack<>(), new AtomicLong());
    }

    @Before
    public void setUp() {
        this.data = new Stack<>();
        this.seed = new AtomicLong(0);
        String[] arr = {"TEST","DATA","TESTING","WORDS" };
        this.data.addAll(Arrays.asList(arr));
        this.prior = 0.3f;
        this.order = 8;
        generator = new Generator(this.order, this.prior, this.data, this.seed);
    }

    @Test
    public void createGeneratorTest() {
        generator.createGenerator();
    }

    @Test
    public void getLetterTest() {
        String context = "####TEST";
        generator.createGenerator();
        generator.generate();
        Assert.assertEquals((Character)'G', generator.getLetter(context));
    }
}