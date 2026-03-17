package hu.unideb.inf.shoppinglist3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemsActivity extends AppCompatActivity {

    public static final String ITEM = "ITEMKEY_for_reply_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_items);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleAddItem(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(ITEM, ((Button)view).getText().toString() );
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    private void displayColorFragment(){
        ColorFragment colorFragment = new ColorFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, colorFragment)
                .addToBackStack(null)
                .commit();
    }
}