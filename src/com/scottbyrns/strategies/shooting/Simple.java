package com.scottbyrns.strategies.shooting;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.SimpleTarget;

/**
 * Simple predictive shooting.
 *
 * @author scott
 */
public class Simple extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        if (robot.getGunTurnRemaining() == 0.0) {
            try {
                robot.fire(9.0);
                robot.aimGunAt(((SimpleTarget)robot.getPrimaryThreat()).projectLocationInTimeFrame(robot.getPrimaryThreat().getTargetDistance().getRawData() * 0.05));
            }
            catch (Throwable e) {
                /* Mucking null */
            }
        }

    }
}
