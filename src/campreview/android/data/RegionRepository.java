package campreview.android.data;

import campreview.android.data.models.Region;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepository {

    private Dao<Region, String> dao;

    public RegionRepository(Dao<Region, String> dao) {

        this.dao = dao;
    }

    public Region Get(String id) throws SQLException {
        return dao.queryForId(id) ;
    }

    public List<Region> All() throws SQLException {
        return dao.queryForAll();
    }

    public void Save(Region toSave) throws SQLException {
        dao.createOrUpdate(toSave);
    }

}