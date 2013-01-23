package campreview.android.data.database;

import android.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class OrmLiteDatabase extends OrmLiteSqliteOpenHelper implements IDaoFactory {

    private DatabaseMigrator migrator;


    public OrmLiteDatabase(Context context, DatabaseMigrator migrator) {
		super(context, migrator.getDatabaseName(), null, migrator.getDatabaseVersion());
        this.migrator = migrator;
    }

	/**
	 * This is called when the database is first created. Usually you should call createTable statements here to create
	 * the tables that will store your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            migrator.Migrate(connectionSource);
        } catch (SQLException e) {
            Log.e("Database","Database creation failed",e);
        }
    }

	/**
	 * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
	 * the various data to match the new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            migrator.Migrate(connectionSource);

        } catch (SQLException e) {
            Log.e("Database", "Database upgrade failed", e);
        }
	}

    public <T,I> Dao<T,I> buildDao(Class<T> dataClass) throws SQLException {
        return getDao(dataClass);
    }
}