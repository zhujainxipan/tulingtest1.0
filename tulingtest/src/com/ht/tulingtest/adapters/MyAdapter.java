package com.ht.tulingtest.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ht.tulingtest.R;
import com.ht.tulingtest.pojo.Messages;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Project: com.ht.mynote.adapters
 * Author: 安诺爱成长
 * Email: 1399487511@qq.com
 * Date: 2015/5/2
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Messages> list;

    final int IMVT_COM_MSG = 0;
    final int IMVT_TO_MSG = 1;

    public MyAdapter(Context context, List<Messages> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getMsgtype() == "send")
            return IMVT_COM_MSG;
        else
            return IMVT_TO_MSG;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderSend viewHolderSend = null;
        ViewHolderReceive viewHolderReceive = null;
        int type = getItemViewType(i);

        if (view == null) {
            switch (type) {
                case IMVT_COM_MSG:
                    view = LayoutInflater.from(context).inflate(R.layout.chatting_item_msg_text_right, null);
                    viewHolderReceive = new ViewHolderReceive();
                    viewHolderReceive.time = (TextView) view.findViewById(R.id.tv_sendtime);
                    viewHolderReceive.content = (TextView) view.findViewById(R.id.tv_chatcontent);
                    viewHolderReceive.touxiang = (ImageView) view.findViewById(R.id.iv_userhead);
                    viewHolderReceive.username = (TextView) view.findViewById(R.id.tv_username);
                    view.setTag(viewHolderReceive);
                    break;
                case IMVT_TO_MSG:
                    view = LayoutInflater.from(context).inflate(R.layout.chatting_item_msg_text_left, null);
                    viewHolderSend = new ViewHolderSend();
                    viewHolderSend.time = (TextView) view.findViewById(R.id.tv_sendtime);
                    viewHolderSend.content = (TextView) view.findViewById(R.id.tv_chatcontent);
                    viewHolderSend.touxiang = (ImageView) view.findViewById(R.id.iv_userhead);
                    viewHolderSend.username = (TextView) view.findViewById(R.id.tv_username);
                    view.setTag(viewHolderSend);
                    break;
            }

        }
        else {
            switch (type) {
                case IMVT_TO_MSG:
                    viewHolderSend = (ViewHolderSend) view.getTag();
                    break;
                case IMVT_COM_MSG:
                    viewHolderReceive = (ViewHolderReceive) view.getTag();
                    break;

            }
        }

        switch (type) {
            case IMVT_COM_MSG:
                viewHolderReceive.time.setText(list.get(i).getTime());
                viewHolderReceive.username.setText(list.get(i).getUsername());
                Bitmap bitmapR = BitmapFactory.decodeResource(context.getResources(), list.get(i).getImageid());
                viewHolderReceive.touxiang.setImageBitmap(bitmapR);
                viewHolderReceive.content.setText(list.get(i).getContent());
                break;

            case IMVT_TO_MSG:
                viewHolderSend.time.setText(list.get(i).getTime());
                viewHolderSend.username.setText(list.get(i).getUsername());
                Bitmap bitmapS = BitmapFactory.decodeResource(context.getResources(), list.get(i).getImageid());
                viewHolderSend.touxiang.setImageBitmap(bitmapS);
                viewHolderSend.content.setText(list.get(i).getContent());
                break;
        }
        return view;
    }

    private class ViewHolderSend {
        private TextView content;
        private TextView time;
        private ImageView touxiang;
        private TextView username;
    }


    private class ViewHolderReceive {
        private TextView content;
        private TextView time;
        private ImageView touxiang;
        private TextView username;
    }
}
