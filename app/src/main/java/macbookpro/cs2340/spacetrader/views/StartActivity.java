package macbookpro.cs2340.spacetrader.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

//import macbookpro.cs2340.spacetrader.model.Player;

/**
 * Activity class for the start screen
 */
@SuppressLint("Registered")
public class StartActivity extends AppCompatActivity {

    private Button newGame;
    private Button loadGame;
    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);


        newGame = findViewById(R.id.new_game_button);
        loadGame = findViewById(R.id.load_button);
        nameInput = findViewById(R.id.input_name);

        newGame.setOnClickListener(v -> {

            Intent intent = new Intent(StartActivity.this, ConfigurationActivity.class);
            startActivity(intent);
        });
        loadGame.setOnClickListener(new View.OnClickListener() {
            String name = nameInput.getText().toString();
            @Override
            public void onClick(View v) {
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference ref = database.getReference();
//                DatabaseReference playerNameRef = ref.child("players");
//                Query queries = playerNameRef.orderByChild("name").equalTo(name);
//
//                ValueEventListener eventListener =
//                  ref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Player player = dataSnapshot.getValue(Player.class);
//                        System.out.println(player);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        System.out.println("The read failed: " + databaseError.getCode());
//                    }
//                });
//                queries.addListenerForSingleValueEvent(eventListener);
//                Intent intent = new Intent(StartActivity.this, MarketActivity.class);
//                startActivity(intent);
            }
        });

    }
}

