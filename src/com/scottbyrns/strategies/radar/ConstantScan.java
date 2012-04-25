package com.scottbyrns.strategies.radar;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;

/**
 * Constantly scan the entire field
 *
 * @author scott
 */
public class ConstantScan extends BaseStrategy {
    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    @Override
    public void onInitiative(ScottsRobots robot) {
        Console.log("I'm see every thing!");
        robot.setTurnRadarRightRadians(Double.MAX_VALUE);
    }
}
