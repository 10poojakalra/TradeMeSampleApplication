package com.greencode.sampleapplicationsecond.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.greencode.sampleapplicationsecond.R;
import com.greencode.sampleapplicationsecond.adapter.ProductListAdapter;
import com.greencode.sampleapplicationsecond.interfaces.RecyclerViewClickListener;
import com.greencode.sampleapplicationsecond.model.Products;
import com.greencode.sampleapplicationsecond.response.ServiceResponse;
import com.greencode.sampleapplicationsecond.retrofitAPI.ApiClient;
import com.greencode.sampleapplicationsecond.retrofitAPI.ApiInterface;
import com.greencode.sampleapplicationsecond.utils.MyDialog;
import com.greencode.sampleapplicationsecond.utils.SortItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverFragment extends Fragment implements RecyclerViewClickListener {

    List<Products> latestList;
    MyDialog dialog;
    RecyclerView rvProducts;
    View v;

    public DiscoverFragment() {
    }


   /* public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
        return fragment;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_discover, container, false);
        initializeControls(v);
        callLatestList();
        return v;
    }

    private void initializeControls(View v) {
        dialog = new MyDialog(getActivity());
        rvProducts = v.findViewById(R.id.rvProducts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvProducts.setLayoutManager(linearLayoutManager);
    }

    private void callLatestList() {
        try {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<ServiceResponse> call = apiInterface.latestProductList();
            call.enqueue(new Callback<ServiceResponse>() {
                @Override
                public void onResponse(@NonNull Call<ServiceResponse> call, @NonNull Response<ServiceResponse> response) {
                    dialog.close();
                    latestList = new ArrayList<>();
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        latestList = response.body().getLatestList();
                        if (latestList != null && latestList.size() > 0)
                            bindLatestList();
                    } else
                        setNoDataView(true, response.message());
                }

                @Override
                public void onFailure(@NonNull Call<ServiceResponse> call, @NonNull Throwable t) {
                    dialog.close();
                    setNoDataView(latestList.size() == 0, "Fail to get data");
                }
            });
        } catch (Exception e1) {

        }
    }

    private void bindLatestList() {
        rvProducts.setVisibility(View.VISIBLE);
        //TODO Update when date resolve
        // Collections.sort(latestList, new SortItems());
        ProductListAdapter adapter = new ProductListAdapter(getActivity(), latestList, this);
        rvProducts.setAdapter(adapter);
        setNoDataView(latestList.size() == 0,
                getResources().getString(R.string.data_not_found));
    }

    private void setNoDataView(boolean flag, String message) {
        TextView lbl_data_not_found_ = v.findViewById(R.id.lbl_data_not_found_);
        lbl_data_not_found_.setText(message);

        RelativeLayout ll = v.findViewById(R.id.ll_no_token);
        ll.setVisibility(flag ? View.VISIBLE : View.GONE);
        rvProducts.setVisibility(flag ? View.GONE : View.VISIBLE);
    }

    @Override
    public void recycleViewListClicked(View v, int position) {
        if (v.getId() == R.id.itemCard) {
            Toast.makeText(getActivity(), "Clicked on : " + latestList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        }
    }
}