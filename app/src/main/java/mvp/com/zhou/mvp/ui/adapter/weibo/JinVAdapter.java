package mvp.com.zhou.mvp.ui.adapter.weibo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.dialog.weibo.InfoDialog;
import mvp.com.zhou.mvp.ui.view.InfoViewActivity;

public class JinVAdapter extends RecyclerView.Adapter<JinVAdapter.JinVViewHodler> {
    private Context context;
    private List<JVBean> list;
    protected OnItemClickListener onItemClickListener;

    public JinVAdapter(Context context, List<JVBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public JinVViewHodler onCreateViewHolder(ViewGroup viewGroup, int i) {

        return new JinVViewHodler(LayoutInflater.from(context).inflate(R.layout.item_jin_v_info,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(final JinVViewHodler jinVViewHodler, int i) {
        final JVBean jvBean = list.get(i);

        jinVViewHodler.circleImageView.setImageDrawable(context.getResources().getDrawable(jvBean.getHead()));
//        jinVViewHodler.circleImageView.setImageResource(jvBean.getHead());
        jinVViewHodler.indexSrcTv.setText(jvBean.getIndexSrc());
        jinVViewHodler.loveTv.setText(jvBean.getFenSi());
        jinVViewHodler.moneyTv.setText(jvBean.getMoney());
        jinVViewHodler.userTv.setText(jvBean.getName());
        jinVViewHodler.wbName.setText(jvBean.getWBName());

        jinVViewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = jinVViewHodler.getAdapterPosition();

                Intent intent = new Intent(context, InfoViewActivity.class);
                JVBean bean = new JVBean();
                bean.setName("123");

                List<JVBean> list = new ArrayList<>();
                list.add(bean);
                Bundle bundle = new Bundle();
                bundle.putSerializable("info",bean);
                intent.putExtra("vInfo","aaa");
                context.startActivity(intent);
//                new InfoDialog().showInfoDialog(context, list.get(adapterPosition))
//                .setListener(new InfoDialog.OnClickListener() {
//                    @Override
//                    public void OnFinishClickListener() {
//
//                    }
//                }).show();


            }
        });


    }


    public interface OnItemClickListener {
        void onItemClick(int position, View v);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class JinVViewHodler extends RecyclerView.ViewHolder {


        CircleImageView circleImageView;
        TextView indexSrcTv;
        TextView userTv;
        TextView loveTv;
        TextView moneyTv;
        TextView wbName;

        public JinVViewHodler(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.item_jin_v_info_head_civ);
            indexSrcTv = itemView.findViewById(R.id.item_jin_v_info_index_src);
            userTv = itemView.findViewById(R.id.item_jin_v_user_tv);
            loveTv = itemView.findViewById(R.id.item_jin_v_info_love_tv);
            moneyTv = itemView.findViewById(R.id.item_jin_v_info_money_tv);
            wbName = itemView.findViewById(R.id.item_jin_v_info_wb_name_tv);
        }
    }
}
