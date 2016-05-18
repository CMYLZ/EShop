package cniao5.com.cniao5shop.db;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cniao5.com.cniao5shop.bean.User;

public class OrmDatabaseHelper extends OrmLiteSqliteOpenHelper {
	
	private static final String DATABASE_NAME = "sqlite.db";
	private static final int DATABASE_VERSION = 1;

	private final String DATABASE_PATH;

	private static List<Class<?>> sDBTClass;
	
	public OrmDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		DATABASE_PATH = "/data/data/" + context.getPackageName()
				+ "/databases/" + DATABASE_NAME;

	}
	
	public static void setDBTClass(List<Class<?>> classList) {
		sDBTClass = classList;
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			if(sDBTClass != null) {
				for(Class<?> clazz : sDBTClass) {
					TableUtils.createTable(getConnectionSource(), clazz);
				}
			}

			TableUtils.createTable(getConnectionSource(), User.class);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1,
			int oldVersion, int newVersion) {

	}

	public <T> Dao<T, Integer> getTDao(Class<T> clazz) {
		try {
			return getDao(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		super.close();
	}

}
