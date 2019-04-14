package macbookpro.cs2340.spacetrader.views;

//import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;

import java.util.Map;

import macbookpro.cs2340.spacetrader.R;
//import macbookpro.cs2340.spacetrader.model.GameDifficulty;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private OnMarketInfoClickListener listener;

    /** a holder for the market data */

    private Map<MarketInfo, Integer> mapData;
    private final MarketInfo[] mapKeys;
    private final Player player;
    private final Ship ship;
    private final Market market;
    private final Integer[] mapValues;
    private final boolean buying;

    ItemAdapter(Map<MarketInfo, Integer> data, boolean buy, Player p, Market m){
        mapData  = data;
        mapKeys = mapData.keySet().toArray(new MarketInfo[data.size()]);
        mapValues = mapData.values().toArray(new Integer[data.size()]);
        buying = buy;
        player = p;
        ship = p.getShip();
        market = m;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.name.setText(mapKeys[position].getItem().getName());
        holder.price.setText(String.valueOf(mapKeys[position].getPrice()));
        holder.quantity.setText(String.valueOf(mapValues[position]));
        if (buying) {
            holder.transaction.setText("Buy");
            holder.buyQuantityLabel.setText("Quantity to buy");
        } else {
            holder.transaction.setText("sell");
            holder.buyQuantityLabel.setText("Quantity to sell");
        }


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

        private final TextView name;
        private final TextView quantity;
        private final TextView price;

        private final TextView buyQuantityLabel;
        private final TextView buyQuantity;
        private final TextView totalPrice;
        private final Button transaction;
        private final Button decreaseQ;
        private final Button increaseQ;
        private int quantityToTrade;
        private int totalTradePrice;


        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_market_item_name);
            quantity = itemView.findViewById(R.id.text_quantity);
            price = itemView.findViewById(R.id.text_price);
            buyQuantityLabel = itemView.findViewById(R.id.text_quantity_desired);
            buyQuantity = itemView.findViewById(R.id.quantity_tracker);
            totalPrice = itemView.findViewById(R.id.text_total_price);

            transaction = itemView.findViewById(R.id.transaction_button);
            decreaseQ = itemView.findViewById(R.id.decrease_quantity_button);
            increaseQ = itemView.findViewById(R.id.increase_quantity_button);

            quantityToTrade = 0;
            totalTradePrice = 0;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onMarketInfoClicked(mapKeys[position]);
                    }
                }
            });

            increaseQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (quantityToTrade < mapValues[position]) {
                       if (buying && player.getCredits() >=
                               (quantityToTrade + 1) * mapKeys[position].getPrice()
                               && ship.getRemainingCargo() > quantityToTrade) {
                           Log.i("wedunnit!", "remaining cargo: " + ship.getRemainingCargo()+ " ");
                            quantityToTrade++;
                            totalTradePrice = quantityToTrade * mapKeys[position].getPrice();
                            buyQuantity.setText(Integer.toString (quantityToTrade));
                            totalPrice.setText(Integer.toString(totalTradePrice));
                       } else if (!buying) {
                           quantityToTrade++;
                           totalTradePrice = quantityToTrade * mapKeys[position].getPrice();
                           buyQuantity.setText(Integer.toString(quantityToTrade));
                           totalPrice.setText(Integer.toString(totalTradePrice));
                       }
                    }
                }
            });

            decreaseQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (quantityToTrade  > 0) {
                        quantityToTrade--;
                        totalTradePrice = quantityToTrade * mapKeys[position].getPrice();
                        buyQuantity.setText(Integer.toString(quantityToTrade));
                        totalPrice.setText(Integer.toString(totalTradePrice));
                    }
                }
            });


            transaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (buying && ship.getRemainingCargo() >= quantityToTrade) {
                        transaction(player, market, position, quantityToTrade);
                        quantity.setText(Integer.toString(mapData.get(mapKeys[position])));

                        quantityToTrade = 0;
                        totalTradePrice = 0;

                        buyQuantity.setText(Integer.toString(quantityToTrade));
                        totalPrice.setText(Integer.toString(totalTradePrice));

                    } else {
                        transaction(player, market, position, quantityToTrade);
                        quantity.setText(mapData.get(mapKeys[position]));

                        quantityToTrade = 0;
                        totalTradePrice = 0;

                        buyQuantity.setText(Integer.toString(quantityToTrade));
                        totalPrice.setText(Integer.toString(totalTradePrice));
                    }



                }
            });

        }
    }


    private void transaction(Player p, Market m, int position, int quantityToTrade) {
        if(buying) {
            p.buy(mapKeys[position], quantityToTrade);
            //m.buyAsPlayer(mapKeys[position], quantityToTrade);
        } else {
            p.sell(mapKeys[position], quantityToTrade);
            //m.sellAsPlayer(mapKeys[position]);
        }
    }
    public interface OnMarketInfoClickListener {
        void onMarketInfoClicked(MarketInfo marketInfo);
    }

    public void setOnMarketInfoClickListener(OnMarketInfoClickListener listener) {
        this.listener = listener;
    }


}
