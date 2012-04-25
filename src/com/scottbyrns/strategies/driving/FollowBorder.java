package com.scottbyrns.strategies.driving;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;

import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.target.Console;

/**
 * Drive the border of the field.
 *
 * @author scott
 */
public class FollowBorder extends BaseStrategy {

    private Location topLeft, topRight, bottomRight, bottomLeft;
    private boolean isInit = false;

    private Location target;

    private void init (ScottsRobots robot) {
        Console.log("Init border following robot");
        if (isInit) {
            return;
        }
        isInit = true;

        topLeft = new Location(100, 100);
        topRight = new Location(robot.getBattleFieldWidth() - 100, 100);
        bottomRight = new Location(robot.getBattleFieldWidth() - 100, robot.getBattleFieldHeight() - 100);
        bottomLeft = new Location(100, robot.getBattleFieldHeight() - 100);
    }

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        init(robot);
        if (robot.getDistanceRemaining() == 0.0) {
            if (null == target) {
                target = topLeft;
            }
            else if (locationsMatch(robot.getLocation(), target)) {
                Console.log("WTF");
                if (locationsMatch(target, topLeft)) {
                    target = topRight;
                }
                else if (locationsMatch(target, topRight)) {
                    target = bottomRight;
                }
                else if (locationsMatch(target, bottomRight)) {
                    target = bottomLeft;
                }
                else if (locationsMatch(target, bottomLeft)) {
                    target = topLeft;
                }
            }

            robot.driveTo(target);
        }
    }

    public boolean locationsMatch (Location left, Location right) {
        if (left.getX() - right.getX() < 5 && left.getY() - right.getY() < 5) {
            return true;
        }
        return false;
    }
}
