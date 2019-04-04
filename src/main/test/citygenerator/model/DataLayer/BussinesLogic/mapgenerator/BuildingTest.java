package citygenerator.model.DataLayer.BussinesLogic.mapgenerator;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTest {

    @Test
    public void cornersTest() {
        Building b = new Building(BuildingTypes.BARBER, 10,10,10,10);

        System.err.println(b.toString());
    }
}