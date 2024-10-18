package exercise;

// BEGIN
public class Cottage implements Home {

    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return String.format("%d этажный коттедж площадью %.1f метров", getFloorCount(), getArea());
    }

    public int getFloorCount() {
        return floorCount;
    }
}
// END
