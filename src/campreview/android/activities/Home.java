package campreview.android.activities;

import android.app.Activity;
import android.os.Bundle;
import com.example.campreview_android.R;

public class Home extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}