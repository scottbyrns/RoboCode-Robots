package com.scottbyrns.events;

import com.scottbyrns.ScottsRobots;
import robocode.Condition;

/**
 * Detect when energy levels are back in normal range.
 *
 * @author scott
 */
public class EnergyReturningToNormal extends Condition {

    private ScottsRobots robot;

    public EnergyReturningToNormal(ScottsRobots robot) {
        this.robot = robot;
    }

    @Override
    public boolean test() {
        if (!robot.weAreInALowEnergyState()) {
            return false;
        }
        else {
            if (this.robot.getEnergy() >= robot.getLowEnergyThreshold()) {
                robot.setLowEnergyState(false);
                robot.onNormalEnergy();
                return true;
            }
            else {
                return false;
            }
        }
    }

}
