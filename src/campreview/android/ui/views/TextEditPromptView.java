package campreview.android.ui.views;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.FrameLayout;
import campreview.android.commands.ICommand;
import campreview.android.commands.Request;
import campreview.android.commands.Response;

public class TextEditPromptView implements IPromptView {

    @Override
    public void show(Activity callingActivity, String prompt, final ICommand<String, Response> successAction, final ICommand<Request, Response> cancelAction)
    {
        final FrameLayout frameLayout = new FrameLayout(callingActivity);
        final EditText newRegionNameEditor = new EditText(callingActivity);
        newRegionNameEditor.setGravity(Gravity.CENTER);

        frameLayout.addView(newRegionNameEditor, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));

        newRegionNameEditor.setText("");
        new AlertDialog.Builder(callingActivity)
                .setView(frameLayout)
                .setTitle(prompt)
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        d.dismiss();
                        String inputValue = newRegionNameEditor.getText().toString();
                        successAction.Execute(inputValue);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        d.dismiss();
                        cancelAction.Execute(Request.Empty);
                    }
                }).create().show();

    }

}
