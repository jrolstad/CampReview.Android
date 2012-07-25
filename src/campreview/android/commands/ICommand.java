package campreview.android.commands;

/**
 * Command interface
 * @param <Tin> Type of the request
 * @param <Tout> Type of the response
 */
public interface ICommand<Tin,Tout> {

    Tout Execute(Tin request);
}
