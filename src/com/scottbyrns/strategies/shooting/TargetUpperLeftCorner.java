package com.scottbyrns.strategies.shooting;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.geometry.primatives.Location;

/**
 * This is a calibration strategy that will aim the gun to the lower left hand corner of the screen and fire a round.
 * TODO refactor since this aims at the lower left not upper.
 *
 * @author scott
 */
public class TargetUpperLeftCorner extends BaseStrategy {

    private Location upperLeftCorner = new Location(0, 0);

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        robot.aimGunAt(upperLeftCorner);
        robot.fire(0.1);
    }
}
