package com.example.medikan.ptsd_treatment;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppRoomDatabase_Impl extends AppRoomDatabase {
  private volatile TreatmentDao _treatmentDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `treatment_table` (`mTreatmentID` INTEGER NOT NULL, `treatment` TEXT NOT NULL, `description` TEXT, `isComplete` INTEGER, `isRequired` INTEGER, `priorityLevel` REAL NOT NULL, PRIMARY KEY(`mTreatmentID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"4ce4ea290cbbda6559e5a88f207cf754\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `treatment_table`");
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
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTreatmentTable = new HashMap<String, TableInfo.Column>(6);
        _columnsTreatmentTable.put("mTreatmentID", new TableInfo.Column("mTreatmentID", "INTEGER", true, 1));
        _columnsTreatmentTable.put("treatment", new TableInfo.Column("treatment", "TEXT", true, 0));
        _columnsTreatmentTable.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsTreatmentTable.put("isComplete", new TableInfo.Column("isComplete", "INTEGER", false, 0));
        _columnsTreatmentTable.put("isRequired", new TableInfo.Column("isRequired", "INTEGER", false, 0));
        _columnsTreatmentTable.put("priorityLevel", new TableInfo.Column("priorityLevel", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTreatmentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTreatmentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTreatmentTable = new TableInfo("treatment_table", _columnsTreatmentTable, _foreignKeysTreatmentTable, _indicesTreatmentTable);
        final TableInfo _existingTreatmentTable = TableInfo.read(_db, "treatment_table");
        if (! _infoTreatmentTable.equals(_existingTreatmentTable)) {
          throw new IllegalStateException("Migration didn't properly handle treatment_table(com.example.medikan.ptsd_treatment.Treatment).\n"
                  + " Expected:\n" + _infoTreatmentTable + "\n"
                  + " Found:\n" + _existingTreatmentTable);
        }
      }
    }, "4ce4ea290cbbda6559e5a88f207cf754", "3936e0f972610035e414c1c5527f645b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "treatment_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `treatment_table`");
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
  public TreatmentDao treatmentDao() {
    if (_treatmentDao != null) {
      return _treatmentDao;
    } else {
      synchronized(this) {
        if(_treatmentDao == null) {
          _treatmentDao = new TreatmentDao_Impl(this);
        }
        return _treatmentDao;
      }
    }
  }
}
