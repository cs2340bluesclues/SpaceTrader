package macbookpro.cs2340.spacetrader.views;

import android.os.Bundle;
import macbookpro.cs2340.spacetrader.R;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;

import macbookpro.cs2340.spacetrader.model.MarketInfo;

/**
 * Activity class for Item details within cargo and market
 */
public class ItemDetailActivity extends AppCompatActivity {

    private String name;
    private int quantity;


    private EditText nameField;
    private EditText quantityField;
    private EditText priceField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_item);

        MarketInfo marketInfo;
        nameField.findViewById(R.id.text_market_item_name);
        quantityField.findViewById(R.id.text_quantity);
        priceField.findViewById(R.id.text_price);
        Button transactionButton = findViewById(R.id.transaction_button);

        if (getIntent().hasExtra(MarketActivity.EXTRA_ITEM)) {
            marketInfo = (MarketInfo) getIntent().getSerializableExtra(MarketActivity.EXTRA_ITEM);
        } else {
            Log.d("APP", "INTERNAL ERROR< NO ITEM PASSED");
        }
    }

}
