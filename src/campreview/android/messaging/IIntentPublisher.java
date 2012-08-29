package campreview.android.messaging;

import android.app.Activity;
import android.content.Intent;

public interface IIntentPublisher {
    void PublishStartActivity(Activity context, Intent intent);
}
