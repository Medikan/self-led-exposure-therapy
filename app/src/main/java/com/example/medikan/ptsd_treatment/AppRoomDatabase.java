package com.example.medikan.ptsd_treatment;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {Treatment.class, TreatmentStep.class, TestQuestion.class}, version = 10)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract TreatmentDao treatmentDao();
    public abstract TreatmentStepDao treatmentStepsDao();
    public abstract TestQuestionDao testQuestionDao();


    //Makes sure there's only one instance of the db running
    private static volatile AppRoomDatabase INSTANCE;

    static AppRoomDatabase getDatabase(final Context context) {


        Log.i("My Log", "Accessing Database!");

        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {

                if (INSTANCE == null) {
                    //Create db here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration() //TODO don't use destructive migration
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate (@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);

                    Log.i("My Log", "Ran onCreate for Db");

                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}


