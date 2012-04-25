package com.scottbyrns.strategies.radar;

import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.strategies.driving.Crazy;
import com.scottbyrns.strategies.driving.DrivingStrategies;
import com.scottbyrns.target.Console;

/**
 * Factory for creating radar strategies.
 *
 * @author scott
 */
public class RadarStrategyFactory {

    public static BaseStrategy createRadarStrategyFor (RadarStrategies radarStrategies) {
        Console.log("Producing radar strategy.");
        BaseStrategy strategy = null;
        if (radarStrategies == RadarStrategies.CONSTANT_SCAN) {
            strategy = new ConstantScan();
        }
        else if (radarStrategies == RadarStrategies.TRACK_TARGET) {
            strategy = new TrackTarget();
        }
        else if (radarStrategies == RadarStrategies.SCAN_LOWER_LEFT_CORNER) {
            strategy = new ScanLowerLeftCorner();
        }

        return strategy;
    }

}
