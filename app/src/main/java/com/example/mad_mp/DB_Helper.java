package com.example.mad_mp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DB_Helper extends SQLiteOpenHelper{

    private static final String DB_NAME = "microproject_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "product_details";
    private static final String COL_ID = "product_id";
    private static final String COL_NAME = "product_name";
    private static final String COL_QUANTITY = "quantity";

    public DB_Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

//    create a new table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT,"
                + COL_QUANTITY + " TEXT)";

        db.execSQL(query);
        db.execSQL("CREATE TABLE users(username_col TEXT primary key,passoword_col TEXT)");
        db.execSQL("INSERT INTO users VALUES('devansh','123')");

    }

    //check user login
    public Boolean checkUsername(String username){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username_col=?", new String[] {username});
        if (cursor.getCount() > 0) {
            return true;
        }else{
             return  false;
        }
    }

    //match username and password
    public Boolean matchuserpass(String username , String password){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username_col=? and passoword_col=?", new String[] {username,password});
        if (cursor.getCount() > 0) {
            return true;
        }else{
            return  false;
        }
    }

    //    add a product
    public void addProduct(String name,String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_QUANTITY , quantity);

            db.insert(TABLE_NAME, null, values);


    }

//    delete a product
    public Boolean deleteProduct(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        long initial_count = DatabaseUtils.queryNumEntries(db,TABLE_NAME);
        Log.d("tag","initial_count"+initial_count);
        db.delete(TABLE_NAME,"product_name=?",new String[]{name});
        long count_after = DatabaseUtils.queryNumEntries(db,TABLE_NAME);
        Log.d("tag","later"+count_after);
        if(initial_count==count_after){
            return false;
        }
        else{
            return true;
        }

    }

//    view inventory
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public Boolean updateData(String name,String quantity){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_QUANTITY,quantity);

        db.update(TABLE_NAME,contentValues,"product_name=?", new String[]{name});
        return true;
    }

    public String getQuantity(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT quantity FROM product_details where product_name= "+name;

        Cursor cursor = db.rawQuery("SELECT quantity FROM product_details where product_name= ?" , new String[]{name});
        cursor.moveToFirst();
        String i = cursor.getString(0);
        return i;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }
}
