package com.scottbyrns.geometry.primatives;

import java.io.Serializable;

/**
 * Simple implementation of a Point in space.
 *
 * @author Scott Byrns
 * @version 1.0
 */
public abstract class Point implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    protected double x, y, z, t;

    /**
     * Create a new Point
     */
    public Point () {
        this(0, 0, 0, 0);
    }

    /**
     * Create a new Point that is a copy of another point
     *
     * @param point to copy
     */
    public Point (Point point) {
        this(point.getX(), point.getY(), point.getZ(), point.getT());
    }

    /**
     * Create a new Point at x coordinates specified
     *
     * @param x x location
     */
    public Point (double x) {
        this(x, 0, 0, 0);
    }

    /**
     * Create a new Point at x and y coordinates specified
     *
     * @param x x location
     * @param y y location
     */
    public Point (double x, double y) {
        this(x, y, 0, 0);
    }

    /**
     * Create a new Point at x, y, and z coordinates specified
     *
     * @param x x location
     * @param y y location
     * @param z z location
     */
    public Point (double x, double y, double z) {
        this(x, y, z, 0);
    }

    /**
     * Create a new Point at x, y, z, and time coordinates specified
     *
     * @param x x location
     * @param y y location
     * @param z z location
     * @param t Time location
     */
    public Point (double x, double y, double z, double t) {
        setX(x);
        setY(y);
        setZ(z);
        setT(t);
    }

    /**
     * Get the x coordinate of the point
     *
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Set the x coordinate of the point
     * @param x new x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Get the y coordinate of the point
     *
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Set the y coordinate of the point
     *
     * @param y new y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the z coordinate of the point
     *
     * @return z coordinate
     */
    public double getZ() {
        return z;
    }

    /**
     * Set the z coordinate of the point
     *
     * @param z new z coordinate
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Get the time coordinate of the point
     *
     * @return time coordinate
     */
    public double getT() {
        return t;
    }

    /**
     * Set the time coordinate of the point
     * @param t time coordinate
     */
    public void setT(double t) {
        this.t = t;
    }

}