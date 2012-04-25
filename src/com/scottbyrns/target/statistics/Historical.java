package com.scottbyrns.target.statistics;

import java.util.Date;

/**
 * Abstraction of hostirical data associated with Robot statistics objects.
 *
 * @author scott
 */
public abstract class Historical {

    private int timeRecorded;

    /**
     * Get the time this data was recorded.
     *
     * @return Time this data was recorded.
     */
    public int getTimeRecorded() {
        return timeRecorded;
    }

    /**
     * Set the time this data was recorded.
     *
     * @param timeRecorded Time this data was recorded.
     */
    public void setTimeRecorded(int timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

}
