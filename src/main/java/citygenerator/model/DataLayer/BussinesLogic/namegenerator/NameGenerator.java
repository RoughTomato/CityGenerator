package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface NameGenerator {

    void setSeed(AtomicLong seed);
    AtomicLong getSeed();
    String getName();
    List<String> getNames(Integer count);

}
