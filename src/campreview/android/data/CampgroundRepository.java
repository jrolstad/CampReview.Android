package campreview.android.data;

import campreview.android.data.models.Campground;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class CampgroundRepository {

    private Dao<Campground, String> dao;

    public CampgroundRepository(Dao<Campground,String> dao){

        this.dao = dao;
    }
    public Campground Get(String id) throws SQLException {
        return dao.queryForId(id);
    }

    public List<Campground> GetByRegion(int regionId) throws SQLException {
        return dao.queryForEq("regionId",regionId);
    }

    public void Save(Campground toSave) throws SQLException {
        dao.createOrUpdate(toSave);
    }
}
