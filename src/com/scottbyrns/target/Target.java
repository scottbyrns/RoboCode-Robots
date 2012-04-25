package com.scottbyrns.target;

import com.scottbyrns.geometry.primatives.Location;
import com.scottbyrns.target.exceptions.*;
import com.scottbyrns.target.statistics.*;

/**
 * Target that we want to maintain information about.
 *
 * @version 1.0
 */
public interface Target {

    /**
     * Get the name of the target.
     *
     * @return The name of the target.
     */
    public String getTargetName ();

    /**
     * Set the name of the target.
     *
     * @param name The name of the target.
     */
    public void setTargetName (String name);

    /**
     * Get the location of the target.
     *
     * @return The location of the target.
     * @throws UnknownLocation
     */
    public Location getTargetLocation () throws UnknownLocation;

    /**
     * Set the location of the target.
     *
     * @param location The location of the target.
     */
    public void setTargetLocation (Location location);

    /**
     * Get the velocity of the target.
     *
     * @return The velocity of the target.
     * @throws UnknownVelocity
     */
    public Velocity getTargetVelocity () throws UnknownVelocity;

    /**
     * Set the velocity of the target.
     *
     * @param velocity The velocity of the target.
     */
    public void setTargetVelocity (Velocity velocity);

    /**
     * Get the travel direction of the target.
     *
     * @return The travel direction of the target.
     * @throws UnknownHeading
     */
    public Heading getTargetHeading() throws UnknownHeading;

    /**
     * Set the travel heading of the target.
     *
     * @param heading The travel heading of the target.
     */
    public void setTargetHeading(Heading heading);

    /**
     * Get the last known bearing of the target.
     *
     * @return Last known bearing of the target.
     * @throws UnknownBearing
     */
    public Bearing getTargetBearing () throws UnknownBearing;

    /**
     * Set the current bearing of the target.
     *
     * @param bearing Current bearing of the target. 
     */
    public void setTargetBearing (Bearing bearing);

    /**
     * Get the last known energy of the target.
     *
     * @return Last known energy of the target.
     * @throws UnknownEnergy
     */
    public Energy getTargetEnergy () throws UnknownEnergy;

    /**
     * Set the current energy of the target.
     *
     * @param energy Current energy of the target.
     */
    public void setTargetEnergy (Energy energy);

    /**
     * Get the distance to the target.
     *
     * @throws UnknownDistance The distance to the target.
     */
    public Distance getTargetDistance () throws UnknownDistance;

    /**
     * Set the distance to the target.
     *
     * @param distance The distance to the target.
     */
    public void setTargetDistance (Distance distance);

    /**
     * See if the target fired it's cannon.
     *
     * @return True if the target fired it's cannon, false otherwise.
     */
    public boolean didFire ();
}
