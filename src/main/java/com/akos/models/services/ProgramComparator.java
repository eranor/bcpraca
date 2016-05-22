package com.akos.models.services;

/**
 * Created by Ákos on 2015. 12. 09.
 * Email: akoshervay@gmail.com
 */
public class ProgramComparator implements java.util.Comparator<Program> {

    @Override
    public int compare(Program o1, Program o2) {
        return o1.getId() == o2.getId() ? 1 : 0;
    }
}
