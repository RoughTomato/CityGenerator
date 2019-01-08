package citygenerator.model.DataLayer.BussinesLogic.namegenerator;

import java.util.List;

public interface NameGenerator {

    void setSeed(Long seed);
    Long getSeed();
    String getName();
    List<String> getNames(Integer count);
}
