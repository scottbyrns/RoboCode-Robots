package com.scottbyrns.target.statistics;

import com.scottbyrns.Global;

import java.util.Date;

/**
 * Velocity of a target.
 *
 * @author scott
 */
public class Velocity extends RawRobotStatistic {


    public Velocity(double rawVelocity) {
        setRawData(rawVelocity);
        setTimeRecorded(Global.getCurrentEpoch());
    }

    /**
     * Get the distance an object with this velocity may have traveled
     * in the specified timeFrame.
     *
     * @param timeFrame Frame of time to calculate distance with.
     * @return Distance traveled in the specified timeFrame.
     */
    public double getDistanceTraveledInTimeFrame(double timeFrame) {
        return timeFrame * getRawData();
    }

    /**
     * Get the maximum travel distance since the velocity was recorded.
     *
     * @return Maximum travel distance since the velocity was recorded.
     */
    public double getMaximumTravelDistanceSinceTheVelocityWasRecorded () {
        /**
         * TODOCan we make this more detailed? 1 tick is a long period of time.
         */
        return (Global.getCurrentEpoch() - getTimeRecorded()) * getRawData();
    }


}
