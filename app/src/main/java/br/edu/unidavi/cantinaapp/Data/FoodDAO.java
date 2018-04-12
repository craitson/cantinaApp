package br.edu.unidavi.cantinaapp.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.edu.unidavi.cantinaapp.Model.Food;

/**
 * Created by Craitson on 11/04/2018.
 */

public class FoodDAO extends SQLiteOpenHelper {

    private static final String DB_NAME = "cantinaApp.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_MEME = "food";

    //COLUMN_NAMES
    private static final String ROW_ID = "id";
    private static final String ROW_NOME = "nome";
    private static final String ROW_VALOR = "valor";
    private static final String ROW_PHOTOURL = "photoUrl";

    public FoodDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_MEME + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ROW_NOME + " TEXT,"
                + ROW_VALOR + " REAL,"
                + ROW_PHOTOURL + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEME);
        onCreate(db);
    }

    public List<Food> getAll() {
        List<Food> foodsList = new ArrayList<Food>();

        String selectQuery = "SELECT * FROM " + TABLE_MEME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,
                null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setCodigo(Integer.parseInt(cursor.getString(
                        0)));
                food.setNome(cursor.getString(1));
                food.setValor(cursor.getFloat(2));
                food.setPhotoUrl(cursor.getString(3));
                // Adding contact to list
                foodsList.add(food);
            } while (cursor.moveToNext());
        }

        return foodsList;
    }


}
