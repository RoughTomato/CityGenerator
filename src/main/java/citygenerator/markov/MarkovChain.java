package citygenerator.markov;

import java.util.ArrayList;
import java.util.Stack;

public class MarkovChain {

    private int order = 8;
    private float prior = 0.3f;
    private Stack<String> data;

    private Generator generator;

    public MarkovChain(Stack<String> data, int order, float prior) {
        this.data = data;
        this.order = order;
        this.prior = prior;
        generator = new Generator(order, prior, data);
        generator.createGenerator();
    }

    public MarkovChain(ArrayList<String> data, int order, float prior) {
        this.data = new Stack<>();
        this.data.addAll(data);
        this.order = order;
        this.prior = prior;
        generator = new Generator(this.order, this.prior, this.data);
        generator.createGenerator();
    }

    public String generateName() {
        String name = generator.generate();
        name = name.replaceAll("#","");
        return name;
    }






}
