package campreview.android.ui.views;

import android.app.Activity;
import android.widget.Toast;

public class ToastMessageView implements IMessageView {
    @Override
    public void show(Activity context, String message){

        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
