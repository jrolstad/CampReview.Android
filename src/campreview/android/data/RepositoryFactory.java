package campreview.android.data;

import campreview.android.data.database.IDaoFactory;
import campreview.android.data.models.Campground;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class RepositoryFactory {

    private IDaoFactory daoFactory;

    public RepositoryFactory(IDaoFactory daoFactory){

        this.daoFactory = daoFactory;
    }
    public CampgroundRepository BuildCampgroundRepository() throws SQLException {

        Dao<Campground,String> dao = daoFactory.buildDao(Campground.class);
        CampgroundRepository repository = new CampgroundRepository(dao);

        return repository;
    }
}
