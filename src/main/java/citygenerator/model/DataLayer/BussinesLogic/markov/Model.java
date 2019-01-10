package citygenerator.model.DataLayer.BussinesLogic.markov;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Model {

    private int order;
    private double prior;
    private ArrayList<String> alphabet;
    private Stack<String> data;
    private Map<String, ArrayList<String>> observations;
    private Map<String, ArrayList<Double>> chains;

    private AtomicLong seed;
    private Random rand = new Random(0);

    protected Model(){ }

    public Model(Stack<String> data, int order, double prior, ArrayList<String> alphabet, AtomicLong seed) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = data;
        this.seed = seed;
        observations = new HashMap<>();
        chains = new HashMap<>();
    }

    public Model(String[] data, int order, double prior, ArrayList<String> alphabet) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = convertStringArrayToStack(data);
        observations = new HashMap<>();
        chains = new HashMap<>();
    }

    public void createModel() {
        observations = new HashMap<>();
        train();
        buildChains();
    }

    public String generate(String context) {
        ArrayList<Double> chain;
        chain = this.chains.get(context);

        if (chain == null) {
            return null;
        }
        else {
            String value = alphabet.get(selectIndex(chain));
            return value;
        }
    }

    public void retrain(Stack<String> data) {
        this.data = data;
        train();
        buildChains();
    }

    public void train() {
        while (data.size() != 0) {
            String string = data.pop();
            StringBuilder sb = new StringBuilder(string);
            ArrayList<String> value;

            String output = "";
            int counter = 0;
            while (counter < this.order) {
                counter++;
                output += "#";
            }
            string = (output + string) + "#";
            for (int i = 0; i < string.length()-this.order; i++) {
                String key = string.substring(i, i + this.order);
                value = observations.get(key);
                if (value == null) {
                    value = new ArrayList<>();
                    observations.put(key, value);
                }
                value.add(Character.toString(string.charAt(i + this.order)));
            }
        }
    }

    private void buildChains() {
        chains = new HashMap<>();
        ArrayList<Double> value;
        for (Map.Entry<String, ArrayList<String>> item : observations.entrySet()) {
            for (String prediction : alphabet) {
                String context = item.getKey();
                value = chains.get(context);
                if (value == null) {
                    value = new ArrayList<>();
                    chains.put(context, value);
                }
                value.add(prior + countMatches(observations.get(context), prediction));
            }
        }
    }

    public int countMatches(ArrayList<String> arr, String v) {
        if (arr == null) {
            return 0;
        }
        int occurrences = 0;
        for (String s : arr) {
            if (StringUtils.countMatches(v, s) > 0){
                occurrences++;
            }
        }
        return occurrences;
    }

    protected int selectIndex(ArrayList<Double> chain) {
        float accumulator = 0.0f;
        ArrayList<Float> totals = new ArrayList<>();

        for (double weight : chain) {
            accumulator += weight;
            totals.add(accumulator);
        }

        for (int i = 0; i < totals.size(); i++) {
            float rand = this.rand.nextFloat() * accumulator;
            float currentTotal = totals.get(i);
            if (rand < currentTotal) {
                return i;
            }
        }

        return 0;
    }

    public static Stack<String> convertStringArrayToStack(String[] string) {
        Stack<String> stack = new Stack<>();
        for (int length = (string.length-1); length != 0; length--) {
            stack.push(string[length]);
        }
        return stack;
    }

    public void setSeed(long seed) {
        this.seed.set(seed);
    }
}
