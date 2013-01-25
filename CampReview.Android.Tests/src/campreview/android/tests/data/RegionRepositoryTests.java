package campreview.android.tests.data;

import android.content.Context;
import android.test.AndroidTestCase;
import campreview.android.data.RegionRepository;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.IDaoFactory;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.data.models.Region;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class RegionRepositoryTests extends AndroidTestCase {

    private RegionRepository _repository;
    private Dao<Region, String> _dao;

    public void setUp() throws Exception {
        Context context = getContext();
        ClearDatabase(context);

        IDaoFactory daoFactory = new OrmLiteDatabase(context,new DatabaseMigrator());
        _dao = daoFactory.buildDao(Region.class);
        _repository = new RegionRepository(_dao);

        CreateRegion("1", "Washington");
        CreateRegion("2", "Oregon");
        CreateRegion("3","Idaho");
    }

    private void ClearDatabase(Context context){
        context.deleteDatabase("campreview.db");
    }
    private void CreateRegion(String id, String name) throws Exception {
        Region region = new Region(id,name,1,2);
        _dao.createOrUpdate(region);
    }

    public void test_All_gets_all_regions() throws Exception {
        List<Region> allRegions = _repository.All();

        assertEquals(3,allRegions.size());
    }

    public void test_Get_gets_a_single_region() throws Exception {
        Region region = _repository.Get("2");

        assertEquals("Oregon",region.getName());

    }

    public void test_Save_saves_an_new_region() throws Exception {
        Region region = new Region("0","California",1,1);
        _repository.Save(region);

        List<Region> allRegions = _repository.All();

        assertEquals(4,allRegions.size());
    }
}
