package citygenerator.markov;

import java.util.Arrays;

public class MarkovChain {

    private String[] sequences = {};
    private int n = 2;
    private int maxLength = 20;

    public MarkovChain() {}

    public MarkovChain(String[] sequences) {
        this.sequences = Arrays.copyOf(sequences, sequences.length);
    }

    public MarkovChain(String[] sequences, int n, int maxLength) {
        this.sequences = Arrays.copyOf(sequences, sequences.length);
        this.n = n;
        this.maxLength = maxLength;
    }


}
