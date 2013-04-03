package campreview.android.core.commands;

public interface ICommand<I,O> {

    public O Execute(I request) throws Exception;
}
