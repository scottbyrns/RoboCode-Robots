package com.scottbyrns.strategies.threat;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.strategies.shooting.ShootingStrategies;
import com.scottbyrns.target.Console;

/**
 * Factory to great threat strategies.
 *
 * @author scott
 */
public class ThreatStrategyFactory {

    public static BaseStrategy createThreatStrategyFor (ThreatStrategies threatStrategies) {
        Console.log("Producing threat strategy.");
        BaseStrategy strategy = null;
        if (threatStrategies == ThreatStrategies.NEAREST_TARGET) {
            strategy = new NearestTarget();
        }
        else if (threatStrategies == ThreatStrategies.WEAKEST_TARGET) {
            strategy = new WeakestTarget();
        }

        return strategy;
    }
}
