package com.xh.wechat.button;

public class PhotoOrAlbum extends AbstractButton{
    public PhotoOrAlbum(String name,String key){
        super(name);
        this.type ="pic_photo_or_album" ;
        this.key = key;
    }
    private String type;
    private String key;
    public String getType() {
        return type;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
