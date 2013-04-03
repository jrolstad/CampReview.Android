package campreview.android.domain.data;

import campreview.android.domain.models.Campsite;
import com.j256.ormlite.dao.Dao;

import java.util.List;

public class CampsiteRepository {

    private Dao<Campsite, String> dao;

    public CampsiteRepository(Dao<Campsite, String> dao) {

        this.dao = dao;
    }

    public Campsite Get(String id) throws Exception {
        return dao.queryForId(id) ;
    }

    public List<Campsite> GetByCampground(String campgroundId) throws Exception {
        return dao.queryForEq("campgroundId",campgroundId);
    }

    public void Save(Campsite toSave) throws Exception {
        dao.createOrUpdate(toSave);
    }
}
