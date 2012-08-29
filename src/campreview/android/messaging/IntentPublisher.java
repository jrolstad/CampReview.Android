package campreview.android.messaging;

import android.app.Activity;
import android.content.Intent;

public class IntentPublisher implements IIntentPublisher {
    @Override
    public void PublishStartActivity(Activity context, Intent intent) {
        context.startActivity(intent);
    }
}
