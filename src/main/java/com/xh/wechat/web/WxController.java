package com.xh.wechat.web;


import com.thoughtworks.xstream.XStream;
import com.xh.wechat.message.TextMessage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class WxController {
    @GetMapping("/hello")
    public String hello() {
        return "hello word";
    }


    @GetMapping("/")
    public String check(String signature,
                        String timestamp,
                        String nonce,
                        String echostr) {

        //1）将token、timestamp、nonce三个参数进行字典序排序
         String token = "xiaohe";
        List<String> list = Arrays.asList(token, timestamp, nonce);
        //排序
        Collections.sort(list);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        //加密
        try {
            MessageDigest instance = MessageDigest.getInstance("sha1");
            //使用sha1进行加密，获得byte数组
            byte[] digest = instance.digest(stringBuilder.toString().getBytes());
            StringBuilder sum = new StringBuilder();
            for (byte b : digest) {
                sum.append(Integer.toHexString((b >> 4) & 15));
                sum.append(Integer.toHexString(b & 15));
            }
            //3）开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信
            if (!StringUtils.isEmpty(signature) && signature.equals(sum.toString())) {
                return echostr;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/")
    public String receiveMessage(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
//        byte[] b = new byte[1024];
//        int len = 0;
//        while ((len = inputStream.read(b)) != -1) {
//            System.out.println(new String(b,0,len));
//        }
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取request输入流，获得Document对象
            Document document = reader.read(inputStream);
            //获得root节点
            Element root = document.getRootElement();
            //获取所有的子节点
            List<Element>elements=root.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);
        //回复文本消息
        String message =getReplyMessage(map);

        return message;
    }
/**
 * 获得回复的消息内容
 * @parm map
 * @return
 */

    private String getReplyMessage(Map<String, String> map) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setMsgType("text");
        textMessage.setContent("欢迎关注本公众号！");
        textMessage.setCreateTime(System.currentTimeMillis()/1000);

        //xStream将Java对象转换xml
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);
        String xml = xStream.toXML(textMessage);
        return xml;
    }

}