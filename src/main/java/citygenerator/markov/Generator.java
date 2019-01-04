package citygenerator.markov;

import java.util.*;

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

    public void createGenerator() {
        ArrayList<String> letters = new ArrayList<>();
        {
            int count = 0;
            while (( count < data.size() ))
            {
                String word = data.get(count);
                ++count;
                {
                    int wordsCount = 0;
                    while (( wordsCount < word.length() ))
                    {
                        wordsCount++;
                        letters.add(Character.toString(word.charAt(wordsCount)));
                    }
                }
            }

            //remove duplicates
            Set<String> set = new LinkedHashSet<>();
            set.addAll(letters);
            letters.clear();
            letters.addAll(set);
            Collections.sort(letters);

            ArrayList<String> domain = new ArrayList<>();
            domain.addAll(letters);
            domain.add(0, "#");
            models = new ArrayList<>();
            {
                int counter = 0;
                while (( counter < this.order ))
                {
                    counter++;
                    Stack<String> dataCopy = (Stack<String>) data.clone();
                    Model model = new Model(dataCopy , (this.order - counter), this.prior, domain);
                    model.createModel();
                    models.add(model);
                }
            }
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
        context = context.substring(context.length() - order, context.length());
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
