package com.scottbyrns;

/**
 * Created: Dec 11, 2010
 *
 * @author scott
 */
public class Global {

    private static int currentEpoch;

    public static int getCurrentEpoch() {
        return currentEpoch;
    }

    public static void setCurrentEpoch(int currentEpoch) {
        Global.currentEpoch = currentEpoch;
    }
}
