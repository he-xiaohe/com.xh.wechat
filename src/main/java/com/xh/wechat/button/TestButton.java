package com.xh.wechat.button;


import com.xh.wechat.Util.HttpUtil;
import com.xh.wechat.token.TokenUtil;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestButton {
    public static void main(String[] args) {
        //创建一级菜单
        Button button = new Button();
        List<AbstractButton>buttons = new ArrayList<>();
        ClickButton clickButton = new ClickButton("小贺");
        clickButton.setKey("1");
        ViewButton viewButton=new ViewButton("baidu","http://www.baidu.com");
        SubButton subButton = new SubButton("更多");
        List<AbstractButton>subButtons = new ArrayList<>();
        //二级菜单的第一按钮
        subButtons.add(new ViewButton("小贺","http://www.baidu.com"));
        //二级菜单的第二个按钮
        subButtons.add(new PhotoOrAlbum("上传图片","2"));
        subButton.setSub_button(subButtons);
        //把一级菜单中的三个按钮添加进集合
        buttons.add(clickButton);
        buttons.add(viewButton);
        buttons.add(subButton);
        //把集合添加到一级菜单中
        button.setButton(buttons);
        //转换成json字符串
        JSONObject jsonObject = JSONObject.fromObject(button);
        String json = jsonObject.toString();
        String url = String.format(" https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s",
                TokenUtil.getAccessToken());
        //发送请求
       String result= HttpUtil.doPostByButton(url,json);
       System.out.println(result);

    }
}
