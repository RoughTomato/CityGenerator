package citygenerator.markov;

import java.util.*;

public class Model {

    private final int MAX_INT = 2147483647;

    private int order;
    private float prior;
    private String context;
    private ArrayList<String> alphabet;
    private Stack<String> data;
    private Map<String, ArrayList<String>> observations;
    private Map<String, ArrayList<Float>> chains;

    public long seed = 0;
    public Random rand = new Random(seed);

    public Model(Stack<String> data, int order, float prior, ArrayList<String> alphabet, String context) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = data;
        this.context = context;
    }

    public Model(String[] data, int order, float prior, ArrayList<String> alphabet, String context) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = convertStringArrayToStack(data);
        this.context = context;
    }

    public Model(Stack<String> data, int order, float prior, ArrayList<String> alphabet) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = data;
    }

    public Model(String[] data, int order, float prior, ArrayList<String> alphabet) {
        this.order = order;
        this.prior = prior;
        this.alphabet = alphabet;
        this.data = convertStringArrayToStack(data);
    }

    public void createModel() {
        observations = new HashMap<>();
        train();
        buildChains();
    }

    public String generate(String context) {
        ArrayList<Float> chain;
        try {
           chain = this.chains.get(context);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
           return null;
        }
            return alphabet.get(selectIndex(chain));
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
            ArrayList<String> value = new ArrayList<>();

            for(int repeat = 0; repeat < this.order; repeat++) {
                sb.insert(0,'#');
            }
            sb.append('#');
            string = sb.toString();

            for(int i = 0; i < string.length()-this.order; i++) {
                String key = string.substring(i, i + this.order);
                try {
                    value = observations.get(key);
                } catch (IndexOutOfBoundsException | NullPointerException e) {
                    observations.replace(key, value);
                } finally {
                    value.add(Character.toString(string.charAt(i + this.order)));
                }
            }
        }
    }

    protected void buildChains() {
        chains = new HashMap<>();
        observations.entrySet().stream().forEach((entry) -> {
            ArrayList<Float> value = new ArrayList<>();
            String context = entry.getKey();
            for(String prediction : alphabet) {
                try {
                    value = chains.get(context);
                }
                catch (IndexOutOfBoundsException | NullPointerException e) {
                    value = new ArrayList<>();
                    chains.replace(context, value);
                }
                finally {
                    value.add(prior + countMatches(observations.get(context), prediction));
                }
            }
        });
    }

    protected int countMatches(ArrayList<String> arr, String v) {
        if (arr == null) {
            return 0;
        }

        int i = 0;
        for (String s : arr) {
            if (s == v) {
                i++;
            }
        }
        return i;
    }

    protected int selectIndex(ArrayList<Float> chain) {
        float accumulator = 0.0f;
        ArrayList<Float> totals = new ArrayList<>();

        for (float weight : chain) {
            accumulator += weight;
            totals.add(accumulator);
        }

        for (int i = 0; i < totals.size(); i++) {
            if (this.rand.nextInt(MAX_INT) < totals.get(i)) {
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
}
