package campreview.android.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class RegionCampgroundListActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = getIntent().getStringExtra("region_id");

        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
    }
}