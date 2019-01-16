package citygenerator.model.DataLayer.BussinesLogic.markov;

import citygenerator.util.ListTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class Generator {

    private int order;
    private double prior;
    private Stack<String> data;
    /* TODO
        make class models that handles model list related behaviors
     */
    private ArrayList<Model> models;
    private AtomicLong seed;

    public Generator(int order, double prior, Stack<String> data, AtomicLong seed) {
        this.order = order;
        this.prior = prior;
        this.data = data;
        this.seed = seed;
    }

    public void createGenerator() {
        ArrayList<String> letters = generateLetters();
        this.models = generateModels(letters);
    }

    private ArrayList<String> generateLetters() {
        ArrayList<String> letters = new ArrayList<>();
        int dataCount = 0;
        while (dataCount < data.size())
        {
            String word = data.get(dataCount);
            ++dataCount;
            for (char c : word.toCharArray()){
                letters.add(Character.toString(c));
            }
        }
        List<String> tmpList = ListTools.removeDuplicates(letters);
        letters.clear();
        letters.addAll(tmpList);
        Collections.sort(letters);
        return letters;
    }

    private ArrayList<Model> generateModels(ArrayList<String> letters) {
        ArrayList<Model> modelList;
        ArrayList<String> domain = new ArrayList<>();
        domain.addAll(letters);
        domain.add(0, "#");
        modelList = new ArrayList<>();
        int cnt = 0;
        while (cnt < this.order) {
            int position = cnt++;
            Stack<String> dataCopy = (Stack<String>) data.clone();
            Model model = new Model(dataCopy , (this.order - position), this.prior, domain, seed);
            model.createModel();
            modelList.add(model);
        }
        return modelList;
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        String word = "";
        Character letter;
        for (int i = 0; i < order; i++) {
            sb.append("#");
        }
        word = sb.toString();
        letter = getLetter(word);
        while (letter != '#') {
            if(letter != null) {
                word += letter;
            }
            letter = getLetter(word);
        }
        return word;
    }

    public Character getLetter(String context) {
        String letter = null;
        context = context.substring(context.length() - order, context.length());
        for (Model model : this.models) {
            letter = model.generate(context);
            if (letter == null){
                context = context.substring(1);
            }
            else {
                break;
            }
        }
        if(letter == null) {
            throw new NullPointerException("[Generator:Letter:getLetter] letter is null.");
        }
        else {
            return letter.charAt(0);
        }
    }
}
