package campreview.android.data;


import java.util.List;

public interface IRepository<T,I> {

    List<T> All();

    T Get(I identifier);

    void Save(T toSave);
}
