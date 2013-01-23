package campreview.android.tests.data;

import android.content.Context;
import android.test.AndroidTestCase;
import campreview.android.data.CampsiteRepository;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.IDaoFactory;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.data.models.Campsite;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class CampsiteRepositoryTests extends AndroidTestCase {

    private CampsiteRepository _repository;
    private Dao<Campsite, String> _dao;

    public void setUp() throws SQLException {
        Context context = getContext();
        ClearDatabase(context);

        IDaoFactory daoFactory = new OrmLiteDatabase(context,new DatabaseMigrator());
        _dao = daoFactory.buildDao(Campsite.class);
        _repository = new CampsiteRepository(_dao);

        CreateCampsite("1","1","F1");
        CreateCampsite("1","2","A4");
        CreateCampsite("2","3","Yurt 5");

    }

    private void CreateCampsite(String campgroundId, String campsiteId, String name) throws SQLException {
        Campsite campsite = new Campsite(campsiteId,name,campgroundId,1,2,3);
        _dao.createOrUpdate(campsite);
    }

    private void ClearDatabase(Context context){
         context.deleteDatabase("campreview.db");
    }

    public void test_GetByCampground_gets_all_campsites_in_a_campground() throws SQLException {
        List<Campsite> campsites = _repository.GetByCampground("1");

        assertEquals(2, campsites.size());
    }

    public void test_Get_gets_a_single_campsite() throws SQLException {
        Campsite campsite = _repository.Get("2");

        assertEquals("A4", campsite.getName());

    }

    public void test_Save_saves_an_new_campground() throws SQLException {
        Campsite campsite = new Campsite("0","Cabin 2","1",3,1,1);
        _repository.Save(campsite);

        List<Campsite> campsites = _repository.GetByCampground("1");

        assertEquals(3, campsites.size());
    }
}
