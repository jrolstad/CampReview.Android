package campreview.android.data;

import campreview.android.data.database.IDaoFactory;
import campreview.android.data.models.Campground;
import campreview.android.data.models.Campsite;
import campreview.android.data.models.Region;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class RepositoryFactory {

    private IDaoFactory daoFactory;

    public RepositoryFactory(IDaoFactory daoFactory){

        this.daoFactory = daoFactory;
    }

    public CampgroundRepository CampgroundRepository() throws SQLException {

        Dao<Campground,String> dao = daoFactory.buildDao(Campground.class);
        CampgroundRepository repository = new CampgroundRepository(dao);

        return repository;
    }

    public CampsiteRepository CampsiteRepository() throws Exception {

        Dao<Campsite,String> dao = daoFactory.buildDao(Campsite.class);
        CampsiteRepository repository = new CampsiteRepository(dao);

        return repository;
    }

    public RegionRepository RegionRepository() throws Exception {

            Dao<Region,String> dao = daoFactory.buildDao(Region.class);
            RegionRepository repository = new RegionRepository(dao);

            return repository;
        }
}
