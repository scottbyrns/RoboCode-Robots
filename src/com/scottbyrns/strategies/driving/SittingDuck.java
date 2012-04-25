package com.scottbyrns.strategies.driving;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;

/**
 * Sit in one place and don't move.
 *
 * @author scott
 */
public class SittingDuck extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        // NOP
    }
}
