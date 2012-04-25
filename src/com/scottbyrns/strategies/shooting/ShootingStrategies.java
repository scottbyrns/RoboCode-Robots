package com.scottbyrns.strategies.shooting;

/**
 * Enumeration of shooting strategies.
 *
 * @author scott
 */
public enum ShootingStrategies {

    /**
     * Simple predictive shooting.
     */
    SIMPLE,

    /**
     * Similar to simple predictive shooting but will only fire when the target is in close range.
     */
    CLOSE_RANGE_PREDICTIVE,

    /**
     * Callibration shooting method, will target lower left corner of map.
     */
    TARGET_LOWER_LEFT_CORNER,

    /**
     * Shoot bullets with bullets to defend your self.
     */
    BULLET_SHIELD

}
