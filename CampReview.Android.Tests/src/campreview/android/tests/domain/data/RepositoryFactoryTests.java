package campreview.android.tests.domain.data;

import android.test.AndroidTestCase;
import campreview.android.domain.data.CampgroundRepository;
import campreview.android.domain.data.CampsiteRepository;
import campreview.android.domain.data.RegionRepository;
import campreview.android.domain.data.RepositoryFactory;
import campreview.android.domain.data.database.DatabaseMigrator;
import campreview.android.domain.data.database.OrmLiteDatabase;

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
