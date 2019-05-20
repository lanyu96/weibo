package mvp.com.zhou.mvp.utils.dialog.weibo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
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
               dialog.dismiss();
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
                zhifaStr = "1800";
                zhuanfaStr = "1600";
                zhidingStr = "2800";
                zhifaInStr = "1700";
                zhuanfaInStr = "1500";
                zhidingInStr = "2500";
                break;
            case "a2":
                zhifaStr = "1800";
                zhuanfaStr = "1600";
                zhidingStr = "2800";
                zhifaInStr = "1700";
                zhuanfaInStr = "1500";
                zhidingInStr = "2500";
                break;
            case "a3":
                zhifaStr = "1200";
                zhuanfaStr = "1000";
                zhidingStr = "1800";
                zhifaInStr = "1100";
                zhuanfaInStr = "900";
                zhidingInStr = "1600";
                break;
            case "a4":
                zhifaStr = "800";
                zhuanfaStr = "600";
                zhidingStr = "1000";
                zhifaInStr = "700";
                zhuanfaInStr = "500";
                zhidingInStr = "800";
                break;
            case "a5":
                zhifaStr = "700";
                zhuanfaStr = "600";
                zhidingStr = "900";
                zhifaInStr = "600";
                zhuanfaInStr = "500";
                zhidingInStr = "800";
                break;
            case "a6":
                zhifaStr = "600";
                zhuanfaStr = "500";
                zhidingStr = "800";
                zhifaInStr = "500";
                zhuanfaInStr = "400";
                zhidingInStr = "700";
                break;
            case "a7":
                zhifaStr = "600";
                zhuanfaStr = "500";
                zhidingStr = "800";
                zhifaInStr = "500";
                zhuanfaInStr = "400";
                zhidingInStr = "700";
                break;
            case "a8":
                zhifaStr = "500";
                zhuanfaStr = "400";
                zhidingStr = "700";
                zhifaInStr = "400";
                zhuanfaInStr = "300";
                zhidingInStr = "600";
                break;
            case "a9":
                zhifaStr = "500";
                zhuanfaStr = "400";
                zhidingStr = "700";
                zhifaInStr = "400";
                zhuanfaInStr = "300";
                zhidingInStr = "600";
                break;
            case "b1":
                zhifaStr = "400";
                zhuanfaStr = "300";
                zhidingStr = "600";
                zhifaInStr = "300";
                zhuanfaInStr = "200";
                zhidingInStr = "500";
                break;
            case "b2":
                zhifaStr = "300";
                zhuanfaStr = "200";
                zhidingStr = "500";
                zhifaInStr = "200";
                zhuanfaInStr = "150";
                zhidingInStr = "400";
                break;
            case "b3":
                zhifaStr = "300";
                zhuanfaStr = "200";
                zhidingStr = "500";
                zhifaInStr = "200";
                zhuanfaInStr = "150";
                zhidingInStr = "400";
                break;
            case "b4":
                zhifaStr = "300";
                zhuanfaStr = "200";
                zhidingStr = "500";
                zhifaInStr = "200";
                zhuanfaInStr = "150";
                zhidingInStr = "400";
                break;
            case "b5":
                zhifaStr = "300";
                zhuanfaStr = "200";
                zhidingStr = "500";
                zhifaInStr = "200";
                zhuanfaInStr = "150";
                zhidingInStr = "400";
                break;
            case "b6":
                zhifaStr = "200";
                zhuanfaStr = "150";
                zhidingStr = "400";
                zhifaInStr = "150";
                zhuanfaInStr = "100";
                zhidingInStr = "300";
                break;
            case "c1":
                zhifaStr = "100";
                zhuanfaStr = "80";
                zhidingStr = "200";
                zhifaInStr = "80";
                zhuanfaInStr = "60";
                zhidingInStr = "150";
                break;
            case "c2":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c3":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c4":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c5":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c6":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c7":
                zhifaStr = "50";
                zhuanfaStr = "40";
                zhidingStr = "80";
                zhifaInStr = "40";
                zhuanfaInStr = "30";
                zhidingInStr = "60";
                break;
            case "c8":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "c9":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d1":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d2":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d3":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d4":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d5":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
                break;
            case "d6":
                zhifaStr = "30";
                zhuanfaStr = "30";
                zhidingStr = "50";
                zhifaInStr = "30";
                zhuanfaInStr = "30";
                zhidingInStr = "40";
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
