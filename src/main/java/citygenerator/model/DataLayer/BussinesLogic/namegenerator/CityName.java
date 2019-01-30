package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import citygenerator.model.DataLayer.BussinesLogic.markov.MarkovChain;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class CityName implements NameGenerator {

    private AtomicLong seed;
    private Stack<String> data;
    private MarkovChain markov;
    private int order;
    private double prior;

    public CityName(Stack<String> data, int order, double prior, AtomicLong seed) {
        this.seed = seed;
        this.data = data;
        this.order = order;
        this.prior = prior;
        markov = new MarkovChain(this.data, this.order, this.prior, this.seed);
    }

    @Override
    public void setSeed(AtomicLong seed) {
        this.seed = seed;
    }

    @Override
    public AtomicLong getSeed() {
        return seed;
    }

    @Override
    public String getName() {
        return markov.generateName();
    }

    @Override
    public List<String> getNames(Integer count) {
        return markov.generateNames(count);
    }
}
