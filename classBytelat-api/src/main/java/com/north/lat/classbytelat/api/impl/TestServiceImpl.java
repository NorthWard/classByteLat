package com.north.lat.classbytelat.api.impl;

import com.north.lat.classbytelat.api.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("call test");
    }
}
