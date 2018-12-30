package citygenerator.markov;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarkovChainTest extends MarkovChain {

    @Test
    public void generateTest() {
        Assert.assertEquals(super.generate(), null);
    }

    @Test
    public void ngramsTest() {
        Assert.assertEquals(super.ngrams(), null);
    }

    @Test
    public void buildTreeTest() {
        Assert.assertEquals(super.buildTree(), null);
    }
}