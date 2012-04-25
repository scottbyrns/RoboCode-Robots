package com.scottbyrns;
import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.strategies.driving.DrivingStrategies;
import com.scottbyrns.strategies.radar.RadarStrategies;
import com.scottbyrns.strategies.shooting.ShootingStrategies;
import com.scottbyrns.strategies.threat.ThreatStrategies;
import com.scottbyrns.target.Target;


/**
 * Harwer - The Sun God
 */
public class Harwer extends ScottsRobots {

    public void onCreate () {
        requestDrivingStrategy(DrivingStrategies.CRAZY);
        requestRadarStrategy(RadarStrategies.TRACK_TARGET);
        requestShootingStrategy(ShootingStrategies.SIMPLE);
        requestThreatStrategy(ThreatStrategies.NEAREST_TARGET);
    }

    /**
     * It is your initiative. This is your chance to take action!
     */
    public void onInitiative() {
        scan();
    }

    /**
     * Handler for a Robot Targeted event. This event will fire when a robot has been targeted in the scanner.
     *
     * @param target Information about the target including historical statistics.
     */
    public void whenARobotHasBeenTargeted(Target target) {
        
    }

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void whenRobotIsShot() {
		// Replace the next line with any behavior you would like
        // back(10);
	}

    /**
     * Event that fires when you run into a wall.
     */
    public void whenRobotRunsIntoAWall() {
        requestDrivingStrategy(DrivingStrategies.FOLLOW_BORDER);
    }

    /**
     * Handler for a Robot Fired event. This event will fire when it is believed that a target robot has fired. This may
     * not always be accurate but should provide a decent assessment of when a target is on the offensive.
     *
     * @param target The target believed to have fired.
     */
    public void whenARobotHasFired (Target target) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * You are approaching a wall. Just a heads up!
     *
     * @param wall Location on the wall that is closest to your robot.
     */
    public void whenRobotIsApproachingAWall(Location wall) {
//        avoidCollisionWith(wall);
        requestDrivingStrategy(DrivingStrategies.FOLLOW_BORDER);
    }

    /**
     * You are running low on energy. Do something!
     */
    public void whenEnergyIsRunningLow() {
        requestDrivingStrategy(DrivingStrategies.FOLLOWER);
        requestShootingStrategy(ShootingStrategies.CLOSE_RANGE_PREDICTIVE);
        requestThreatStrategy(ThreatStrategies.NEAREST_TARGET);
    }

    /**
     * Your energy levels have returned to normal.
     */
    public void whenEnergyHasReturnedToNormal() {
        requestDrivingStrategy(DrivingStrategies.CRAZY);
        requestShootingStrategy(ShootingStrategies.SIMPLE);
        requestThreatStrategy(ThreatStrategies.WEAKEST_TARGET);
    }

    /**
     * An enemy is so close that you could not avoid being shot if they were to shoot at you.
     */
    public void whenEnemyHasGuaranteedHitOnYou() {
        requestThreatStrategy(ThreatStrategies.NEAREST_TARGET);
        requestShootingStrategy(ShootingStrategies.BULLET_SHIELD);
        requestDrivingStrategy(DrivingStrategies.AVOID_TARGET);
    }

    /**
     * An enemy that once was too close for comfort has moved out of sure fire range.
     */
    public void whenEnemyNoLongerHasGuaranteedHitOnYou() {
        if (weAreInALowEnergyState()) {
            whenEnergyIsRunningLow();
        }
        else {
            whenEnergyHasReturnedToNormal();
        }
    }

    /**
     * The battle has ended. Tear down.
     */
    public void tearDown() {

    }
}
