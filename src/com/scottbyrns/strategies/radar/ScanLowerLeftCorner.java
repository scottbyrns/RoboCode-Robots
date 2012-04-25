package com.scottbyrns.strategies.radar;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.strategies.BaseStrategy;

/**
 * This is a calibration strategy that will aim the radar to the lower left hand corner of the screen.
 *
 * @author scott
 */
public class ScanLowerLeftCorner extends BaseStrategy {

    private Location lowerLeftCorner = new Location(0, 0);

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        robot.aimRadarAt(lowerLeftCorner);
    }
}
