package com.ijona.covid.data.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.ijona.covid.data.database.dao.CoronaEntityDao;
import com.ijona.covid.data.database.dao.CoronaEntityDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CoronaEntityDao _coronaEntityDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `corona_entity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `country` TEXT NOT NULL, `confirmed` INTEGER NOT NULL, `death` INTEGER NOT NULL, `recovered` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `covid_area` (`id` TEXT NOT NULL, `display_name` TEXT NOT NULL, `total_confirmed` INTEGER NOT NULL, `total_deaths` INTEGER NOT NULL, `total_recovered` INTEGER NOT NULL, `last_update` TEXT, `latitude` REAL, `longitude` REAL, `parent_id` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fa9f61699f379a7a9ddb1b951590aad8')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `corona_entity`");
        _db.execSQL("DROP TABLE IF EXISTS `covid_area`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCoronaEntity = new HashMap<String, TableInfo.Column>(7);
        _columnsCoronaEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("confirmed", new TableInfo.Column("confirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("death", new TableInfo.Column("death", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("recovered", new TableInfo.Column("recovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoronaEntity.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCoronaEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCoronaEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCoronaEntity = new TableInfo("corona_entity", _columnsCoronaEntity, _foreignKeysCoronaEntity, _indicesCoronaEntity);
        final TableInfo _existingCoronaEntity = TableInfo.read(_db, "corona_entity");
        if (! _infoCoronaEntity.equals(_existingCoronaEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "corona_entity(com.ijona.covid.data.database.model.CoronaEntity).\n"
                  + " Expected:\n" + _infoCoronaEntity + "\n"
                  + " Found:\n" + _existingCoronaEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsCovidArea = new HashMap<String, TableInfo.Column>(9);
        _columnsCovidArea.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("display_name", new TableInfo.Column("display_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("total_confirmed", new TableInfo.Column("total_confirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("total_deaths", new TableInfo.Column("total_deaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("total_recovered", new TableInfo.Column("total_recovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("last_update", new TableInfo.Column("last_update", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCovidArea.put("parent_id", new TableInfo.Column("parent_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCovidArea = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCovidArea = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCovidArea = new TableInfo("covid_area", _columnsCovidArea, _foreignKeysCovidArea, _indicesCovidArea);
        final TableInfo _existingCovidArea = TableInfo.read(_db, "covid_area");
        if (! _infoCovidArea.equals(_existingCovidArea)) {
          return new RoomOpenHelper.ValidationResult(false, "covid_area(com.ijona.covid.data.database.model.Area).\n"
                  + " Expected:\n" + _infoCovidArea + "\n"
                  + " Found:\n" + _existingCovidArea);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fa9f61699f379a7a9ddb1b951590aad8", "d8aeecb53b3e187db6829a1f5761d731");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "corona_entity","covid_area");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `corona_entity`");
      _db.execSQL("DELETE FROM `covid_area`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CoronaEntityDao coronaDao() {
    if (_coronaEntityDao != null) {
      return _coronaEntityDao;
    } else {
      synchronized(this) {
        if(_coronaEntityDao == null) {
          _coronaEntityDao = new CoronaEntityDao_Impl(this);
        }
        return _coronaEntityDao;
      }
    }
  }
}
