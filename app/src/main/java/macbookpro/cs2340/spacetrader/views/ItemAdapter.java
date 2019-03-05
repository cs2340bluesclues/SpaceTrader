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

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.MarketItem;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    public List<MarketInfo> marketInfoList = new ArrayList<>();

    private OnMarketInfoClickListener listener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        MarketInfo item = marketInfoList.get(position);

        holder.price.setText(item.getPrice());
        holder.quantity.setText(item.getQuantity());
    }

    @Override
    public int getItemCount() {
        if (marketInfoList == null) {
            return 0;
        }
        return marketInfoList.size();
    }

    public void setMarketInfoList(List<MarketInfo> items) {
        marketInfoList = items;
        notifyDataSetChanged();
    }

    public MarketInfo getMarketInfo(int position) { return marketInfoList.get(position); }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView quantity;
        private TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_resource_name);
            quantity = itemView.findViewById(R.id.text_quantity);
            price = itemView.findViewById(R.id.text_price);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onMarketInfoClicked(marketInfoList.get(position));
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
