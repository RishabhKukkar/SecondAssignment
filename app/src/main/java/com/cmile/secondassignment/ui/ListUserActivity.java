package com.cmile.secondassignment.ui;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.cmile.secondassignment.R;
import com.cmile.secondassignment.adapters.UserListViewAdapter;
import com.cmile.secondassignment.models.UserDetails;
import com.cmile.secondassignment.utils.Common;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.QuerySnapshot;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListUserActivity extends BaseActivity implements UserListViewAdapter.ClickListner {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_recyclerView)
    RecyclerView rv_recyclerView;

    private Common common = new Common();


    private static final String TAG = ListUserActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ButterKnife.bind(this);
        setupToolbar(toolbar,getString(R.string.user_list_activity));

        getUsersList();

    }


    private void getUsersList() {
        common.db.collection("userDetails").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult() != null) {
                        common.userDetails = task.getResult().toObjects(UserDetails.class);

                        for (UserDetails userDetails : common.userDetails) {
                            Log.d(TAG, "" + userDetails.getUserFirstName());
                            Log.d(TAG, "" + userDetails.getUserLastName());
                            Log.d(TAG, "" + userDetails.getUserEmail());
                            Log.d(TAG, "" + userDetails.getUserAge());
                            Log.d(TAG, "" + userDetails.getUserBirthdate());
                        }
                        setRecyclerView(common.userDetails);
                    }
                }
            }
        });


    }

    private void setRecyclerView(List<UserDetails> userDetails) {

        rv_recyclerView.setHasFixedSize(true);
        rv_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        common.userListViewAdapter = new UserListViewAdapter(userDetails, this, this);
        rv_recyclerView.setAdapter(common.userListViewAdapter);
        common.userListViewAdapter.notifyDataSetChanged();


    }

    @Override
    public void onClicked(UserDetails userDetails) {

    }
}
