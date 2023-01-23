package com.xh.wechat.button;

public class ClickButton extends AbstractButton {
    public ClickButton(String name){
        super(name);
        this.type = "click";
    }
    private String type;
    private String key;
    public String getType() {
        return type;
    }
//    public void setType(String type) {
//        this.type = type;
//    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
