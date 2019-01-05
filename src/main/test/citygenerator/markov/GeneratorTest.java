package citygenerator.markov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class GeneratorTest extends Generator {

    private int order;
    private float prior;
    private Stack<String> data;

    Generator generator;

    public GeneratorTest() {
        super(0, 0, new Stack<>());
    }

    @Before
    public void setUp() throws Exception {
        order = 8;
        prior = 0;
        data = new Stack<>();
        this.data.push("TEST");
        this.data.push("DATA");
        this.data.push("TESTING");
        this.data.push("WORDS");
        this.prior = 0.3f;
        generator = new Generator(this.order, this.prior, this.data);
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
        Assert.assertEquals((Character)'A', generator.getLetter(context));
    }
}