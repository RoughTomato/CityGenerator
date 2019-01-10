package citygenerator.model.DataLayer.BussinesLogic.markov;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class MarkovChain {

    private int order = 8;
    private double prior = 0.3f;
    private Stack<String> data;

    private Generator generator;

    public MarkovChain(Stack<String> data, int order, double prior, AtomicLong seed) {
        this.data = data;
        this.order = order;
        this.prior = prior;
        generator = new Generator(order, prior, data, seed);
        generator.createGenerator();
    }

    public MarkovChain(ArrayList<String> data, int order, double prior, AtomicLong seed) {
        this.data = new Stack<>();
        this.data.addAll(data);
        this.order = order;
        this.prior = prior;
        generator = new Generator(this.order, this.prior, this.data, seed);
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
