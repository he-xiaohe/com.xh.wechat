package com.xh.wechat.token;

import com.xh.wechat.Util.HttpUtil;
import net.sf.json.JSONObject;


public class TokenUtil {

    private static final String APP_ID="wxab1d58ea7db48071";
    private static final String APP_SECRET="acceea79b13ae5eee98654f8e781864b";
    private  static  AccessToken accessToken = new AccessToken();
    public static void main(String[] args){
        //{"access_token":"64_DYGDE-Xo0ExT9kWpjUEbkYBEn_ZU3tWvz6qAm2ys5qZwqteIf8McthE4JIbRTEF0pFGo1BhZ2BHxKyDsn-_HU4HE5EHrcuNM7IIPMRtr28N38h-vu-PT4gbHZdMYOWiAHASIQ","expires_in":7200}
//        getToken();
//        getAccessToken();
        System.out.println(getAccessToken());
        System.out.println(getAccessToken());
    }
    private static void getToken(){
        String url = String.format(" https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                APP_ID,APP_SECRET);
        String result = HttpUtil.doGet(url);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String token = jsonObject.getString("access_token");
        long expiresIn = jsonObject.getLong("expires_in");
//        AccessToken accessToken = new AccessToken();
        accessToken.setToken(token);
        accessToken.setExpireTime(expiresIn);
    }
    /**
     * 获取AccessToken
     * @return
     */

    public  static  String getAccessToken(){
        if (accessToken == null||accessToken.isExpired()) {
            getToken();
        }
        return accessToken.getToken();
    }
}
