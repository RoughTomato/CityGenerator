package citygenerator.markov;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Model {

    private int order;
    private float prior;
    private ArrayList<String> alphabet;
    private Stack<String> data;
    private Map<String, ArrayList<String>> observations;
    private Map<String, ArrayList<Float>> chains;

    private long seed = 0;
    private Random rand = new Random(seed);

    protected Model(){ }

    public Model(Stack<String> data, int order, float prior, ArrayList<String> alphabet) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = data;
        observations = new HashMap<>();
        chains = new HashMap<>();
    }

    public Model(String[] data, int order, float prior, ArrayList<String> alphabet) {
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
        ArrayList<Float> chain;
        chain = this.chains.get(context);

        if(chain == null) {
            return null;
        }
        else {
            return alphabet.get(selectIndex(chain));
        }
    }

    public void retrain(Stack<String> data) {
        this.data = data;
        train();
        buildChains();
    }

    public void train() {
        while(data.size() != 0) {
            String string = data.pop();
            StringBuilder sb = new StringBuilder(string);
            ArrayList<String> value;

            for(int repeat = 0; repeat < this.order; repeat++) {
                sb.insert(0,'#');
            }
            sb.append('#');
            string = sb.toString();

            for(int i = 0; i < string.length()-this.order; i++) {
                String key = string.substring(i, i + this.order);
                value = observations.get(key);
                if(value == null) {
                    value = new ArrayList<>();
                    observations.replace(key, value);
                }
                value.add(Character.toString(string.charAt(i + this.order)));
            }
        }
    }

    protected void buildChains() {
        chains = new HashMap<>();
        observations.entrySet().stream().forEach((entry) -> {
            ArrayList<Float> value;
            String context = entry.getKey();
            for(String prediction : alphabet) {
                value = chains.get(context);
                if(value == null) {
                    value = new ArrayList<>();
                    chains.replace(context, value);
                }
                value.add(prior + countMatches(observations.get(context), prediction));
            }
        });
    }

    public int countMatches(ArrayList<String> arr, String v) {
        if (arr == null) {
            return 0;
        }
        int occurrences = 0;
        for(String s : arr) {
            if(StringUtils.countMatches(v, s) > 0){
                occurrences++;
            }
        }
        return occurrences;
    }

    protected int selectIndex(ArrayList<Float> chain) {
        float accumulator = 0.0f;
        ArrayList<Float> totals = new ArrayList<>();

        for (float weight : chain) {
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

    protected Stack<String> convertStringArrayToStack(String[] string) {
        Stack<String> stack = new Stack<>();
        for(int length = string.length; length != 0; length--) {
            stack.push(string[length]);
        }
        return stack;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }
}
