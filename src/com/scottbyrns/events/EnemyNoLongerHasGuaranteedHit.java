package com.scottbyrns.events;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.target.SimpleTarget;
import com.scottbyrns.target.Target;
import robocode.Condition;

import java.util.Iterator;

/**
 * Detect when an enemy no longer has a guaranteed shot.
 *
 * @author scott
 */
public class EnemyNoLongerHasGuaranteedHit extends Condition {

    private ScottsRobots robot;

    public EnemyNoLongerHasGuaranteedHit(ScottsRobots robot) {
        this.robot = robot;
    }

    public boolean test() {
        if (null == robot.getTargetWithGuaranteedHit()) {
            return false;
        }
        else if (((SimpleTarget)robot.getTargetWithGuaranteedHit()).getMinimumTimeForBulletToTravelFromProjectedRangeOfLocationsTo(robot.getLocation()) >= robot.getWidth()) {
            robot.onEnemyNoLongerHasGuaranteedHit(robot.getTargetWithGuaranteedHit());
            robot.setTargetWithGuaranteedHit(null);
            return true;
        }
        return false;

    }

}