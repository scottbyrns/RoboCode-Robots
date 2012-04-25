package com.scottbyrns.geometry.primatives;

import java.io.Serializable;

/**
 * Implementation of a Point as a location.
 *
 * @author Scott Byrns
 * @version 1.0
 */
public class Location extends Point implements Serializable {

    private static final long serialVersionUID = 7526472295622776148L;

    /**
     * Create a new Point
     */
    public Location () {
        super(0, 0, 0, 0);
    }

    /**
     * Create a new Location that is a copy of another point
     *
     * @param point to copy
     */
    public Location (Point point) {
        super(point.getX(), point.getY(), point.getZ(), point.getT());
    }

    /**
     * Create a new Location at x coordinates specified
     *
     * @param x x location
     */
    public Location (double x) {
        super(x, 0, 0, 0);
    }

    /**
     * Create a new Location at x and y coordinates specified
     *
     * @param x x location
     * @param y y location
     */
    public Location (double x, double y) {
        super(x, y, 0, 0);
    }

    /**
     * Create a new Location at x, y, and z coordinates specified
     *
     * @param x x location
     * @param y y location
     * @param z z location
     */
    public Location (double x, double y, double z) {
        super(x, y, z, 0);
    }

    /**
     * Create a new Location at x, y, z, and time coordinates specified
     *
     * @param x x location
     * @param y y location
     * @param z z location
     * @param t Time location
     */
    public Location (double x, double y, double z, double t) {
        super(x, y, z, t);
    }

    /**
     * Set the Location of this Location to the Location of the provided Location
     *
     * @param location Location to update the Location of this Location with.
     */
    public void setLocation (Location location) {
        this.setX(location.getX());
        this.setY(location.getY());
        this.setZ(location.getZ());
        this.setT(location.getT());
    }

    /**
     * Get the Location of this Location
     *
     * @return Location of this Location
     */
    public Location getLocation () {
        return this;
    }

}
