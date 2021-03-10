package com.wahyuapp.myappmenubutton3x2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wahyuapp.myappmenubutton3x2.model.DataMenuMain;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuMainAdapter extends RecyclerView.Adapter<MenuMainAdapter.ListViewHolder> {
    private ArrayList<DataMenuMain> listMenuUtama = new ArrayList<>();
    private Context mContext;
    private boolean doubleClickMenuPressedOnce = false;
    private long delayDoubleClickItem = 1 * 1000;

    void setData(ArrayList<DataMenuMain> list, Context mContext) {
        this.mContext = mContext;
        listMenuUtama.clear();
        listMenuUtama.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuMainAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_menu_utama, viewGroup, false);
        return new MenuMainAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuMainAdapter.ListViewHolder holder, final int position) {
        holder.bind(listMenuUtama.get(position));
    }

    @Override
    public int getItemCount() {
        return listMenuUtama.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_menu)
        ImageView ivMenu;
        @BindView(R.id.tv_menu)
        TextView tvMenu;
        @BindView(R.id.ll_main)
        LinearLayout llMain;

        ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final DataMenuMain dataMenuMain) {
            tvMenu.setText(dataMenuMain.getName());

            if (dataMenuMain.getId().equals("1")) {
                Glide.with(mContext).load(R.drawable.ic_manue_radio_presenter_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("2")) {
                Glide.with(mContext).load(R.drawable.ic_menu_customer_service_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("3")) {
                Glide.with(mContext).load(R.drawable.ic_menu_coach_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("4")) {
                Glide.with(mContext).load(R.drawable.ic_menu_it_support_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("5")) {
                Glide.with(mContext).load(R.drawable.ic_menu_firefighter_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("6")) {
                Glide.with(mContext).load(R.drawable.ic_menu_pilot_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("7")) {
                Glide.with(mContext).load(R.drawable.ic_menu_police_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("8")) {
                Glide.with(mContext).load(R.drawable.ic_menu_designer_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("9")) {
                Glide.with(mContext).load(R.drawable.ic_menu_eating_salad_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("10")) {
                Glide.with(mContext).load(R.drawable.ic_menu_eating_ice_cream_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("11")) {
                Glide.with(mContext).load(R.drawable.ic_menu_surfing_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("12")) {
                Glide.with(mContext).load(R.drawable.ic_menu_fornite_outline).into(ivMenu);
            } else if (dataMenuMain.getId().equals("99")) {
                Glide.with(mContext).load(R.drawable.ic_menu_data_analyst_outline).into(ivMenu);
            } else {
                Glide.with(mContext).load(R.drawable.ic_launcher_background).into(ivMenu);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (handleDoubleClick() && dataMenuMain.getActive().equals("1")) {
                        if (dataMenuMain.getId().equals("1")) {
                            Toast.makeText(mContext, dataMenuMain.getName(), Toast.LENGTH_LONG).show();
                        } else if (dataMenuMain.getId().equals("99")) {
                            Intent i = new Intent(mContext, MenuMainListActivity.class);
                            mContext.startActivity(i);
                        } else {
                            Toast.makeText(mContext, dataMenuMain.getName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            setBtn(dataMenuMain.getActive(), llMain);
        }
    }

    private void setBtn(String Active, LinearLayout ll_main) {
        if (Active.equals("1")) {
            ll_main.setBackground(mContext.getDrawable(R.drawable.round_item_white));
        } else {
            ll_main.setBackground(mContext.getDrawable(R.drawable.round_item_gray));
        }
    }

    private boolean handleDoubleClick() {
        if (doubleClickMenuPressedOnce) {
            return false;
        }
        doubleClickMenuPressedOnce = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleClickMenuPressedOnce = false;
            }
        }, delayDoubleClickItem);
        return true;
    }
}