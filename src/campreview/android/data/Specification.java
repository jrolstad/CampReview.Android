package campreview.android.data;


public class Specification<T> implements ISpecification<T> {
    private Class<T> underlyingClass;

    @Override
    public boolean Matches(Object item) {

        return item.getClass() == underlyingClass;
    }

    public Specification(Class<T> className){

        underlyingClass = className;
    }
}
