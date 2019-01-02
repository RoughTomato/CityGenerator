package citygenerator.markov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import citygenerator.markov.Model;

public class Generator {

    private int order;
    private float prior;
    private Stack<String> data;
    /* TODO
        make class models that handles model list related behaviors
     */
    private ArrayList<Model> models;

    public Generator(int order, float prior, Stack<String> data) {
        this.order = order;
        this.prior = prior;
        this.data = data;
    }

    public void createGenerator() {
        ArrayList<Character> letter = new ArrayList<>();
        for(String word : data) {
            for(int i = 0; i < word.length(); i++) {
                letter.add(word.charAt(i));
            }
        }
        Collections.sort(letter);
        ArrayList<String> domain = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : letter) {
            sb.append(c);
        }
        domain.add(sb.toString());
        domain.add(0,"#");

        models = new ArrayList<>();
        for(int i = 0; i < this.order; i++) {
            models.add(new Model(this.data, (this.order - 1), this.prior, domain));
        }
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        String word = "";
        Character letter;
        for(int i = 0; i < order; i++) {
            sb.append("#");
        }
        word = sb.toString();
        letter = getLetter(word);
        while(letter != '#') {
            if(letter != null) {
                word += letter;
            }
            letter = getLetter(word);
        }
        return word;
    }

    public Character getLetter(String context) {
        String letter = null;
        String subcontext = context.substring(context.length() - order, context.length());
        for (Model model : models) {
            letter = model.generate(context);
            if(letter == null){
                context = context.substring(1);
            }
            else {
                break;
            }
        }
        return letter.charAt(0);
    }
}
