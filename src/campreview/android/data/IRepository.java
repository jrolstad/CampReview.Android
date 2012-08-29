package campreview.android.data;

import campreview.android.specifications.ISpecification;

import java.util.List;

/**
 * Generic interface implementation
 */
public interface IRepository<T extends IEntity> {

    public List<T> Find(ISpecification<T> searchSpecifications);

    public T Get(String identifier);

    public void Save(T itemToSave);

    public void Delete(T itemToDelete);
}
