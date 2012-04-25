package com.scottbyrns.target;

import com.scottbyrns.Global;
import com.scottbyrns.geometry.Calculations;
import com.scottbyrns.target.statistics.Distance;
import com.scottbyrns.target.statistics.Heading;
import com.scottbyrns.target.statistics.Historical;
import com.scottbyrns.target.statistics.Velocity;
import com.scottbyrns.geometry.primatives.Location;

/**
 * Created: Dec 11, 2010
 *
 * @author scott
 */
public class Bullet extends Historical {

    private Velocity velocity;
    private Heading heading;
    private double power;
    private Location origin;

    private Target shooter;

    /**
     * Get the velocity of the bullet.
     *
     * @return The velocity of the bullet.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * Set the velocity of the bullet.
     *
     * @param velocity The velocity of the bullet.
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * Get the heading of the bullet.
     *
     * @return The heading of the bullet.
     */
    public Heading getHeading() {
        return heading;
    }

    /**
     * Set the heading of the bullet.
     *
     * @param heading The heading of the bullet.
     */
    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    /**
     * Get the power of the bullet.
     *
     * @return The power of the bullet.
     */
    public double getPower() {
        return power;
    }

    /**
     * Set the power of the bullet.
     * 
     * @param power The power of the bullet.
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Get the origin of the bullet.
     *
     * @return The origin of the bullet.
     */
    public Location getOrigin() {
        return origin;
    }

    /**
     * Set the origin of the bullet.
     *
     * @param origin The origin of the bullet.
     */
    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    /**
     * Get the target that fired the shot.
     *
     * @return The target that fired the shot.
     */
    public Target getShooter() {
        return shooter;
    }

    /**
     * Set the target that fired the shot.
     *
     * @param shooter The target that fired the shot.
     */
    public void setShooter(Target shooter) {
        this.shooter = shooter;
    }

    /**
     * Get the projected location of the bullet.
     *
     * @return The projected location of the bullet.
     */
    public Location getProjectedLocation () {
       Location location = new Location();

        location.setX(
            getOrigin().getX() + (
                getVelocity().getMaximumTravelDistanceSinceTheVelocityWasRecorded() * Math.sin(Calculations.degreesToRadians((getHeading().getRawData())))
            )
        );
        location.setY(
            getOrigin().getY() + (
                getVelocity().getMaximumTravelDistanceSinceTheVelocityWasRecorded() * Math.cos(Calculations.degreesToRadians(getHeading().getRawData()))
            )
        );

        return location;
    }


    /**
     * Get the projected location of the bullet after a given amount of time
     * along a precieved heading from a custom location.
     *
     * @return The projected location of the bullet.
     */
    public Location getProjectedLocationForTimeFrame (int timeFrame, double toHeading, Location origin) {
       Location location = new Location();

        location.setX(
            origin.getX() + (
                getVelocity().getRawData() * timeFrame * Math.sin(Calculations.degreesToRadians(toHeading))
            )
        );
        location.setY(
            origin.getY() + (
                getVelocity().getRawData() * timeFrame * Math.cos(Calculations.degreesToRadians(toHeading))
            )
        );

        return location;
    }

    /**
     * Get the projected location of the bullet after a given amount of time along a precieved heading.
     *
     * @return The projected location of the bullet.
     */
    public Location getProjectedLocationForTimeFrame (int timeFrame, double toHeading) {
       return getProjectedLocationForTimeFrame(timeFrame, toHeading, getOrigin());
    }

    /**
     * Get the projected location of the bullet after a given amount of time along.
     *
     * @return The projected location of the bullet.
     */
    public Location getProjectedLocationForTimeFrame (int timeFrame) {
        return getProjectedLocationForTimeFrame(timeFrame, getHeading().getRawData(), getOrigin());
    }

//      public static Point2D.Double project(Point2D.Double sourceLocation,
//        double angle, double length) {
//        return new Point2D.Double(sourceLocation.x + Math.sin(angle) * length,
//            sourceLocation.y + Math.cos(angle) * length);

    public boolean hasPassed (Location location) {
        if (Math.abs(Calculations.distanceBetweenLocations(getProjectedLocation(), getOrigin())) >= Math.abs(Calculations.distanceBetweenLocations(getOrigin(), location))) {
            return true;
        }
        else {
            return false;
        }
    }

}
