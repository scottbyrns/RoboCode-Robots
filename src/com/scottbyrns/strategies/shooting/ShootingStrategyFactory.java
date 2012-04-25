package com.scottbyrns.strategies.shooting;

import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;

/**
 * Factory to create shooting strategies.
 *
 * @author scott
 */
public class ShootingStrategyFactory {

    public static BaseStrategy createShootingStrategyFor (ShootingStrategies shootingStrategies) {
        Console.log("Producing shooting strategy.");
        BaseStrategy strategy = null;
        if (shootingStrategies == ShootingStrategies.SIMPLE) {
            strategy = new Simple();
        }
        else if (shootingStrategies == ShootingStrategies.TARGET_LOWER_LEFT_CORNER) {
            strategy = new TargetUpperLeftCorner();
        }
        else if (shootingStrategies == ShootingStrategies.CLOSE_RANGE_PREDICTIVE) {
            strategy = new CloseRangePredictive();
        }

        return strategy;
    }

}
