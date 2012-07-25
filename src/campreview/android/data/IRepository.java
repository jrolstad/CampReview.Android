package campreview.android.data;

import java.util.List;

/**
 * Generic interface implementation
 */
public interface IRepository {

    public <T> List<T> Find(ISpecification<T> searchSpecifications);

    public <T> T Get(ISpecification<T> getSpecification);

    public <T> void Save(T itemToSave);

    public <T> void Delete(T itemToDelete);
}
