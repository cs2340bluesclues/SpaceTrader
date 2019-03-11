package macbookpro.cs2340.spacetrader.views;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{


    private OnMarketInfoClickListener listener;

    /** a holder for the market data */
    private List<Pair<MarketInfo, Integer>> list;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.name.setText(list.get(position).first.getPrice());
        holder.price.setText(list.get(position).first.getPrice());
        holder.quantity.setText(list.get(position).second);
    }


    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    public void setMarketList(List<Pair<MarketInfo, Integer>> l) {
        list = l;
        notifyDataSetChanged();
    }

    public MarketInfo getMarketInfoAt (int position) {
        return list.get(position).first;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView quantity;
        private TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_market_item_name);
            quantity = itemView.findViewById(R.id.text_quantity);
            price = itemView.findViewById(R.id.text_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onMarketInfoClicked(list.get(position).first);
                    }
                }
            });
        }
    }

    public interface OnMarketInfoClickListener {
        void onMarketInfoClicked(MarketInfo marketInfo);
    }

    public void setOnMarketInfoClickListener(OnMarketInfoClickListener listener) {
        this.listener = listener;
    }
}
