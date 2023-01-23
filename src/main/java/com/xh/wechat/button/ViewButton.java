package com.xh.wechat.button;

public class ViewButton extends AbstractButton{
    public ViewButton(String name,String url) {
        super(name);
        this.type="view";
        this.url=url;
    }
    private String type;
    private String url;
    public String getType() {
        return type;
    }
//    public void setType(String type) {
//        this.type=type;
//    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
