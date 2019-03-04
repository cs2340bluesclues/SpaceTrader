package macbookpro.cs2340.spacetrader.views;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import macbookpro.cs2340.spacetrader.model.MarketInfo;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    public List<MarketInfo> marketInfoList = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onItemViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);

        return new ItemViewHolder(itemView);
    })

    @Override
    public int getItemCount() {
        if (marketInfoList == null) {
            return 0;
        }
        return marketInfoList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView resourceName;
        private TextView quantity;
        private TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            resourceName = itemView.findViewById(R.id.text_resource_name);
            quantity = itemView.findViewById(R.id.text_quantity);
            price = itemView.findViewById(R.id.text_price);
        }

    }
}
