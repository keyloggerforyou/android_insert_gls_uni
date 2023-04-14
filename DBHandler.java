package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

        // creating a constant variables for our database.
        // below variable is for our database name.
        private static final String DB_NAME = "StudentDetails";

        // below int is our database version
        private static final int DB_VERSION = 1;

        // below variable is for our table name.
        private static final String TABLE_NAME = "students";

        // below variable is for our id column.
        private static final String ID_COL = "id";

        // below variable is for our course name column
        private static final String NAME_COL = "name";

        // below variable id for our course duration column.
        private static final String ROLL_COL = "roll";

        // below variable for our course description column.
        private static final String SUB_COL = "sub";

        // below variable is for our course tracks column.
        private static final String MARKS_COL = "marks";

        // creating a constructor for our database handler.
        public DBHandler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // below method is for creating a database by running a sqlite query
        @Override
        public void onCreate(SQLiteDatabase db) {
            // on below line we are creating
            // an sqlite query and we are
            // setting our column names
            // along with their data types.
            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAME_COL + " TEXT,"
                    + ROLL_COL + " TEXT,"
                    + SUB_COL + " TEXT,"
                    + MARKS_COL + " TEXT)";

            // at last we are calling a exec sql
            // method to execute above sql query
            db.execSQL(query);
        }

        // this method is use to add new course to our sqlite database.
        public void addNewStudent(String name, String roll, String sub, String marks) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME_COL, name);
            values.put(ROLL_COL, roll);
            values.put(SUB_COL, sub);
            values.put(MARKS_COL, marks);
            db.insert(TABLE_NAME, null, values);
            db.close();
        }
        public ArrayList<StudentModal> readstudent() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursorstudent = db.rawQuery("SELECT * FROM Students ", null);
            ArrayList<StudentModal>= new ArrayList<>();

            if (cursorstudent.moveToFirst()) {
                do {
                    StudentModalArrayList.add(new StudentModal(cursorstudent.getString(1),
                            cursorstudent.getString(2),
                            cursorstudent.getString(3),
                            cursorstudent.getString(4)));

                } while (cursorstudent.moveToNext());
            }
            cursorstudent.close();
            return StudentModalArrayList;
        }
    public void update(String originalName, String name, String roll,
                             String sub, String marks) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(ROLL_COL, roll);
        values.put(SUB_COL, sub);
        values.put(MARKS_COL, marks);
        db.update(TABLE_NAME, values, "name=?", new String[]{originalName});
        db.close();
    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

    public void updatestudent(String originalname, String name, String roll,
                             String sub, String marks) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(ROLL_COL, roll);
        values.put(SUB_COL, sub);
        values.put(MARKS_COL, marks);
        db.update(TABLE_NAME, values, "name=?", new String[]{originalname});
        db.close();
    }
    public void deletestudent(String name) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "name=?", new String[]{name});
        db.close();
    }

}
