package com.scottbyrns.target;

import com.scottbyrns.target.statistics.*;

/**
 * Manage the creation of targets.
 *
 * @version 1.0
 */
public class TargetFactory {

    /**
     * Create a new target from a scanned robot event.
     *
     * @param targetedRobot Targeted Robot
     * @return New target created from a scanned robot event.
     */
    public static Target createTarget (TargetedRobot targetedRobot) {
        Target target = new SimpleTarget();
        hydrateTargetFromTargetedRobot(targetedRobot, target);
        
        return target;
    }

    public static void hydrateTargetFromTargetedRobot(TargetedRobot targetedRobot, Target target) {

        target.setTargetName(targetedRobot.getName());

        target.setTargetEnergy(new Energy(targetedRobot.getEnergy()));
        target.setTargetBearing(new Bearing(targetedRobot.getBearing()));
        target.setTargetHeading(new Heading(targetedRobot.getHeading()));
        target.setTargetVelocity(new Velocity(targetedRobot.getVelocity()));
        target.setTargetLocation(targetedRobot.getLocation());
        target.setTargetDistance(new Distance(targetedRobot.getDistance()));
        
    }

}
