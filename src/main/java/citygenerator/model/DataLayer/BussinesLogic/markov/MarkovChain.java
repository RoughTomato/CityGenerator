package citygenerator.model.DataLayer.BussinesLogic.markov;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class MarkovChain {

    private AtomicLong seed;
    private int order;
    private double prior;
    private Stack<String> data;

    private Generator generator;

    public MarkovChain(Stack<String> data, int order, double prior, AtomicLong seed) {
        this.data = data;
        this.order = order;
        this.prior = prior;
        this.seed = seed;
        generator = new Generator(this.order, this.prior, this.data, this.seed);
        generator.createGenerator();
    }

    public MarkovChain(ArrayList<String> data, int order, double prior, AtomicLong seed) {
        this.data = new Stack<>();
        this.data.addAll(data);
        this.order = order;
        this.prior = prior;
        this.seed = seed;
        generator = new Generator(this.order, this.prior, this.data, this.seed);
        generator.createGenerator();
    }

    public String generateName() {
        String name = generator.generate();
        name = name.replaceAll("#","");
        return name;
    }

    public List<String> generateNames() {
        throw new NotImplementedException();
    }






}
