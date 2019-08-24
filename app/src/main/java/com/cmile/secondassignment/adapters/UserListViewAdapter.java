package com.cmile.secondassignment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cmile.secondassignment.R;
import com.cmile.secondassignment.models.UserDetails;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListViewAdapter extends RecyclerView.Adapter<UserListViewAdapter.ViewHolder> {
    private List<UserDetails> userDetails = new ArrayList<>();
    private Context context;
    private ClickListner clickListner;

    public UserListViewAdapter(List<UserDetails> userDetails, Context context, ClickListner clickListner) {
        this.userDetails = userDetails;
        this.context = context;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.newuserlist, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.tv_userName.setText(userDetails.get(i).getUserFirstName());
        viewHolder.tv_phone.setText(" "+userDetails.get(i).getUserPhone());
        viewHolder.tv_country.setText(userDetails.get(i).getUserCountry());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onClicked(userDetails.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return userDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_userName)
        public TextView tv_userName;

        @BindView(R.id.tv_phone)
        public TextView tv_phone;

        @BindView(R.id.tv_country)
        public TextView tv_country;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface ClickListner {
        void onClicked(UserDetails userDetails);
    }
}
