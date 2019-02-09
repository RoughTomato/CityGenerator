package citygenerator.model.DataLayer.BussinesLogic.mapgenerator;

import citygenerator.model.DataLayer.BussinesLogic.colliders.Corner;
import citygenerator.model.DataLayer.BussinesLogic.colliders.Corners;

public class Building {

    private BuildingTypes builidingType;
    private Corners corners;
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
        convertCoordinatesToCorners();
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

    public Corner getCorner(int index) {
        Corner corner = null;
        if(index < 4){
            corner = (Corner) corners.get(index);
        }
        return corner;
    }

    /**
     * Since assumption is that buildings will ALWAYS be
     * rectangular we can simply calculate corners as follows:
     *
     *  x+1/2h,y-1/2w   x+1/2h,y-1/2w
     *   A *------------* B
     *     |            |
     *     |     *      |
     *     |    (x,y)   |
     *   C *------------* D
     *  x-1/2h,y-1/2w   x-1/2h,y+1/2w
     *
     * */
    private void convertCoordinatesToCorners(){
        corners.add(new Corner( (x+(0.5*h)), (y-(0.5*w)) ));
        corners.add(new Corner( (x+(0.5*h)), (y-(0.5*w)) ));
        corners.add(new Corner( (x-(0.5*h)), (y-(0.5*w)) ));
        corners.add(new Corner( (x-(0.5*h)), (y+(0.5*w)) ));
    }

    @Override
    public String toString() {
        return "Building{" +
                "builidingType=" + builidingType +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", A=" + corners.get(0) +
                ", B=" + corners.get(1) +
                ", C=" + corners.get(2) +
                ", D=" + corners.get(3) +
                '}';
    }
}
