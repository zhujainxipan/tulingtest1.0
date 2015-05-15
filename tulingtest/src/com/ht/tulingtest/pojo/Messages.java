package com.ht.tulingtest.pojo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 * Project: com.ht.tulingtest.pojo
 * Author: 安诺爱成长
 * Email: 1399487511@qq.com
 * Date: 2015/5/13
 */
public class Messages implements Serializable {
    private String time;
    private String content;
    private String username;
    private int imageid;
    private String msgtype;


    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
