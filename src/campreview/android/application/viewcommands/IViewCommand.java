package campreview.android.application.viewcommands;

public interface IViewCommand <I,O> {

    public O Execute(I request) throws Exception;

}
