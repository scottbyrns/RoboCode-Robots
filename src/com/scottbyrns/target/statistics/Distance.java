package com.scottbyrns.target.statistics;

import com.scottbyrns.Global;

import java.util.Date;

/**
 * Distance from scan location to target.
 *
 * @author scott
 */
public class Distance extends RawRobotStatistic {
    private int a = 1;
    public Distance(double rawDistance) {
        setRawData(rawDistance);
        setTimeRecorded(Global.getCurrentEpoch());
    }
}
