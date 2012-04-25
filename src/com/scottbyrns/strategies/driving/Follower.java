package com.scottbyrns.strategies.driving;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.SimpleTarget;

/**
 * Created: Dec 12, 2010
 *
 * @author scott
 */
public class Follower extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
            try {
                robot.driveTo(((SimpleTarget)robot.getPrimaryThreat()).projectLocationInTimeFrame(20));
            }
            catch (Throwable e) {
                /* Mucking null */
            }
    }
}
