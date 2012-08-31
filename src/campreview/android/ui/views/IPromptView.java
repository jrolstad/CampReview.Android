package campreview.android.ui.views;

import android.app.Activity;
import campreview.android.commands.ICommand;
import campreview.android.commands.requests.Request;
import campreview.android.commands.responses.Response;

public interface IPromptView {
    void show(Activity callingActivity, String prompt, ICommand<String, Response> successAction, ICommand<Request, Response> cancelAction);
}
