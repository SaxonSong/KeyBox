package com.example.keybox.adpater;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keybox.KeyOperateDialog;
import com.example.keybox.R;
import com.example.keybox.entity.Key;

import java.util.List;

public class KeyListAdapter extends RecyclerView.Adapter<KeyListAdapter.ViewHolder> {

    private List<Key> keyList;
    private Context mContext;

    public KeyListAdapter(Context context, List<Key> keyList) {
        mContext = context;
        this.keyList = keyList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView keyName;
        private TextView username;
        private TextView keyContent;
        private LinearLayout keyItem;

        public ViewHolder(View view) {
            super(view);
            keyName = view.findViewById(R.id.key_name);
            username = view.findViewById(R.id.user_name);
            keyContent = view.findViewById(R.id.key_content);
            keyItem = view.findViewById(R.id.key_item);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.key_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Key key = keyList.get(position);
        holder.keyName.setText(key.getKeyName());
        holder.username.setText(key.getUsername());
        holder.keyContent.setText(key.getKeyContent());
        holder.keyItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext,"长按事件监听到了", Toast.LENGTH_SHORT).show();
                KeyOperateDialog dialog = new KeyOperateDialog(mContext);
                dialog.setDeleteClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "删除此条密码", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.setUpdateClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "重新编辑此密码", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
    }

    public int getItemCount() {
        return keyList.size();
    }
}
