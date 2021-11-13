package com.example.covsymps;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Symtoms.db";
    private static final int DATABASE_VERSION = 4;
    private static final String TABLE_NAME = "Symps";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME_FEVER = "FEVER";
    private static final String COLUMN_NAME_RUNNY_NOSE = "RUNNYNOSE";
    private static final String COLUMN_NAME_HEADACHE = "HEADACHE";
    private static final String COLUMN_NAME_COLD = "COLD";
    private static final String COLUMN_NAME_COUGH = "COUGH";
    private static final String COLUMN_NAME_LOSS_SMELL_TASTE = "SMELLTASTE";
    private static final String COLUMN_NAME_NAUSEA = "NAUSEA";
    private static final String COLUMN_NAME_SHORT_BREATH = "SHORTBREATH";
    private static final String COLUMN_NAME_DIARRHOEA = "DIARRHOEA";
    private static final String COLUMN_NAME_TIRED = "TIRED";
    private static final String COLUMN_NAME_MA = "MUSCLEACHE";
    private static final String COLUMN_NAME_SORETHROAT = "SORETHROAT";
    private static final String COLUMN_NAME_HEART_RATE = "HEARTRATE";
    private static final String COLUMN_NAME_RESP_RATE = "RESPRATE";

    String TAG = "DATABASE: ";



    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        String query = "CREATE TABLE " + TABLE_NAME + " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_HEART_RATE + " TEXT, " + COLUMN_NAME_RESP_RATE + " TEXT, " + COLUMN_NAME_FEVER + " TEXT, " +
                COLUMN_NAME_RUNNY_NOSE + " TEXT, " + COLUMN_NAME_HEADACHE + " TEXT, " + COLUMN_NAME_COLD +  " TEXT, " + COLUMN_NAME_COUGH + " TEXT, " + COLUMN_NAME_LOSS_SMELL_TASTE + " TEXT, " + COLUMN_NAME_NAUSEA + " TEXT, " + COLUMN_NAME_SHORT_BREATH + " TEXT, " + COLUMN_NAME_DIARRHOEA + " TEXT, " + COLUMN_NAME_TIRED + " TEXT, " + COLUMN_NAME_MA + " TEXT, " + COLUMN_NAME_SORETHROAT + " TEXT) " ;
        Toast.makeText(context,query, Toast.LENGTH_SHORT).show();
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    /*void addSymptoms(String fever, String rnose, String head, String cold ,String cough, String nausea, String ma, String st, String t, String di, String sb, String smell){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_FEVER, fever);
        cv.put(COLUMN_NAME_RUNNY_NOSE, rnose);
        cv.put(COLUMN_NAME_HEADACHE, head);
        cv.put(COLUMN_NAME_COLD, cold);
        cv.put(COLUMN_NAME_COUGH,cough);
        cv.put(COLUMN_NAME_LOSS_SMELL_TASTE,smell);
        cv.put(COLUMN_NAME_NAUSEA,nausea);
        cv.put(COLUMN_NAME_SHORT_BREATH,sb);
        cv.put(COLUMN_NAME_DIARRHOEA,di);
        cv.put(COLUMN_NAME_TIRED,t);
        cv.put(COLUMN_NAME_MA,ma);
        cv.put(COLUMN_NAME_SORETHROAT,st);

        long result = db.insert(TABLE_NAME, null ,cv);
        if (result == -1)
        {
            Toast.makeText(context, "Fails", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }*/

    void updateSymptoms(String fever, String rnose, String head, String cold ,String cough, String nausea, String ma, String st, String t, String di, String sb, String smell){
        //Screen 2, we update the table with all the collected symptoms.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_FEVER, fever);
        contentValues.put(COLUMN_NAME_RUNNY_NOSE, rnose);
        contentValues.put(COLUMN_NAME_HEADACHE, head);
        contentValues.put(COLUMN_NAME_COLD, cold);
        contentValues.put(COLUMN_NAME_COUGH, cough);
        contentValues.put(COLUMN_NAME_LOSS_SMELL_TASTE, smell);
        contentValues.put(COLUMN_NAME_NAUSEA, nausea);
        contentValues.put(COLUMN_NAME_SHORT_BREATH, sb);
        contentValues.put(COLUMN_NAME_DIARRHOEA, di);
        contentValues.put(COLUMN_NAME_TIRED, t);
        contentValues.put(COLUMN_NAME_MA, ma);
        contentValues.put(COLUMN_NAME_SORETHROAT, st);
        String column_id = "1";
        Cursor cursor = db.rawQuery("Select * from Symps where _id = ?", new String[]{column_id});
        if (cursor.getCount() > 0) {
            long result = db.update("Symps", contentValues, "_id=?", new String[]{column_id});
        }}

    void addHeartRate(String heartRate){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_HEART_RATE, heartRate);
        //Screen 1, we create the table and insert the heart rate
        long result = db.insert(TABLE_NAME, null ,cv);
        if (result == -1)
        {
            Toast.makeText(context, "Fails", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    void updateRespRate(String respRate){
        //Screen 1, we update the table with the calculated Respiratory Rate
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_RESP_RATE, respRate);
        String column_id = "1";
        Cursor cursor = db.rawQuery("Select * from Symps where _id = ?", new String[]{column_id});
        if (cursor.getCount() > 0) {
            long result = db.update("Symps", contentValues, "_id=?", new String[]{column_id});
        }}
}
