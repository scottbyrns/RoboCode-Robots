package com.scottbyrns.events;

import com.scottbyrns.ScottsRobots;
import robocode.Condition;

/**
 * Detect when the robot is running low on energy.
 *
 * @author scott
 */
public class RunningLowOnEnergy extends Condition {

    private ScottsRobots robot;

    public RunningLowOnEnergy(ScottsRobots robot) {
        this.robot = robot;
    }

    @Override
    public boolean test() {
        if (robot.weAreInALowEnergyState()) {
            return false;
        }
        else {
            if (this.robot.getEnergy() <= robot.getLowEnergyThreshold()) {
                robot.setLowEnergyState(true);
                robot.onLowEnergy();
                return true;
            }
            else {
                return false;
            }
        }
    }
}
