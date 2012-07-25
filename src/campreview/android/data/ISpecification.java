package campreview.android.data;

/**
 * Created with IntelliJ IDEA.
 * User: rolstad
 * Date: 7/25/12
 * Time: 7:03 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ISpecification<T> {

    boolean Matches(Object item);
}

