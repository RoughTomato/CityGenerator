package citygenerator.markov;

import java.util.*;
import java.util.stream.Collectors;

public class Generator {

    private int order;
    private float prior;
    private Stack<String> data;
    /* TODO
        make class models that handles model list related behaviors
     */
    private ArrayList<Model> models;

    protected Generator() { }

    public Generator(int order, float prior, Stack<String> data) {
        this.order = order;
        this.prior = prior;
        this.data = data;
    }

    protected static <E> List<E> removeDuplicates(List<E> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public void createGenerator() {
        ArrayList<String> letters = new ArrayList<>();
        int dataCount = 0;
        while (dataCount < data.size())
        {
            String word = data.get(dataCount);
            ++dataCount;
            for (Character c : word.toCharArray()){
                letters.add(c.toString());

            }
        }

        letters = (ArrayList<String>) removeDuplicates(letters);
        Collections.sort(letters);

        ArrayList<String> domain = new ArrayList<>();
        domain.addAll(letters);
        domain.add(0, "#");
        models = new ArrayList<>();
        int cnt = 0;
        while (cnt < this.order) {
            int i1 = cnt++;
            Stack<String> dataCopy = (Stack<String>) data.clone();
            Model model = new Model(dataCopy , (this.order - i1), this.prior, domain);
            model.createModel();
            models.add(model);
        }
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
        for (Model model : models) {
            letter = model.generate(context);
            if (letter == null){
                context = context.substring(1);
            }
            else {
                break;
            }
        }
        return letter.charAt(0);
    }
}
