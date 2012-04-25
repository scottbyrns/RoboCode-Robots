package com.scottbyrns.target.statistics;

import com.scottbyrns.Global;

import java.util.Date;

/**
 * Target Heading
 *
 * @author scott
 */
public class Heading extends RawRobotStatistic {

    public Heading(double rawHeading) {
        setRawData(rawHeading);
        setTimeRecorded(Global.getCurrentEpoch());
    }

}
