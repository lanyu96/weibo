package mvp.com.zhou.mvp.ui.dialog.weibo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import mvp.com.zhou.mvp.R;

public class InfoDialog extends Dialog{
    private Dialog dialog;
    private Context context;
    private String id;
    private InfoDialog.OnClickListener listener;
    private String zhifaStr;
    private String zhuanfaStr;
    private String zhidingStr;
    private String zhifaInStr;
    private String zhuanfaInStr;
    private String zhidingInStr;
    private TextView a01;
    private TextView a02;
    private TextView a03;
    private TextView a04;
    private TextView a05;
    private TextView a06;

    public InfoDialog( @NonNull Context context) {
        super(context);
    }


    public Dialog setListener(OnClickListener listener) {
        this.listener = listener;
        return dialog;
    }

    public InfoDialog showInfoDialog(Context content, String id) {

        this.context = content;
        this.id = id;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getInfoView();
        builder.setView(view);


        dialog = builder.create();

        return this;
    }

    private View getInfoView() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_info_dialog
                , null);
        TextView finishTv = view.findViewById(R.id.dialog_finish);
        finishTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.OnFinishClickListener();
                }
            }
        });
        a01 = view.findViewById(R.id.act_1);
        a02 = view.findViewById(R.id.act_2);
        a03 = view.findViewById(R.id.act_3);
        a04 = view.findViewById(R.id.act_4);
        a05 = view.findViewById(R.id.act_5);
        a06 = view.findViewById(R.id.act_6);
        zhifaStr = "";
        zhuanfaStr = "";
        zhidingStr = "";
        zhifaInStr = "";
        zhuanfaInStr = "";
        zhidingInStr = "";
        switch (id) {
            case "a1":
                zhifaStr = "22";
                zhuanfaStr = "22";
                zhidingStr = "22";
                zhifaInStr = "22";
                zhuanfaInStr = "22";
                zhidingInStr = "22";
                break;
            case "a2":
                zhifaStr = "22";
                zhuanfaStr = "22";
                zhidingStr = "22";
                zhifaInStr = "22";
                zhuanfaInStr = "22";
                zhidingInStr = "22";
                break;
            case "a3":
                zhifaStr = "22";
                zhuanfaStr = "22";
                zhidingStr = "22";
                zhifaInStr = "22";
                zhuanfaInStr = "22";
                zhidingInStr = "22";
                break;


        }
        a01.setText(zhifaStr);
        a02.setText(zhuanfaStr);
        a03.setText(zhidingStr);
        a04.setText(zhifaInStr);
        a05.setText(zhuanfaInStr);
        a06.setText(zhidingInStr);

        return view;
    }


    
    public interface OnClickListener {

        void OnFinishClickListener();

    }

}
