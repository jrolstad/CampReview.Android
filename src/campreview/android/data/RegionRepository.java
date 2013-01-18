package campreview.android.data;

import campreview.android.data.models.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionRepository {

    public Region Get(int id){
        return new Region();
    }

    public List<Region> All(){
        return new ArrayList<Region>();
    }

    public void Save(Region toSave){

    }

}
