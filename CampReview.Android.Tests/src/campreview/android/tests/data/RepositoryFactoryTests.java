package campreview.android.tests.data;

import android.test.AndroidTestCase;
import campreview.android.data.CampgroundRepository;
import campreview.android.data.CampsiteRepository;
import campreview.android.data.RegionRepository;
import campreview.android.data.RepositoryFactory;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.OrmLiteDatabase;

import java.sql.SQLException;

public class RepositoryFactoryTests extends AndroidTestCase {

    private RepositoryFactory _factory;

    public void setUp(){
        _factory = new RepositoryFactory(new OrmLiteDatabase(this.getContext(),new DatabaseMigrator()));
    }

    public void test_RegionRepository_gets_the_instance() throws Exception {
        RegionRepository repository = _factory.RegionRepository();

        assertNotNull(repository);
    }

    public void test_CampgroundRepository_gets_the_instance() throws Exception {
        CampgroundRepository repository = _factory.CampgroundRepository();

        assertNotNull(repository);
    }

    public void test_CampsiteRepository_gets_the_instance() throws Exception {
        CampsiteRepository repository = _factory.CampsiteRepository();

        assertNotNull(repository);
    }
}
