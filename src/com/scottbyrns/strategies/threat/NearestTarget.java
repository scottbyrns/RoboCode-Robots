package com.scottbyrns.strategies.threat;

import com.scottbyrns.Global;
import com.scottbyrns.ScottsRobots;
import com.scottbyrns.geometry.Calculations;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;
import com.scottbyrns.target.Target;
import com.scottbyrns.target.exceptions.UnknownEnergy;

import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.target.exceptions.UnknownLocation;

import java.util.Iterator;
import java.util.Map;

/**
 * Created: Dec 12, 2010
 *
 * @author scott
 */
public class NearestTarget extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {

        Console.log("Finding nearest target.");

        Location location = robot.getLocation();

        Target nearestTarget = null;
        double nearestDistance = Double.MAX_VALUE;

        Target target;


        Iterator<Map.Entry<String,Target>> targetEntryIterator = robot.getTargetMap().getEntrySetIterator();

        while (targetEntryIterator.hasNext()) {
            target = targetEntryIterator.next().getValue();

            try {
                if (Calculations.distanceBetweenLocations(target.getTargetLocation(), location) < nearestDistance) {
                    nearestDistance = Calculations.distanceBetweenLocations(target.getTargetLocation(), location);
                    nearestTarget = target;
                }
            }
            catch (Throwable e) {
                e.printStackTrace();
            }

        }

        robot.setPrimaryThreat(nearestTarget);
    }
}
