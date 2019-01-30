package citygenerator.model.DataLayer.BussinesLogic.mapgenerator;

public enum BuildingTypes {

    ARMORY ("Armory", 0.0, 0.0),
    TAVERN ("Tavern", 0.0, 0.0),
    PUB ("Pub", 0.0, 0.0),
    GROCERY_STORE ("Grocery Store", 0.0, 0.0),
    BARBER ("Barber", 0.0, 0.0),
    CHURCH ( "Church", 0.0, 0.0),
    CITY_HALL ("City Hall", 0.0, 0.0),
    BLACKSMITH ("Blacksmith", 0.0, 0.0),
    HOUSE ( "House", 0.0, 0.0),
    BIG_HOUSE ("Big House", 0.0, 0.0),
    BAKERY ( "Bakery", 0.0, 0.0);

    private final String name;
    private final double maxWidth;
    private final double maxHeight;

    BuildingTypes(String name, double maxWidth, double maxHeight) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return name;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxHeight() {
        return maxHeight;
    }
}
