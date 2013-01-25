package campreview.android.tests.data;

import android.content.Context;
import android.test.AndroidTestCase;
import campreview.android.data.CampgroundRepository;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.IDaoFactory;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.data.models.Campground;
import campreview.android.data.models.Region;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CampgroundRepositoryTests extends AndroidTestCase {

    private CampgroundRepository _repository;
    private Dao<Campground, String> _dao;

    public void setUp() throws Exception {
        Context context = this.getContext();

        ClearDatabase(context);

        IDaoFactory daoFactory = new OrmLiteDatabase(context,new DatabaseMigrator());
        _dao = daoFactory.buildDao(Campground.class);

        _repository = new CampgroundRepository(_dao);

        CreateCampground("1", "100", "Rasar State Park");
        CreateCampground("2","100","Larrabee State Park");
        CreateCampground("3","200","South Beach State Park");
    }

    private void ClearDatabase(Context context) {
        context.deleteDatabase("campreview.db");
    }

    private void CreateCampground(String id, String regionId, String name) throws Exception {
        Campground campground = new Campground(id,name,regionId,1,2,3);
        _dao.createOrUpdate(campground);
    }

    public void test_GetByRegion_gets_all_campgrounds_in_a_region() throws Exception {
        List<Campground> campgroundsInRegion = _repository.GetByRegion(100);

        assertEquals(2,campgroundsInRegion.size());
    }

    public void test_Get_gets_a_single_campground() throws Exception {
        Campground campground = _repository.Get("2");

        assertEquals("Larrabee State Park",campground.getName());

    }

    public void test_Save_saves_an_new_campground() throws Exception {
        String id = UUID.randomUUID().toString();
        Campground campground = new Campground(id,"Nehalem Bay","200",3,1,1);
        _repository.Save(campground);

        List<Campground> campgroundsInRegion = _repository.GetByRegion(200);

        assertEquals(2,campgroundsInRegion.size());
    }
}