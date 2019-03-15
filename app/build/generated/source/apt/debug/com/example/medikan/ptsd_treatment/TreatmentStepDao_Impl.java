package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
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
public class TreatmentStepDao_Impl implements TreatmentStepDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTreatmentStep;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TreatmentStepDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTreatmentStep = new EntityInsertionAdapter<TreatmentStep>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `treatment_step_table`(`mTreatmentStepID`,`treatmentStep`,`description`,`longInstruction`,`shortInstruction`,`timerValue`,`isComplete`,`isRequired`,`priorityLevel`,`treatmentID`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TreatmentStep value) {
        stmt.bindLong(1, value.getTreatmentStepID());
        if (value.getTreatmentStep() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTreatmentStep());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getLongInstruction() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLongInstruction());
        }
        if (value.getShortInstruction() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getShortInstruction());
        }
        stmt.bindLong(6, value.getTimerValue());
        final Integer _tmp;
        _tmp = value.getIsComplete() == null ? null : (value.getIsComplete() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getIsRequired() == null ? null : (value.getIsRequired() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_1);
        }
        stmt.bindDouble(9, value.getPriorityLevel());
        stmt.bindLong(10, value.getTreatmentID());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM treatment_step_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(TreatmentStep treatmentStep) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTreatmentStep.insert(treatmentStep);
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
  public LiveData<List<TreatmentStep>> getAllTreatmentSteps() {
    final String _sql = "SELECT * FROM treatment_step_table ORDER BY mTreatmentStepID ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<TreatmentStep>>() {
      private Observer _observer;

      @Override
      protected List<TreatmentStep> compute() {
        if (_observer == null) {
          _observer = new Observer("treatment_step_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfMTreatmentStepID = _cursor.getColumnIndexOrThrow("mTreatmentStepID");
          final int _cursorIndexOfMTreatmentStep = _cursor.getColumnIndexOrThrow("treatmentStep");
          final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfMLongInstruction = _cursor.getColumnIndexOrThrow("longInstruction");
          final int _cursorIndexOfMShortInstruction = _cursor.getColumnIndexOrThrow("shortInstruction");
          final int _cursorIndexOfMTimerValue = _cursor.getColumnIndexOrThrow("timerValue");
          final int _cursorIndexOfMIsComplete = _cursor.getColumnIndexOrThrow("isComplete");
          final int _cursorIndexOfMIsRequired = _cursor.getColumnIndexOrThrow("isRequired");
          final int _cursorIndexOfMPriorityLevel = _cursor.getColumnIndexOrThrow("priorityLevel");
          final int _cursorIndexOfMTreatmentID = _cursor.getColumnIndexOrThrow("treatmentID");
          final List<TreatmentStep> _result = new ArrayList<TreatmentStep>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TreatmentStep _item;
            final int _tmpMTreatmentStepID;
            _tmpMTreatmentStepID = _cursor.getInt(_cursorIndexOfMTreatmentStepID);
            final String _tmpMTreatmentStep;
            _tmpMTreatmentStep = _cursor.getString(_cursorIndexOfMTreatmentStep);
            final String _tmpMDescription;
            _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
            final String _tmpMLongInstruction;
            _tmpMLongInstruction = _cursor.getString(_cursorIndexOfMLongInstruction);
            final String _tmpMShortInstruction;
            _tmpMShortInstruction = _cursor.getString(_cursorIndexOfMShortInstruction);
            final int _tmpMTimerValue;
            _tmpMTimerValue = _cursor.getInt(_cursorIndexOfMTimerValue);
            final double _tmpMPriorityLevel;
            _tmpMPriorityLevel = _cursor.getDouble(_cursorIndexOfMPriorityLevel);
            final int _tmpMTreatmentID;
            _tmpMTreatmentID = _cursor.getInt(_cursorIndexOfMTreatmentID);
            _item = new TreatmentStep(_tmpMTreatmentStepID,_tmpMTreatmentStep,_tmpMDescription,_tmpMLongInstruction,_tmpMShortInstruction,_tmpMTimerValue,_tmpMPriorityLevel,_tmpMTreatmentID);
            final Boolean _tmpMIsComplete;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfMIsComplete)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfMIsComplete);
            }
            _tmpMIsComplete = _tmp == null ? null : _tmp != 0;
            _item.setIsComplete(_tmpMIsComplete);
            final Boolean _tmpMIsRequired;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMIsRequired)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfMIsRequired);
            }
            _tmpMIsRequired = _tmp_1 == null ? null : _tmp_1 != 0;
            _item.setIsRequired(_tmpMIsRequired);
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
  public LiveData<List<TreatmentStep>> getSpecificTreatmentSteps(int treatmentID) {
    final String _sql = "SELECT * FROM treatment_step_table WHERE treatmentID = (?) ORDER BY mTreatmentStepID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, treatmentID);
    return new ComputableLiveData<List<TreatmentStep>>() {
      private Observer _observer;

      @Override
      protected List<TreatmentStep> compute() {
        if (_observer == null) {
          _observer = new Observer("treatment_step_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfMTreatmentStepID = _cursor.getColumnIndexOrThrow("mTreatmentStepID");
          final int _cursorIndexOfMTreatmentStep = _cursor.getColumnIndexOrThrow("treatmentStep");
          final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfMLongInstruction = _cursor.getColumnIndexOrThrow("longInstruction");
          final int _cursorIndexOfMShortInstruction = _cursor.getColumnIndexOrThrow("shortInstruction");
          final int _cursorIndexOfMTimerValue = _cursor.getColumnIndexOrThrow("timerValue");
          final int _cursorIndexOfMIsComplete = _cursor.getColumnIndexOrThrow("isComplete");
          final int _cursorIndexOfMIsRequired = _cursor.getColumnIndexOrThrow("isRequired");
          final int _cursorIndexOfMPriorityLevel = _cursor.getColumnIndexOrThrow("priorityLevel");
          final int _cursorIndexOfMTreatmentID = _cursor.getColumnIndexOrThrow("treatmentID");
          final List<TreatmentStep> _result = new ArrayList<TreatmentStep>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TreatmentStep _item;
            final int _tmpMTreatmentStepID;
            _tmpMTreatmentStepID = _cursor.getInt(_cursorIndexOfMTreatmentStepID);
            final String _tmpMTreatmentStep;
            _tmpMTreatmentStep = _cursor.getString(_cursorIndexOfMTreatmentStep);
            final String _tmpMDescription;
            _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
            final String _tmpMLongInstruction;
            _tmpMLongInstruction = _cursor.getString(_cursorIndexOfMLongInstruction);
            final String _tmpMShortInstruction;
            _tmpMShortInstruction = _cursor.getString(_cursorIndexOfMShortInstruction);
            final int _tmpMTimerValue;
            _tmpMTimerValue = _cursor.getInt(_cursorIndexOfMTimerValue);
            final double _tmpMPriorityLevel;
            _tmpMPriorityLevel = _cursor.getDouble(_cursorIndexOfMPriorityLevel);
            final int _tmpMTreatmentID;
            _tmpMTreatmentID = _cursor.getInt(_cursorIndexOfMTreatmentID);
            _item = new TreatmentStep(_tmpMTreatmentStepID,_tmpMTreatmentStep,_tmpMDescription,_tmpMLongInstruction,_tmpMShortInstruction,_tmpMTimerValue,_tmpMPriorityLevel,_tmpMTreatmentID);
            final Boolean _tmpMIsComplete;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfMIsComplete)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfMIsComplete);
            }
            _tmpMIsComplete = _tmp == null ? null : _tmp != 0;
            _item.setIsComplete(_tmpMIsComplete);
            final Boolean _tmpMIsRequired;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMIsRequired)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfMIsRequired);
            }
            _tmpMIsRequired = _tmp_1 == null ? null : _tmp_1 != 0;
            _item.setIsRequired(_tmpMIsRequired);
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
  public LiveData<TreatmentStep> getTreatmentStep(int treatmentStepID) {
    final String _sql = "SELECT * FROM treatment_step_table WHERE mTreatmentStepID = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, treatmentStepID);
    return new ComputableLiveData<TreatmentStep>() {
      private Observer _observer;

      @Override
      protected TreatmentStep compute() {
        if (_observer == null) {
          _observer = new Observer("treatment_step_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfMTreatmentStepID = _cursor.getColumnIndexOrThrow("mTreatmentStepID");
          final int _cursorIndexOfMTreatmentStep = _cursor.getColumnIndexOrThrow("treatmentStep");
          final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfMLongInstruction = _cursor.getColumnIndexOrThrow("longInstruction");
          final int _cursorIndexOfMShortInstruction = _cursor.getColumnIndexOrThrow("shortInstruction");
          final int _cursorIndexOfMTimerValue = _cursor.getColumnIndexOrThrow("timerValue");
          final int _cursorIndexOfMIsComplete = _cursor.getColumnIndexOrThrow("isComplete");
          final int _cursorIndexOfMIsRequired = _cursor.getColumnIndexOrThrow("isRequired");
          final int _cursorIndexOfMPriorityLevel = _cursor.getColumnIndexOrThrow("priorityLevel");
          final int _cursorIndexOfMTreatmentID = _cursor.getColumnIndexOrThrow("treatmentID");
          final TreatmentStep _result;
          if(_cursor.moveToFirst()) {
            final int _tmpMTreatmentStepID;
            _tmpMTreatmentStepID = _cursor.getInt(_cursorIndexOfMTreatmentStepID);
            final String _tmpMTreatmentStep;
            _tmpMTreatmentStep = _cursor.getString(_cursorIndexOfMTreatmentStep);
            final String _tmpMDescription;
            _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
            final String _tmpMLongInstruction;
            _tmpMLongInstruction = _cursor.getString(_cursorIndexOfMLongInstruction);
            final String _tmpMShortInstruction;
            _tmpMShortInstruction = _cursor.getString(_cursorIndexOfMShortInstruction);
            final int _tmpMTimerValue;
            _tmpMTimerValue = _cursor.getInt(_cursorIndexOfMTimerValue);
            final double _tmpMPriorityLevel;
            _tmpMPriorityLevel = _cursor.getDouble(_cursorIndexOfMPriorityLevel);
            final int _tmpMTreatmentID;
            _tmpMTreatmentID = _cursor.getInt(_cursorIndexOfMTreatmentID);
            _result = new TreatmentStep(_tmpMTreatmentStepID,_tmpMTreatmentStep,_tmpMDescription,_tmpMLongInstruction,_tmpMShortInstruction,_tmpMTimerValue,_tmpMPriorityLevel,_tmpMTreatmentID);
            final Boolean _tmpMIsComplete;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfMIsComplete)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfMIsComplete);
            }
            _tmpMIsComplete = _tmp == null ? null : _tmp != 0;
            _result.setIsComplete(_tmpMIsComplete);
            final Boolean _tmpMIsRequired;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfMIsRequired)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfMIsRequired);
            }
            _tmpMIsRequired = _tmp_1 == null ? null : _tmp_1 != 0;
            _result.setIsRequired(_tmpMIsRequired);
          } else {
            _result = null;
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
