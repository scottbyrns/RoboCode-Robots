package com.scottbyrns.strategies.driving;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.geometry.Calculations;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.SimpleTarget;

import com.scottbyrns.geometry.primatives.Location;

/**
 * Avoid the primary target.
 *
 * @author scott
 */
public class AvoidTarget extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
            try {

                Location myLocation = robot.getLocation();
                Location targetLocation = ((SimpleTarget)robot.getPrimaryThreat()).projectLocationInTimeFrame(20);

                double distanceBetweenLocation = Calculations.distanceBetweenLocations(myLocation, targetLocation);

                double bearing = Calculations.getAngleBetweenTwoPoints(myLocation, targetLocation);

                robot.driveTo(Calculations.getLocationOfPolarCoordinates(myLocation, distanceBetweenLocation, bearing));
            }
            catch (Throwable e) {
                /* Mucking null */
            }
    }
}