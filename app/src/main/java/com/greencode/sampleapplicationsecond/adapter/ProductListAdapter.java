package com.greencode.sampleapplicationsecond.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greencode.sampleapplicationsecond.R;
import com.greencode.sampleapplicationsecond.interfaces.RecyclerViewClickListener;
import com.greencode.sampleapplicationsecond.model.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.TransactionListHolder> {
    private Context context;
    private List<Products> productsList;
    private RecyclerViewClickListener listener;

    public ProductListAdapter(Context context, List<Products> productsList, RecyclerViewClickListener listener) {
        this.productsList = productsList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TransactionListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_view, parent, false);
        return new TransactionListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionListHolder holder, final int position) {
        try {
            final Products productObj = productsList.get(position);
            holder.lblLocation.setText(productObj.getRegion());
            holder.lblTitle.setText(productObj.getTitle());
            if (productObj.getPictureHref() != null) {
                Picasso.get().load(productObj.getPictureHref()).into(holder.imgProduct);
            }
            if (productObj.getClassified()) {
                holder.lblPrice.setText
                        (productObj.getPriceDisplay());
                holder.llPriceLeft.setVisibility(View.GONE);
            } else {
                holder.llPriceLeft.setVisibility(View.VISIBLE);
                holder.lblPrice.setText(productObj.getPriceDisplay());
                holder.lblCurrentPrice.setText
                        (String.format("%s %s", context.getResources().getString(R.string.dollar_sign)
                                , String.valueOf(productObj.getBuyNowPrice() != null ? productObj.getBuyNowPrice() : "")));
                holder.lblCurrentPriceTitle.setVisibility
                        (productObj.getBuyNowPrice() != null ? View.VISIBLE : View.GONE);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class TransactionListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView lblLocation, lblTitle, lblCurrentPrice, lblCurrentPriceTitle, lblPrice, lblPriceTitle;
        ImageView imgProduct;
        LinearLayout llPriceLeft, llPriceRight;

        TransactionListHolder(View itemView) {
            super(itemView);
            lblLocation = itemView.findViewById(R.id.lblLocation);
            lblTitle = itemView.findViewById(R.id.lblTitle);
            lblCurrentPrice = itemView.findViewById(R.id.lblCurrentPrice);
            lblCurrentPriceTitle = itemView.findViewById(R.id.lblCurrentPriceTitle);
            lblPrice = itemView.findViewById(R.id.lblPrice);
            lblPriceTitle = itemView.findViewById(R.id.lblPriceTitle);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            llPriceLeft = itemView.findViewById(R.id.llPriceLeft);
            llPriceRight = itemView.findViewById(R.id.llPriceRight);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.recycleViewListClicked(view, getBindingAdapterPosition());
        }
    }
}
