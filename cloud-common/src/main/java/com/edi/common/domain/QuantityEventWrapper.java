package com.edi.common.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Edison Xu on 2017/1/3.
 */
public class QuantityEventWrapper{

    /*private List<QuantityEvent> events;

    public List<QuantityEvent> getEvents() {
        return events;
    }

    public void setEvents(List<QuantityEvent> events) {
        this.events = events;
    }*/

    private int test;
    private List<Integer> numList;

    public List<Integer> getNumList() {
        return numList;
    }

    public void setNumList(List<Integer> numList) {
        this.numList = numList;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
