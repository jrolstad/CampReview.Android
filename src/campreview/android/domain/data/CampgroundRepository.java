package campreview.android.domain.data;

import campreview.android.domain.models.Campground;
import com.j256.ormlite.dao.Dao;

import java.util.List;

public class CampgroundRepository {

    private Dao<Campground, String> dao;

    public CampgroundRepository(Dao<Campground,String> dao){

        this.dao = dao;
    }
    public Campground Get(String id) throws Exception {
        return dao.queryForId(id);
    }

    public List<Campground> GetByRegion(int regionId) throws Exception {
        return dao.queryForEq("regionId",regionId);
    }

    public void Save(Campground toSave) throws Exception {
        dao.createOrUpdate(toSave);
    }
}
