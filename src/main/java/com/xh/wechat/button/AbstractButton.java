package com.xh.wechat.button;

public abstract class AbstractButton {
    private String name;
    public AbstractButton(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
