package com.ijona.covid.data.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ijona.covid.data.database.model.Area;
import com.ijona.covid.data.database.model.CoronaEntity;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CoronaEntityDao_Impl implements CoronaEntityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CoronaEntity> __insertionAdapterOfCoronaEntity;

  private final EntityInsertionAdapter<Area> __insertionAdapterOfArea;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;

  public CoronaEntityDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCoronaEntity = new EntityInsertionAdapter<CoronaEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `corona_entity` (`id`,`country`,`confirmed`,`death`,`recovered`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoronaEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCountry() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCountry());
        }
        stmt.bindLong(3, value.getConfirmedNo());
        stmt.bindLong(4, value.getDeathNo());
        stmt.bindLong(5, value.getRecovered());
        stmt.bindDouble(6, value.getLatitude());
        stmt.bindDouble(7, value.getLongitude());
      }
    };
    this.__insertionAdapterOfArea = new EntityInsertionAdapter<Area>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `covid_area` (`id`,`display_name`,`total_confirmed`,`total_deaths`,`total_recovered`,`last_update`,`latitude`,`longitude`,`parent_id`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Area value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getDisplayName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDisplayName());
        }
        stmt.bindLong(3, value.getTotalConfirmed());
        stmt.bindLong(4, value.getTotalDeaths());
        stmt.bindLong(5, value.getTotalRecovered());
        if (value.getLastUpdated() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLastUpdated());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLongitude());
        }
        if (value.getParentId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getParentId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM corona_entity";
        return _query;
      }
    };
  }

  @Override
  public Object saveEntity(final List<CoronaEntity> t, final Continuation<? super List<Long>> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<List<Long>>() {
      @Override
      public List<Long> call() throws Exception {
        __db.beginTransaction();
        try {
          List<Long> _result = __insertionAdapterOfCoronaEntity.insertAndReturnIdsList(t);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object saveAllBingAreaDataForCorona(final List<Area> areaList,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfArea.insert(areaList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllData(final Continuation<? super Integer> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllData.acquire();
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllData.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public List<CoronaEntity> getAllData() {
    final String _sql = "SELECT * FROM corona_entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfConfirmedNo = CursorUtil.getColumnIndexOrThrow(_cursor, "confirmed");
      final int _cursorIndexOfDeathNo = CursorUtil.getColumnIndexOrThrow(_cursor, "death");
      final int _cursorIndexOfRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "recovered");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<CoronaEntity> _result = new ArrayList<CoronaEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CoronaEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        final int _tmpConfirmedNo;
        _tmpConfirmedNo = _cursor.getInt(_cursorIndexOfConfirmedNo);
        final int _tmpDeathNo;
        _tmpDeathNo = _cursor.getInt(_cursorIndexOfDeathNo);
        final int _tmpRecovered;
        _tmpRecovered = _cursor.getInt(_cursorIndexOfRecovered);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _item = new CoronaEntity(_tmpId,_tmpCountry,_tmpConfirmedNo,_tmpDeathNo,_tmpRecovered,_tmpLatitude,_tmpLongitude);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object fetchAllBingCovidArea(final Continuation<? super List<Area>> p0) {
    final String _sql = "SELECT * FROM covid_area";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Area>>() {
      @Override
      public List<Area> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_name");
          final int _cursorIndexOfTotalConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "total_confirmed");
          final int _cursorIndexOfTotalDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "total_deaths");
          final int _cursorIndexOfTotalRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "total_recovered");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_update");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_id");
          final List<Area> _result = new ArrayList<Area>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Area _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDisplayName;
            _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            final long _tmpTotalConfirmed;
            _tmpTotalConfirmed = _cursor.getLong(_cursorIndexOfTotalConfirmed);
            final long _tmpTotalDeaths;
            _tmpTotalDeaths = _cursor.getLong(_cursorIndexOfTotalDeaths);
            final long _tmpTotalRecovered;
            _tmpTotalRecovered = _cursor.getLong(_cursorIndexOfTotalRecovered);
            final String _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getString(_cursorIndexOfLastUpdated);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final String _tmpParentId;
            _tmpParentId = _cursor.getString(_cursorIndexOfParentId);
            _item = new Area(_tmpId,_tmpDisplayName,_tmpTotalConfirmed,_tmpTotalDeaths,_tmpTotalRecovered,_tmpLastUpdated,_tmpLatitude,_tmpLongitude,_tmpParentId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object fetchAllBingCovidAreaByAreaParentId(final String parentId,
      final Continuation<? super List<Area>> p1) {
    final String _sql = "SELECT * FROM covid_area WHERE parent_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentId);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<List<Area>>() {
      @Override
      public List<Area> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_name");
          final int _cursorIndexOfTotalConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "total_confirmed");
          final int _cursorIndexOfTotalDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "total_deaths");
          final int _cursorIndexOfTotalRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "total_recovered");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_update");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_id");
          final List<Area> _result = new ArrayList<Area>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Area _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDisplayName;
            _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            final long _tmpTotalConfirmed;
            _tmpTotalConfirmed = _cursor.getLong(_cursorIndexOfTotalConfirmed);
            final long _tmpTotalDeaths;
            _tmpTotalDeaths = _cursor.getLong(_cursorIndexOfTotalDeaths);
            final long _tmpTotalRecovered;
            _tmpTotalRecovered = _cursor.getLong(_cursorIndexOfTotalRecovered);
            final String _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getString(_cursorIndexOfLastUpdated);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final String _tmpParentId;
            _tmpParentId = _cursor.getString(_cursorIndexOfParentId);
            _item = new Area(_tmpId,_tmpDisplayName,_tmpTotalConfirmed,_tmpTotalDeaths,_tmpTotalRecovered,_tmpLastUpdated,_tmpLatitude,_tmpLongitude,_tmpParentId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
