package com.cmile.secondassignment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cmile.secondassignment.R;
import com.cmile.secondassignment.models.HomeModuleList;
import com.cmile.secondassignment.utils.Common;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cmile.secondassignment.utils.Constants.ADDINFORMATION;
import static com.cmile.secondassignment.utils.Constants.VIEWINFORMATION;

public class HomeModuleListAdapter extends RecyclerView.Adapter<HomeModuleListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeModuleList> homeModuleLists;
    private ClickListner clickListner;

    public HomeModuleListAdapter(Context context, ArrayList<HomeModuleList> homeModuleLists, ClickListner clickListner) {
        this.context = context;
        this.homeModuleLists = homeModuleLists;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_homemodel_cardview, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_module_card.setText(homeModuleLists.get(i).getHomeModuleName());

        switch (homeModuleLists.get(i).getHomeModuleName()) {
            case ADDINFORMATION:
                Glide.with(viewHolder.itemView).load(R.drawable.ic_person_add).into(viewHolder.iv_module_card);
                break;
            case VIEWINFORMATION:
                Glide.with(viewHolder.itemView).load(R.drawable.ic_people_black).into(viewHolder.iv_module_card);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return homeModuleLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_module_card)
        public ImageView iv_module_card;

        @BindView(R.id.tv_module_card)
        public TextView tv_module_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ClickListner {
        void onClick(HomeModuleList homeModuleList);
    }
}
