public class Laptop {
    private int hopDistance;
    private int laptopWirelessNumber;
    private double x;
    private double y;
    private double Radius;

    public Laptop() {
        x = 0;
        y = 0;
        Radius = 0.666;
        laptopWirelessNumber = 0;
        hopDistance = 0;
    }

    public Laptop(double newx, double newy, double newRadius, int newlaptopWirelessNumber, int newHopDistance) {
        hopDistance = newHopDistance;
        laptopWirelessNumber = newlaptopWirelessNumber;
        x = newx;
        y = newy;
        Radius = newRadius;
    }

    public int getHopDistance() {
        return hopDistance;
    }

    public void setHopDistance(int hopDistance) {
        this.hopDistance = hopDistance;
    }

    public int getlaptopWirelessNumber() {
        return laptopWirelessNumber;
    }

    public void setlaptopWirelessNumber(int laptopWirelessNumber) {
        this.laptopWirelessNumber = laptopWirelessNumber;
    }

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double radius) {
        Radius = radius;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
