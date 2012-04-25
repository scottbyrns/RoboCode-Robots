package com.scottbyrns.strategies.driving;

/**
 * Enumeration of available driving strategies.
 *
 * @author scott
 */
public enum DrivingStrategies {

    /**
     * Drives like an idiot.
     */
    CRAZY,

    /**
     * Sits in one place.
     */
    SITTING_DUCK,

    /**
     * Follow the target.
     */
    FOLLOWER,

    /**
     * Follow the border of the field 100 pixels away.
     */
    FOLLOW_BORDER,

    /**
     * Avoid the primary target.
     */
    AVOID_TARGET


}
