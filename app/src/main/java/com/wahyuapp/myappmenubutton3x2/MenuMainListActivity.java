package com.wahyuapp.myappmenubutton3x2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wahyuapp.myappmenubutton3x2.model.DataMenuMain;

import java.util.ArrayList;

public class MenuMainListActivity extends AppCompatActivity {

    private MenuMainAdapter menuMainAdapter;
    private RecyclerView rvListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("All Menu");
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        menuMainAdapter = new MenuMainAdapter();
        menuMainAdapter.notifyDataSetChanged();
        rvListItem = findViewById(R.id.rv_list_item);
        rvListItem.setHasFixedSize(true);
        showRecyclerList();

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        final SwipeRefreshLayout srlListData = findViewById(R.id.srl_list_data);
        srlListData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                srlListData.setRefreshing(false);
            }
        });
    }

    private void loadData() {
        ArrayList<DataMenuMain> dataMenuMainList = new ArrayList<>();

        dataMenuMainList.addAll(SetDummyData.SetDataMenuMain(0));

        menuMainAdapter.setData(dataMenuMainList, MenuMainListActivity.this);
    }

    private void showRecyclerList() {
        rvListItem.setLayoutManager(new GridLayoutManager(MenuMainListActivity.this, 3));
        rvListItem.setAdapter(menuMainAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
