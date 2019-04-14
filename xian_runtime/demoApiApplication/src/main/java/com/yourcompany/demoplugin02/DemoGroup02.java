package com.yourcompany.demoplugin02;

import info.xiancloud.core.Group;

/**
 * Created by happyyangyuan at 2018/2/26
 */
public class DemoGroup02 implements Group {
    @Override
    public String getName() {
        return "demoGroup02";
    }

    public static final DemoGroup02 singleton = new DemoGroup02();
}
