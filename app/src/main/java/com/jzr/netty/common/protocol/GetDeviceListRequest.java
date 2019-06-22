package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class GetDeviceListRequest extends BaseMsg {
    public GetDeviceListRequest(){
        super();
        this.setType(MsgType.GET_DEVICE_LIST);
        this.setDeviceNo("admin");
    }
}
