package campreview.android.data;

import campreview.android.data.models.Campsite;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class CampsiteRepository {

    private Dao<Campsite, String> dao;

    public CampsiteRepository(Dao<Campsite, String> dao) {

        this.dao = dao;
    }

    public Campsite Get(String id) throws SQLException {
        return dao.queryForId(id) ;
    }

    public List<Campsite> GetByCampground(String campgroundId) throws SQLException {
        return dao.queryForEq("campgroundId",campgroundId);
    }

    public void Save(Campsite toSave) throws SQLException {
        dao.createOrUpdate(toSave);
    }
}
