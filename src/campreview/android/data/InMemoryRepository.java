package campreview.android.data;

import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository implements IRepository {

    private List<Object> _data = new ArrayList<Object>();

    public <T> List<T> Find(ISpecification<T> searchSpecifications) {
        List<T> returnList = new ArrayList<T>();

        for(Object value : _data){
            if(searchSpecifications.Matches(value)) {
                T typedValue = (T) value;
                returnList.add(typedValue);
             }
        }
        return returnList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public <T> T Get(ISpecification<T> getSpecification) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public <T> void Save(T itemToSave) {
        if(_data.contains(itemToSave))
            _data.remove(itemToSave);

        _data.add(itemToSave);
    }

    public <T> void Delete(T itemToDelete) {
        if(_data.contains(itemToDelete))
            _data.remove(itemToDelete);
    }
}
