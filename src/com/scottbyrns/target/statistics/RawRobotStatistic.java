package com.scottbyrns.target.statistics;

/**
 * Abstraction of raw statistical data.
 *
 * @author scott
 */
public abstract class RawRobotStatistic extends Historical {

    private double rawData;

    /**
     * Get the raw statistical data
     *
     * @return Raw Statistical Data
     */
    public double getRawData() {
        return rawData;
    }

    /**
     * Set the raw statistical data
     *
     * @param rawData Raw Statistical Data
     */
    public void setRawData(double rawData) {
        this.rawData = rawData;
    }

}
