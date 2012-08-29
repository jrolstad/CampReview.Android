package campreview.android.mappers;

import android.app.Activity;

public class StartActivityIntentRequest<T> {

    public Activity Context;
    public Class TargetActivity;
    public T Payload;
}
