package campreview.android.data;

import campreview.android.specifications.ISpecification;

import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository<T extends IEntity> implements IRepository<T> {

    private List<T> _data = new ArrayList<T>();

    public List<T> Find(ISpecification<T> searchSpecifications) {
        List<T> returnList = new ArrayList<T>();

        for(T value : _data){
            if(searchSpecifications.Matches(value)) {
                returnList.add(value);
             }
        }


        return returnList;
    }

    public T Get(String identifier) {
        for(T value : _data){
            if(value.getIdentifier() == identifier){
                return value;
            }
        }

        return null;
    }

    public void Save(T itemToSave) {
        if(_data.contains(itemToSave))
            _data.remove(itemToSave);

        _data.add(itemToSave);
    }

    public void Delete(T itemToDelete) {
        if(_data.contains(itemToDelete))
            _data.remove(itemToDelete);
    }
}
