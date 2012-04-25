package com.scottbyrns.strategies.radar;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;
import com.scottbyrns.target.SimpleTarget;

/**
 * Track the primary threat closely with radar, don't let him out of our sight.
 *
 * @author scott
 */
public class TrackTarget extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        Console.log("Radar Strategy TRACK_TARGET.");
        try {
            if (robot.getRadarTurnRemaining() == 0.0) {
                robot.aimRadarAt(((SimpleTarget)robot.getPrimaryThreat()).projectTheMostLikelyLocationOfTheTargetBasedOnLastKnownHeadingVelocityAndLocation());
                if (robot.didNotSeeTargetsTheLastFewTurns()) {
                    robot.setTurnRadarRightRadians(1);
                }
            }
//            else {
//                robot.aimRadarAt(robot.getTargetMap().getEntrySetIterator().next().getValue().getTargetLocation());
//            }
        }
        catch (Throwable throwable) {
            robot.setTurnRadarRightRadians(1);
        }
    }
}
