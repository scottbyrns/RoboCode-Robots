package com.scottbyrns.events;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.target.SimpleTarget;
import com.scottbyrns.target.Target;
import robocode.Condition;

import java.util.Iterator;

/**
 * Detect when an enemy is so close that it has a guaranteed shot.
 *
 * @author scott
 */
public class EnemyHasGuaranteedHit extends Condition {

    private ScottsRobots robot;

    public EnemyHasGuaranteedHit(ScottsRobots robot) {
        this.robot = robot;
    }

    public boolean test() {
        Iterator<Target> targetIterator = robot.getTargetMap().getTargetIterator();
        Target target;
        while (targetIterator.hasNext()) {
            target = targetIterator.next();
            double time = ((SimpleTarget)target).getMinimumTimeForBulletToTravelFromProjectedRangeOfLocationsTo(robot.getLocation());
            if (time < robot.getWidth()) {
                robot.setTargetWithGuaranteedHit(target);
                robot.onEnemyHasGuaranteedHit(target);
                return true;
            }
        }

        return false;

    }

}
