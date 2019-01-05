package citygenerator.markov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class MarkovChainTest {

    String[] wordlist = {
            "wächtersbach","wörrstadt","wörth","wörth","wülfrath","würselen","würzburg","xanten","zahna","zarrentin"
            ,"zehdenick" ,"zeil" ,"zeitz" ,"zell" ,"zella" ,"zerbst"
            ,"zeulenroda" ,"zeven" ,"ziegenrück" ,"zierenberg" ,"ziesar" ,"zirndorf" ,"zittau" ,"zossen" ,"zschopau"
            ,"zweibrücken" ,"zwenkau" ,"zwickau" ,"zwiesel" ,"zwingenberg" ,"zwönitz" ,"zörbig" ,"zülpich" ,"öhringen"
            ,"östringen" ,"übach" ,"überlingen"
    };

    MarkovChain textGenerator;
    Stack<String> data;

    @Before
    public void setUp() throws Exception {
        this.data = new Stack<>();
        this.data.addAll(Arrays.asList(wordlist));
        textGenerator = new MarkovChain(data, 20, 0.5f);
    }

    @Test
    public void generateTest() {
        String s = textGenerator.generateName();
        Assert.assertEquals("tegiedecfa", s);
    }
}