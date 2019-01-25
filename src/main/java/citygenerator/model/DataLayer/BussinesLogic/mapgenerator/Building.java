package citygenerator.model.DataLayer.BussinesLogic.mapgenerator;

public class Building {

    private BuildingTypes builidingType;
    private int x;
    private int y;
    private int w;
    private int h;

    public Building(BuildingTypes buildingType, int x, int y, int w, int h) {
        this.builidingType = buildingType;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public BuildingTypes getBuilidingType() {
        return builidingType;
    }

    public void setBuilidingType(BuildingTypes builidingType) {
        this.builidingType = builidingType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "Building{" +
                "builidingType=" + builidingType +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
