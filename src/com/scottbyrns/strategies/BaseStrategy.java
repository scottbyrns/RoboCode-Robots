package com.scottbyrns.strategies;

import com.scottbyrns.ScottsRobots;

/**
 * Created: Dec 11, 2010
 *
 * @author scott
 */
public abstract class BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public abstract void onInitiative (ScottsRobots robot);

}
