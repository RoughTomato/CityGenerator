package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CityName implements NameGenerator {

    private AtomicLong seed;

    public CityName(AtomicLong seed) {
        this.seed = seed;
    }

    @Override
    public void setSeed(AtomicLong seed) {
        this.seed = seed;
    }

    @Override
    public AtomicLong getSeed() {
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
