package com.xh.wechat.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/*
*<xml>
  <ToUserName><![CDATA[toUser]]></ToUserName>
  <FromUserName><![CDATA[fromUser]]></FromUserName>
  <CreateTime>12345678</CreateTime>
  <MsgType><![CDATA[news]]></MsgType>
  <ArticleCount>1</ArticleCount>
  <Articles>
    <item>
      <Title><![CDATA[title1]]></Title>
      <Description><![CDATA[description1]]></Description>
      <PicUrl><![CDATA[picurl]]></PicUrl>
      <Url><![CDATA[url]]></Url>
    </item>
  </Articles>
</xml>

* */
@XStreamAlias("xml")
public class NewsMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("ArticleCount")
    private int articleCount;
    @XStreamAlias("Articles")
    private List<Article>articles;


    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> article) {
        this.articles = article;
    }
}
