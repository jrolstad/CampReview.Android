package campreview.android.domain.data.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public interface IDaoFactory {

    <T,I> Dao<T,I> buildDao(Class<T> dataClass) throws SQLException;
}
