package com.eeyes.designtemplate.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eeyes.designtemplate.R;
import com.eeyes.designtemplate.bean.AcItem;
import com.eeyes.designtemplate.common.EeyesNewsTypes;
import com.eeyes.designtemplate.interfaces.OnRecyclerViewOnClickListener;
import com.eeyes.designtemplate.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guolei on 2016/7/25.
 */
public class EeyesAcFragmentAdapter extends RecyclerView.Adapter<EeyesAcFragmentAdapter.EeyesAcItemViewHolder>{
    private final Context context;
    private final LayoutInflater inflater;
    private List<AcItem> list = new ArrayList<>();
    private OnRecyclerViewOnClickListener mListener;



    public EeyesAcFragmentAdapter(Context context, List<AcItem> list){
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public EeyesAcItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.universal_item_layout, parent, false);
        EeyesAcItemViewHolder holder = new EeyesAcItemViewHolder(view, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(EeyesAcItemViewHolder holder, int position) {
        AcItem item = list.get(position);

        holder.titleTextView.setText(item.getActitle());

        holder.whereTextView.setText("活动地点：" + item.getAcwhere());

        holder.timeTextView.setText("活动时间：" + DateUtil.getDateToString(Long.parseLong(item.getActime())));

        holder.typeTextView.setText("活动类型：" + EeyesNewsTypes.getTypeName(Integer.parseInt(item.getTypeid())));

        holder.cardTextView.setText("检票（刷卡）：" + (item.getActic().equals("0")?"否":"是"));

        String contentHtml = item.getActext();

        contentHtml = contentHtml.replaceAll("<img .*?/>", "");

        holder.contentTextView.setText(Html.fromHtml(contentHtml));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemClickListener(OnRecyclerViewOnClickListener listener){
        this.mListener = listener;
    }


    public class EeyesAcItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView titleTextView;
        private TextView whereTextView;
        private TextView timeTextView;
        private TextView typeTextView;
        private TextView cardTextView;
        private TextView contentTextView;
        private OnRecyclerViewOnClickListener listener;
        private CardView item;

        public EeyesAcItemViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            whereTextView = (TextView) itemView.findViewById(R.id.whereTextView);
            timeTextView = (TextView) itemView.findViewById(R.id.timeTextView);
            typeTextView = (TextView) itemView.findViewById(R.id.typeTextView);
            cardTextView = (TextView) itemView.findViewById(R.id.cardTextView);
            contentTextView = (TextView) itemView.findViewById(R.id.contentTextView);
            item = (CardView) itemView.findViewById(R.id.card_view_item);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.OnItemClick(view, getLayoutPosition());
            }

        }
    }
}
