package com.example.medikan.ptsd_treatment;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Treatment.class}, version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract TreatmentDao treatmentDao();


    //Makes sure there's only one instance of the db running
    private static volatile AppRoomDatabase INSTANCE;

    static AppRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {

                if (INSTANCE == null) {
                    //Create db here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}


