package com.scottbyrns.strategies.driving;

import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;

/**
 * Factory for creating driving strategies.
 *
 * @author scott
 */
public class DrivingStrategyFactory {

    /**
     * Create a new driving strategy for a requested DrivingStrategies type.
     * 
     * @param drivingStrategies
     * @return
     */
    public static BaseStrategy createDrivingStrategyFor (DrivingStrategies drivingStrategies) {
        Console.log("Producing driving strategy.");
        BaseStrategy strategy = null;
        if (drivingStrategies == DrivingStrategies.CRAZY) {
            strategy = new Crazy();
        }
        else if (drivingStrategies == DrivingStrategies.SITTING_DUCK) {
            strategy = new SittingDuck();
        }
        else if (drivingStrategies == DrivingStrategies.FOLLOWER) {
            strategy = new Follower();
        }
        else if (drivingStrategies == DrivingStrategies.FOLLOW_BORDER) {
            strategy = new FollowBorder();
        }
        else if (drivingStrategies == DrivingStrategies.AVOID_TARGET) {
            strategy = new AvoidTarget();
        }

        return strategy;
    }

}
