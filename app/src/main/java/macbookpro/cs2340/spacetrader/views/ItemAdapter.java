package macbookpro.cs2340.spacetrader.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.MarketInfo;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private OnMarketInfoClickListener listener;

    /** a holder for the market data */

    private Map<MarketInfo, Integer> mapData;
    private MarketInfo[] mapKeys;
    private Integer[] mapValues;

    public ItemAdapter(Map<MarketInfo, Integer> data){
        mapData  = data;
        mapKeys = mapData.keySet().toArray(new MarketInfo[data.size()]);
        mapValues = mapData.values().toArray(new Integer[data.size()]);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.name.setText(mapKeys[position].getItem().getName());
        holder.price.setText(mapKeys[position].getPrice());
        holder.quantity.setText(mapValues[position]);
    }

    @Override
    public int getItemCount() {
        if (mapData == null) return 0;
        return mapData.size();
    }

    public void setMarketList(Map<MarketInfo, Integer> m) {
        mapData = m;
        notifyDataSetChanged();
    }

    public MarketInfo getMarketInfoAt (int position) {
        return mapKeys[position];
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
                        listener.onMarketInfoClicked(mapKeys[position]);
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
