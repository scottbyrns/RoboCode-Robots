package com.scottbyrns.target;

import com.scottbyrns.geometry.Calculations;
import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;
import com.scottbyrns.geometry.primatives.Location;

/**
 * Wrapper class for ScannedRobotEvent to abstract the low level event data and provide
 * normalized, optimized, and adjusted data.
 *
 * @author scott
 */
public class TargetedRobot {

    private ScannedRobotEvent scannedRobotEvent;
    private Location myRobotsLocations;
    private double myRobotsHeading;

    public TargetedRobot(ScannedRobotEvent scannedRobotEvent, Location myRobotsLocations, double myRobotsHeading) {
        this.scannedRobotEvent = scannedRobotEvent;
        this.myRobotsLocations = myRobotsLocations;
        this.myRobotsHeading = myRobotsHeading;
    }

    /**
     * Squeeze any information we can out of a hit by bullet event.
     * TODO Clean this data up. It is crapy.
     *
     * @param hitByBulletEvent
     * @param myRobotsLocations
     * @param myRobotsHeading
     */
    public TargetedRobot(HitByBulletEvent hitByBulletEvent, Location myRobotsLocations, double myRobotsHeading) {
        this.scannedRobotEvent = new ScannedRobotEvent(
                hitByBulletEvent.getName(),
                /**
                 * Assume that since they have never been seen
                 * before that the game is pretty new and they
                 * are still at their default energy level.
                 */
                100,
                /**
                 * TODO this is wrong, just space holder, calculate real bearing.
                 */
                hitByBulletEvent.getBearing(),
                0,
                0,
                0
        );
        this.myRobotsLocations = myRobotsLocations;
        this.myRobotsHeading = myRobotsHeading;
    }

    /**
     * Get the name of the targeted robot.
     *
     * @return Name of the targeted robot.
     */
    public String getName () {
        return getScannedRobotEvent().getName();
    }

    /**
     * Get the myRobotsHeading of the robot.
     *
     * @return The myRobotsHeading of the robot.
     */
    public double getHeading() {
        return getScannedRobotEvent().getHeading();
    }

    /**
     * Get the bearing of the targeted robot relative to the location it was scanned from.
     *
     * @return Bearing of the targeted robot relative to the location it was scanned from.
     */
    public double getBearing () {
        return getScannedRobotEvent().getBearing();
    }

    /**
     * Get the normalized bearing of the target robot.
     * This does a bearing%90
     *
     * @return Normalized bearing of the target robot.
     */
    public double getNormalizedBearing () {
        return getBearing() % 90;
    }

    /**
     * Get the energy level of the targeted robot.
     *
     * @return The energy level of the targeted robot.
     */
    public double getEnergy () {
        return getScannedRobotEvent().getEnergy();
    }

    /**
     * Get the velocity of the targeted robot.
     *
     * @return The velocity of the targeted robot.
     */
    public double getVelocity () {
        return getScannedRobotEvent().getVelocity();
    }

    /**
     * Get the distance to the targeted robot.
     *
     * @return The distance to the targeted robot.
     */
    public double getDistance () {
        return getScannedRobotEvent().getDistance();
    }

    /**
     * Get the location of the targeted robot.
     *
     * @return The location of the targeted robot.
     */
    public Location getLocation () {

        Location location = new Location();

        location.setX(
            getMyRobotsLocations().getX() + (
                getDistance() * Math.sin(Calculations.degreesToRadians((getBearing() + getMyRobotsHeading())))
            )
        );
        location.setY(
            getMyRobotsLocations().getY() + (
                getDistance() * Math.cos(Calculations.degreesToRadians(getBearing() + getMyRobotsHeading()))
            )
        );

        return location;
    }




    /**
     * Get a reference to the scanned robot.
     *
     * @return reference to the scanned robot.
     */
    private ScannedRobotEvent getScannedRobotEvent() {
        return scannedRobotEvent;
    }

    /**
     * Set a reference to the scanned robot.
     *
     * @param scannedRobotEvent reference to the scanned robot.
     */
    private void setScannedRobotEvent(ScannedRobotEvent scannedRobotEvent) {
        this.scannedRobotEvent = scannedRobotEvent;
    }

    /**
     * Get the location of my robot at the time this target was aquired.
     *
     * @return Location of my robot at the time this target was aquired.
     */
    private Location getMyRobotsLocations() {
        return myRobotsLocations;
    }

    /**
     * Set the location of my robot at the time this target was aquired.
     *
     * @param myRobotsLocations Location of my robot at the time this target was aquired.
     */
    private void setMyRobotsLocations(Location myRobotsLocations) {
        this.myRobotsLocations = myRobotsLocations;
    }

    /**
     * Get the heading of my robot.
     *
     * @return The heading of my robot.
     */
    public double getMyRobotsHeading() {
        return myRobotsHeading;
    }

    /**
     * Set the heading of my robot.
     *
     * @param myRobotsHeading The heading of my robot.
     */
    public void setMyRobotsHeading(double myRobotsHeading) {
        this.myRobotsHeading = myRobotsHeading;
    }
}
