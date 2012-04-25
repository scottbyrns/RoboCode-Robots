package com.scottbyrns.target.statistics;

import com.scottbyrns.Global;

import java.util.Date;

/**
 * Created: Dec 10, 2010
 *
 * @author scott
 */
public class Energy extends RawRobotStatistic {
    public Energy(double energy) {
        setRawData(energy);
        setTimeRecorded(Global.getCurrentEpoch());
    }
}
