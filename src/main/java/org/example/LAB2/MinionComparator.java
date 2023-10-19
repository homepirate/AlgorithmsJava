package org.example.LAB2;

import java.util.Comparator;

public class MinionComparator implements Comparator<Minion> {
    @Override
    public int compare(Minion o1, Minion o2) {
        int result = (o1.getEyeCount() - o2.getEyeCount()) + (o1.getAge() - o2.getAge());
        return result;
    }
}
