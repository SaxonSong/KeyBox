package com.example.keybox;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.keybox.entity.Key;

public class KeyOperateDialog extends Dialog {

    private TextView deleteTextView;
    private TextView updateTextView;
    private TextView cancelTextView;
    private TextView dialogContent;

    private Context context;
    private String deleteText;
    private String updateText;
    private String cancelText;
    private String dialogContentText;

    private View.OnClickListener deleteClickListener;
    private View.OnClickListener updateClickListener;
    private View.OnClickListener cancelClickListener;

    public void setCancelClickListener(View.OnClickListener cancelClickListener) {
        this.cancelClickListener = cancelClickListener;
    }

    public KeyOperateDialog(Context context) {
        this(context, R.style.KeyOperateDialog);
    }

    public KeyOperateDialog(Context context, int resId) {
        super(context, resId);
        this.context = context;
        deleteText = context.getString(R.string.key_operate_dialog_delete);
        updateText = context.getString(R.string.key_operete_dialog_update);
        cancelText = context.getString(R.string.key_operate_dialog_cancel);
        dialogContentText = context.getString(R.string.key_operate_dialog_content);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.key_item_operate);
        setCanceledOnTouchOutside(true);
        deleteTextView = findViewById(R.id.operate_delete);
        updateTextView = findViewById(R.id.operate_update);
        cancelTextView = findViewById(R.id.operate_cancel);
        dialogContent = findViewById(R.id.dialog_content);
        cancelClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyOperateDialog.this.dismiss();
            }
        };
        if (deleteClickListener != null && updateClickListener != null) {
            init();
        }
    }

    private void init() {
        Log.d("DialogContent", String.valueOf(dialogContent));
        dialogContent.setText(dialogContentText);
        updateTextView.setText(updateText);
        deleteTextView.setText(deleteText);
        cancelTextView.setText(cancelText);
        updateTextView.setOnClickListener(updateClickListener);
        deleteTextView.setOnClickListener(deleteClickListener);
        cancelTextView.setOnClickListener(cancelClickListener);
    }

    public void setDeleteText(String deleteText) {
        this.deleteText = deleteText;
    }

    public void setUpdateText(String updateText) {
        this.updateText = updateText;
    }

    public void setCancelText(String cancelText) {
        this.cancelText = cancelText;
    }

    public void setDialogContentText(String dialogContentText) {
        this.dialogContentText = dialogContentText;
    }

    public void setDeleteClickListener(View.OnClickListener deleteClickListener) {
        this.deleteClickListener = deleteClickListener;
    }

    public void setUpdateClickListener(View.OnClickListener updateClickListener) {
        this.updateClickListener = updateClickListener;
    }
}
