package com.scottbyrns.geometry;

import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.geometry.primatives.Point;
import com.scottbyrns.target.Console;

/**
 * Created: Dec 11, 2010
 *
 * @author scott
 */
public class Calculations {

    /**
     * Convert degrees to radians
     * 
     * @param degrees
     * @return
     */
    public static double degreesToRadians (double degrees) {
        return degrees * Math.PI / 180;
    }

    /**
     * Convert radians to degrees
     * 
     * @param radians
     * @return
     */
    public static double radiansToDegrees (double radians) {
        return (radians * 180) / Math.PI;
    }

    /**
     * Get the distance between two locations
     *
     * @param left
     * @param right
     * @return
     */
    public static double distanceBetweenLocations (Location left, Location right) {
        return Math.sqrt(
                Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2)
        );
    }

    /**
     * Get the angle between two points
     *
     * @param pointOne
     * @param pointTwo
     * @return
     */
    public static double getAngleBetweenTwoPoints (Point pointOne, Point pointTwo) {
		double dx, dy;
        dx = pointTwo.getX() - pointOne.getX();
        dy = pointTwo.getY() - pointOne.getY();
        
        return radiansToDegrees(Math.atan2(dx, dy));
    }

    public static Location getLocationOfPolarCoordinates (Location origin, double magnitude, double theta) {
        Location projectedLocation = new Location();

        projectedLocation.setX(
                origin.getX() + (magnitude * Math.sin(theta))
        );

        projectedLocation.setY(
                origin.getY() + (magnitude * Math.cos(theta))
        );

        return projectedLocation;
    }
}
