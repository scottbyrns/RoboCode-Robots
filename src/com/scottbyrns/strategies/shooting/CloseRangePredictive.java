package com.scottbyrns.strategies.shooting;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.SimpleTarget;

/**
 * Predictive shooting that will only fire at close range.
 *
 * @author scott
 */
public class CloseRangePredictive extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        if (robot.getGunTurnRemaining() == 0.0) {
            try {
                if (robot.getPrimaryThreat().getTargetDistance().getRawData() < 100) {
                    robot.fire(9.0);
                }
                robot.aimGunAt(((SimpleTarget)robot.getPrimaryThreat()).projectLocationInTimeFrame(robot.getPrimaryThreat().getTargetDistance().getRawData() * 0.05));
            }
            catch (Throwable e) {
                /* Mucking null */
            }
        }

    }
}

