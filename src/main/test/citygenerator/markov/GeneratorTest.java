package citygenerator.markov;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class GeneratorTest extends Generator {

    private int order;
    private float prior;
    private Stack<String> data;

    Generator generator;

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
    public void generateTest() {
        generator.createGenerator();
        generator.generate();
    }

    @Test
    public void getLetterTest() {
        String context = "####TEST";
        generator.createGenerator();
        generator.generate();
        generator.getLetter(context);
    }
}