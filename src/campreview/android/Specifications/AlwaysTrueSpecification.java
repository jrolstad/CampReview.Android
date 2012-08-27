package campreview.android.Specifications;


import campreview.android.Specifications.ISpecification;

public class AlwaysTrueSpecification<T> implements ISpecification<T> {

    @Override
    public boolean Matches(T item) {

        return true;
    }
}
