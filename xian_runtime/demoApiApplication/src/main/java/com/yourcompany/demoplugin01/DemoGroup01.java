package com.yourcompany.demoplugin01;

import info.xiancloud.core.Group;

/**
 * Created by happyyangyuan at 2018/2/26
 */
public class DemoGroup01 implements Group {
    public static final DemoGroup01 singleton = new DemoGroup01();

    @Override
    public String getName() {
        return "demoGroup01";
    }
}
