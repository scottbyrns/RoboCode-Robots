package com.scottbyrns.target;

import com.scottbyrns.target.exceptions.UnknownTarget;

import java.util.*;

/**
 * Created: Dec 10, 2010
 *
 * @author scott
 */
public class TargetMap {

    private Map<String, Target> targetMap = new HashMap<String, Target>();

    /**
     * Add a target to the target map.
     *
     * @param target Target to add to the target map.
     */
    public void add(Target target) {
        targetMap.put(target.getTargetName(), target);
    }

    /**
     * Get a target from the target map.
     *
     * @param targetName Name of the target to get.
     * @return Requested target.
     */
    public Target get(String targetName) throws UnknownTarget {
        if (targetMap.containsKey(targetName)) {
            return targetMap.get(targetName);
        }
        else {
            throw new UnknownTarget();
        }
    }

    /**
     * Get the target map.
     *
     * @return The target map.
     */
    private Map<String, Target> getTargetMap() {
        return targetMap;
    }

    /**
     * Remove a target from the map.
     *
     * @param target Target to remove.
     */
    public void remove (String target) {
        getTargetMap().remove(target);
    }

    public Iterator<Target> getTargetIterator () {
        List<Target> targetList = new ArrayList<Target>();
        Iterator<Map.Entry<String, Target>> targetEntrySetIterator = getEntrySetIterator();

        while (targetEntrySetIterator.hasNext()) {
            targetList.add(targetEntrySetIterator.next().getValue());
        }

        return targetList.iterator();
    }

    public Iterator<Map.Entry<String, Target>> getEntrySetIterator () {
        return getTargetMap().entrySet().iterator();
    }
}
