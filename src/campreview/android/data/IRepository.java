package campreview.android.data;


import java.util.List;

public interface IRepository<T,I> {

    List<T> All() throws Exception;

    T Get(I identifier) throws Exception;

    void Save(T toSave) throws Exception;
}
