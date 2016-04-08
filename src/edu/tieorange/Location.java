package edu.tieorange;

/**
 * Created by tieorange on 07/04/16.
 */
public class Location {
    private int x;
    private int y;
    private int z;

    public Location(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Location(Location location) {
        setX(location.getX());
        setY(location.getY());
        setZ(location.getZ());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x <= 0)
            throw new IllegalArgumentException("has to be positive");
        else
            this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y <= 0)
            throw new IllegalArgumentException("has to be positive");
        else
            this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        if (z <= 0)
            throw new IllegalArgumentException("has to be positive");
        else
            this.z = z;
    }
}
