package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class TreatmentDao_Impl implements TreatmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTreatment;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTreatment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TreatmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTreatment = new EntityInsertionAdapter<Treatment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `treatment_table`(`mTreatmentID`,`treatment`,`description`,`isComplete`,`isRequired`,`priorityLevel`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Treatment value) {
        stmt.bindLong(1, value.getTreatmentID());
        if (value.getTreatment() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTreatment());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final Integer _tmp;
        _tmp = value.getIsComplete() == null ? null : (value.getIsComplete() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getIsRequired() == null ? null : (value.getIsRequired() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        stmt.bindDouble(6, value.getPriorityLevel());
      }
    };
    this.__updateAdapterOfTreatment = new EntityDeletionOrUpdateAdapter<Treatment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `treatment_table` SET `mTreatmentID` = ?,`treatment` = ?,`description` = ?,`isComplete` = ?,`isRequired` = ?,`priorityLevel` = ? WHERE `mTreatmentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Treatment value) {
        stmt.bindLong(1, value.getTreatmentID());
        if (value.getTreatment() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTreatment());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final Integer _tmp;
        _tmp = value.getIsComplete() == null ? null : (value.getIsComplete() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getIsRequired() == null ? null : (value.getIsRequired() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        stmt.bindDouble(6, value.getPriorityLevel());
        stmt.bindLong(7, value.getTreatmentID());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM treatment_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(Treatment treatment) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTreatment.insert(treatment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTreatments(Treatment... treatments) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTreatment.handleMultiple(treatments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Treatment>> getAllTreatments() {
    final String _sql = "SELECT * FROM treatment_table ORDER BY mTreatmentID ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Treatment>>() {
      private Observer _observer;

      @Override
      protected List<Treatment> compute() {
        if (_observer == null) {
          _observer = new Observer("treatment_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfMTreatmentID = _cursor.getColumnIndexOrThrow("mTreatmentID");
          final int _cursorIndexOfMTreatment = _cursor.getColumnIndexOrThrow("treatment");
          final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfMIsComplete = _cursor.getColumnIndexOrThrow("isComplete");
          final int _cursorIndexOfMIsRequired = _cursor.getColumnIndexOrThrow("isRequired");
          final int _cursorIndexOfMPriorityLevel = _cursor.getColumnIndexOrThrow("priorityLevel");
          final List<Treatment> _result = new ArrayList<Treatment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Treatment _item;
            final int _tmpMTreatmentID;
            _tmpMTreatmentID = _cursor.getInt(_cursorIndexOfMTreatmentID);
            final String _tmpMTreatment;
            _tmpMTreatment = _cursor.getString(_cursorIndexOfMTreatment);
            final String _tmpMDescription;
            _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
            final Boolean _tmpMIsComplete;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfMIsComplete)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfMIsComplete);
            }
            _tmpMIsComplete = _tmp == null ? null : _tmp != 0;
            final Boolean _tmpMIsRequired;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMIsRequired)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfMIsRequired);
            }
            _tmpMIsRequired = _tmp_1 == null ? null : _tmp_1 != 0;
            final double _tmpMPriorityLevel;
            _tmpMPriorityLevel = _cursor.getDouble(_cursorIndexOfMPriorityLevel);
            _item = new Treatment(_tmpMTreatmentID,_tmpMTreatment,_tmpMDescription,_tmpMIsComplete,_tmpMIsRequired,_tmpMPriorityLevel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Treatment>> getAllRequiredTreatments() {
    final String _sql = "SELECT * FROM treatment_table WHERE isRequired ORDER BY isComplete ASC, priorityLevel DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Treatment>>() {
      private Observer _observer;

      @Override
      protected List<Treatment> compute() {
        if (_observer == null) {
          _observer = new Observer("treatment_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfMTreatmentID = _cursor.getColumnIndexOrThrow("mTreatmentID");
          final int _cursorIndexOfMTreatment = _cursor.getColumnIndexOrThrow("treatment");
          final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfMIsComplete = _cursor.getColumnIndexOrThrow("isComplete");
          final int _cursorIndexOfMIsRequired = _cursor.getColumnIndexOrThrow("isRequired");
          final int _cursorIndexOfMPriorityLevel = _cursor.getColumnIndexOrThrow("priorityLevel");
          final List<Treatment> _result = new ArrayList<Treatment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Treatment _item;
            final int _tmpMTreatmentID;
            _tmpMTreatmentID = _cursor.getInt(_cursorIndexOfMTreatmentID);
            final String _tmpMTreatment;
            _tmpMTreatment = _cursor.getString(_cursorIndexOfMTreatment);
            final String _tmpMDescription;
            _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
            final Boolean _tmpMIsComplete;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfMIsComplete)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfMIsComplete);
            }
            _tmpMIsComplete = _tmp == null ? null : _tmp != 0;
            final Boolean _tmpMIsRequired;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMIsRequired)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfMIsRequired);
            }
            _tmpMIsRequired = _tmp_1 == null ? null : _tmp_1 != 0;
            final double _tmpMPriorityLevel;
            _tmpMPriorityLevel = _cursor.getDouble(_cursorIndexOfMPriorityLevel);
            _item = new Treatment(_tmpMTreatmentID,_tmpMTreatment,_tmpMDescription,_tmpMIsComplete,_tmpMIsRequired,_tmpMPriorityLevel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
