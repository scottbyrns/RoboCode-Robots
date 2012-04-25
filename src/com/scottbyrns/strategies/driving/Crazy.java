package com.scottbyrns.strategies.driving;

import com.scottbyrns.ScottsRobots;
import com.scottbyrns.strategies.BaseStrategy;
import com.scottbyrns.target.Console;
import robocode.TurnCompleteCondition;

/**
 * Created: Dec 11, 2010
 *
 * @author scott
 */
public class Crazy extends BaseStrategy {

    /**
     * Event notifying the strategy that it has the initiative to act.
     *
     * @param robot Reference to the host robot.
     */
    public void onInitiative(ScottsRobots robot) {
        Console.log("Driving like a madman!");
        // Tell the game we will want to move ahead 40000 -- some large number
        robot.setAhead(40000);

        // Tell the game we will want to turn right 90
        robot.setTurnRight(90);
        // At this point, we have indicated to the game that *when we do something*,
        // we will want to move ahead and turn right.  That's what "set" means.
        // It is important to realize we have not done anything yet!
        // In order to actually move, we'll want to call a method that
        // takes real time, such as waitFor.
        // waitFor actually starts the action -- we start moving and turning.

        // It will not return until we have finished turning.
//        robot.waitFor(new TurnCompleteCondition(robot));
        // Note:  We are still moving ahead now, but the turn is complete.
        // Now we'll turn the other way...
        robot.setTurnLeft(180);
        // ... and wait for the turn to finish ...
//        robot.waitFor(new TurnCompleteCondition(robot));
        // ... then the other way ...
        robot.setTurnRight(180);
        // .. and wait for that turn to finish.
//        robot.waitFor(new TurnCompleteCondition(robot));
        // then back to the top to do it all again
    }
}
