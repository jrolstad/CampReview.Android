package campreview.android.domain.data.database;

import campreview.android.domain.models.Campground;
import campreview.android.domain.models.Campsite;
import campreview.android.domain.models.Region;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseMigrator {

    private static final String DATABASE_NAME = "campreview.db";
    private static final int DATABASE_VERSION = 1;

    public void Migrate(ConnectionSource connectionSource) throws SQLException {

        if(getDatabaseVersion()<=1)
            Version1(connectionSource);
    }



    private void Version1(ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Region.class);
        TableUtils.createTableIfNotExists(connectionSource, Campground.class);
        TableUtils.createTableIfNotExists(connectionSource, Campsite.class);
    }

    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
