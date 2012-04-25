package com.scottbyrns.strategies.radar;

/**
 * Enumerations of available radar strategies.
 *
 * @author scott
 */
public enum RadarStrategies {

    /**
     * This is a calibration strategy that will aim the radar to the lower left hand corner of the screen.
     */
    SCAN_LOWER_LEFT_CORNER,
    /**
     * Constantly scan the entire field.
     */
    CONSTANT_SCAN,

    /**
     * Lock onto the first target seen and keep tracking them.
     */
    TRACK_TARGET

}
