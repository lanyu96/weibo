package mvp.com.zhou.mvp.utils.dialog.weibo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.utils.bean.weibo.BJBean;

public class BjDialog {

    private Context context;
    private Dialog dialog;
    private BjDialog.OnClickListener listener;
    private BJBean bean;
    private TextView bj01;
    private TextView bj02;
    private TextView bj03;
    private TextView bj04;

    public Dialog setListener(OnClickListener listener) {
        this.listener = listener;
        return dialog;
    }

    public BjDialog showBjDialog(Context context, BJBean bean) {

        this.context = context;
        this.bean = bean;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View v = initView();
        builder.setView(v);
        dialog = builder.create();

        return this;
    }

    private View initView() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_bj_info, null);
        bj01 = view.findViewById(R.id.dialog_bj_tv_01);
        bj02 = view.findViewById(R.id.dialog_bj_tv_02);
        bj03 = view.findViewById(R.id.dialog_bj_tv_03);
        bj04 = view.findViewById(R.id.dialog_bj_tv_04);

        bj01.setText(bean.getDay3());
        bj02.setText(bean.getDay7());
        bj03.setText(bean.getDay15());
        bj04.setText(bean.getDay30());
        return view;
    }

    public interface OnClickListener{
        void onFinishListener();
    }




}
