package campreview.android.data;

import campreview.android.Specifications.ISpecification;

import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository<T> implements IRepository<T> {

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

    public T Get(ISpecification<T> getSpecification) {
        List<T> results = Find(getSpecification);

        if(results.size() > 0)
        {
            return results.get(0);
        }
        else
        {
            return null;
        }
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
