package campreview.android.specifications;


public class AlwaysTrueSpecification<T> implements ISpecification<T> {

    @Override
    public boolean Matches(T item) {

        return true;
    }
}
