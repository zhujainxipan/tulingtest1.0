package com.ht.tulingtest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import com.ht.tulingtest.R;
import com.ht.tulingtest.adapters.MyAdapter;
import com.ht.tulingtest.pojo.Messages;
import com.ht.tulingtest.tasks.MyTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private EditText input;
    private List<Messages> list;
    private MyAdapter adapter;
    private Handler handler;
    private ListView listView;

    public Handler getHandler() {
        return handler;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        input = (EditText) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int what = msg.what;
                switch (what) {
                    case 998:
                        String receivecontent = (String) msg.obj;
                        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time = sDateFormat.format(System.currentTimeMillis());
                        Messages receivemessages = genernateMessages(receivecontent,
                                R.drawable.renma,
                                time,
                                "mm",
                                "receive");
                        list.add(receivemessages);
                        adapter.notifyDataSetChanged();
                        listView.setSelection(adapter.getCount() - 1);
                        break;
                }
            }
        };
    }

    //点击提交的时候触发的事件。
    public void addOnClick(View view) {
        String inputStr = input.getText().toString();
        if (inputStr.length() > 0) {
            //添加一条发送信息
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = sDateFormat.format(System.currentTimeMillis());
            Messages sendmessages = genernateMessages(inputStr,
                    R.drawable.xiaohei,
                    time,
                    "小黑",
                    "send");
            list.add(sendmessages);
            adapter.notifyDataSetChanged();
            input.setText("");
            listView.setSelection(adapter.getCount() - 1);
            Thread thread = new Thread(new MyTask(inputStr, this));
            thread.start();
        }
    }

    private Messages genernateMessages(String content,
                                       int imageid,
                                       String time,
                                       String username,
                                       String msgtype) {
        Messages messages = new Messages();
        messages.setContent(content);
        messages.setImageid(imageid);
        messages.setTime(time);
        messages.setUsername(username);
        messages.setMsgtype(msgtype);
        return messages;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
