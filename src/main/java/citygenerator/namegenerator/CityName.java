package citygenerator.namegenerator;

public class CityName implements NameGenerator {

    private String seed = "0";
    private String[] start = { "An", "Ank", "Arg", "Ba", "Be", "Br", "Bo", "Ca", "Cr", "Cu", "Du"};
    private String[] middle = { "re", "an", "im", "on", "ge", "wan", ""};
    private String[] end = { "a", "g", "ork", "esh", "han", "dom", "ome", "om"};

    public CityName(String seed) {
        this.seed = seed;
    }

    @Override
    public void setSeed(String seed) {
        this.seed = seed;
    }

    @Override
    public String getSeed() {
        return seed;
    }

    @Override
    public String getName() {
        return null;
    }
}
