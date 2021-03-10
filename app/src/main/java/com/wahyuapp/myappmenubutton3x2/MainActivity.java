package com.wahyuapp.myappmenubutton3x2;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.wahyuapp.myappmenubutton3x2.model.DataMenuMain;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MenuMainAdapter menuMainAdapter;

    @BindView(R.id.cv_profile)
    ImageView cvProfile;
    @BindView(R.id.tv_full_name)
    TextView tvFullName;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.rv_list_item)
    RecyclerView rvListItem;
    @BindView(R.id.srl_list_data)
    SwipeRefreshLayout srlListData;

    private int limitMenu = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // menu
        menuMainAdapter = new MenuMainAdapter();
        menuMainAdapter.notifyDataSetChanged();

        rvListItem.setHasFixedSize(true);
        showRecyclerList();
        loadMenu();
        // end menu

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();

        srlListData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                srlListData.setRefreshing(false);
            }
        });
    }

    private void loadData() {
        Glide.with(this).load(R.drawable.ic_default_profile).into(cvProfile);
        tvFullName.setText("Full Name");
        tvEmail.setText("Email");
    }

    private void loadMenu() {
        ArrayList<DataMenuMain> dataMenuMainList = new ArrayList<>();

        dataMenuMainList.addAll(SetDummyData.SetDataMenuMain(limitMenu));

        menuMainAdapter.setData(dataMenuMainList, MainActivity.this);
    }

    private void showRecyclerList() {
        rvListItem.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        rvListItem.setAdapter(menuMainAdapter);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
