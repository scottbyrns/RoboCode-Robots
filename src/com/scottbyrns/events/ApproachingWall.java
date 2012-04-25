package com.scottbyrns.events;

import com.scottbyrns.ScottsRobots;
import robocode.AdvancedRobot;
import robocode.Condition;
import robocode.CustomEvent;
import com.scottbyrns.geometry.primatives.Location;

/**
 * Detect when the robot is aproaching the wall.
 *
 * @author scott
 */
public class ApproachingWall extends Condition {

    private ScottsRobots robot;
    private Location nearestPointOnWall;

    public ApproachingWall(ScottsRobots robot) {
        this.robot = robot;
    }

    @Override
    public boolean test() {
        Location robotLocation = robot.getLocation();
        if (robotLocation.getX() < 100) {
            setNearestPointOnWall(new Location(0, robotLocation.getY()));
            return true;
        }
        if (robotLocation.getY() < 100) {
            setNearestPointOnWall(new Location(robotLocation.getX(), 0));
            return true;
        }
        if (robotLocation.getX() > robot.getBattleFieldWidth() - 100) {
            setNearestPointOnWall(new Location(robot.getBattleFieldWidth(), robotLocation.getY()));
            return true;
        }
        if (robotLocation.getY() > robot.getBattleFieldHeight() - 100) {
            setNearestPointOnWall(new Location(robotLocation.getX(), robot.getBattleFieldHeight()));
            return true;
        }

        return false;
    }

    public Location getNearestPointOnWall() {
        return nearestPointOnWall;
    }

    public void setNearestPointOnWall(Location nearestPointOnWall) {
        this.nearestPointOnWall = nearestPointOnWall;
        robot.onApproachingWall(this);
    }
}
