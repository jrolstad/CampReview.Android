package campreview.android.data;

import campreview.android.Specifications.ISpecification;

import java.util.List;

/**
 * Generic interface implementation
 */
public interface IRepository<T> {

    public List<T> Find(ISpecification<T> searchSpecifications);

    public T Get(ISpecification<T> getSpecification);

    public void Save(T itemToSave);

    public void Delete(T itemToDelete);
}
