package com.ht.tulingtest.tasks;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.ht.tulingtest.R;
import com.ht.tulingtest.Utils.HttpUtils;
import com.ht.tulingtest.activities.MainActivity;
import com.ht.tulingtest.pojo.Messages;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA
 * Project: com.ht.tulingtest.tasks
 * Author: 安诺爱成长
 * Email: 1399487511@qq.com
 * Date: 2015/5/14
 */
public class MyTask implements Runnable {
    private String inputStr;
    private Context context;

    public MyTask(String inputStr, Context context) {
        this.inputStr = inputStr;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            MainActivity mainActivity = (MainActivity) context;
            Handler handler = mainActivity.getHandler();
            String receivecontent = HttpUtils.getResponse(inputStr);
            Message message = handler.obtainMessage(998, receivecontent);
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
