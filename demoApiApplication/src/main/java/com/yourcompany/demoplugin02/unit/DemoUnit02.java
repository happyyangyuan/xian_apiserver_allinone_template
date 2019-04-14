package com.yourcompany.demoplugin02.unit;

import com.yourcompany.demoplugin02.DemoGroup02;
import info.xiancloud.core.Group;
import info.xiancloud.core.Handler;
import info.xiancloud.core.Input;
import info.xiancloud.core.Unit;
import info.xiancloud.core.message.UnitRequest;
import info.xiancloud.core.message.UnitResponse;

/**
 * Created by happyyangyuan at 2018/2/26
 */
public class DemoUnit02 implements Unit {
    @Override
    public String getName() {
        return "demoUnit02";
    }

    @Override
    public Input getInput() {
        return Input.create().add("param", String.class, "必填参数", REQUIRED);
    }

    @Override
    public Group getGroup() {
        return DemoGroup02.singleton;
    }

    @Override
    public void execute(UnitRequest request, Handler<UnitResponse> handler) {
        handler.handle(UnitResponse.createSuccess(request.get("param")));
    }
}
