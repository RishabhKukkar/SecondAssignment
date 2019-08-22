package com.cmile.secondassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cmile.secondassignment.adapters.HomeModuleListAdapter;
import com.cmile.secondassignment.models.HomeModuleList;
import com.cmile.secondassignment.ui.BaseActivity;
import com.cmile.secondassignment.utils.Common;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cmile.secondassignment.utils.Constants.ADDINFORMATION;
import static com.cmile.secondassignment.utils.Constants.VIEWINFORMATION;

public class MainActivity extends BaseActivity implements HomeModuleListAdapter.ClickListner {

    @BindView(R.id.rv_recyclerView)
    RecyclerView rv_recyclerView;


    private Common common = new Common();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        callRecyclerView();
    }

    private void callRecyclerView() {
        common.homeModuleLists.clear();
        for (int i = 0; i < common.HomeModuleList.length; i++) {
            common.homeModuleLists.add(new HomeModuleList(common.HomeModuleList[i]));
        }
        rv_recyclerView.setHasFixedSize(true);
        rv_recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        common.homeModuleListAdapter = new HomeModuleListAdapter(getApplicationContext(), common.homeModuleLists, this);
        rv_recyclerView.setAdapter(common.homeModuleListAdapter);
        common.homeModuleListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(HomeModuleList homeModuleList) {

        switch (homeModuleList.getHomeModuleName()) {
            case ADDINFORMATION:

                break;
                
            case VIEWINFORMATION:

                break;
        }
    }
}
