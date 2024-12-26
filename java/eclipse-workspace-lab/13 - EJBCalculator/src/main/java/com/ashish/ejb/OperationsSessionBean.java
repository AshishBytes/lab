package com.ashish.ejb;

import javax.ejb.Stateless;

@Stateless
public class OperationsSessionBean implements OperationsSessionBeanRemote {

    public float add(float x, float y) {
        return x + y;
    }

    public float subtract(float x, float y) {
        return x - y;
    }

    public float multiply(float x, float y) {
        return x * y;
    }

    public float divide(float x, float y) {
        return x / y;
    }
}