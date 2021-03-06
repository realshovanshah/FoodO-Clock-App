package com.example.coursework.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework.R;
import com.example.coursework.model.Menu;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChineseAdapter extends RecyclerView.Adapter<ChineseAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Menu> foodList;

    public ChineseAdapter(Context mCtx, List<Menu> foodList) {
        this.mCtx = mCtx;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view= inflater.inflate(R.layout.chinese_list, null);
        ProductViewHolder holder = new ProductViewHolder(view);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
    //Bind data
        Menu foodlist = foodList.get(position);

        holder.textViewTitle.setText(foodlist.getTitle());
        holder.textViewPrice.setText(String.valueOf(foodlist.getPrice()));
        Picasso.with(mCtx).load(foodlist.getImage()).placeholder(R.drawable.burger).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return foodList.size(); //size of the list
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle, textViewPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
