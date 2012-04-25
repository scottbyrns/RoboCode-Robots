package com.scottbyrns.target.statistics;

import com.scottbyrns.Global;

import java.util.Date;

/**
 * Bearing of the target
 *
 * TODO This needs to corolate its data to where my bot was when this data was recorded
 */
public class Bearing extends RawRobotStatistic {

    /**
     * Create a new Bearing
     *
     * @param rawBearing Initial statistical data.
     */
    public Bearing(double rawBearing) {
        setRawData(rawBearing);
        setTimeRecorded(Global.getCurrentEpoch());
    }

}
