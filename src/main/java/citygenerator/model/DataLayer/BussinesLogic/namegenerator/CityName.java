package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import java.util.List;

public class CityName implements NameGenerator {

    private Long seed = 0L;

    public CityName(Long seed) {
        this.seed = seed;
    }

    @Override
    public void setSeed(Long seed) {
        this.seed = seed;
    }

    @Override
    public Long getSeed() {
        return seed;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getNames(Integer count) {
        return null;
    }
}
