package inf221.trabalho.com.farrago.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by usuario on 24/04/2017.
 */

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import inf221.trabalho.com.farrago.model.DaoMaster;
import inf221.trabalho.com.farrago.model.DaoSession;

public class MyApp extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
       // Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "farrago.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Context getContext(){ return getContext();}
}
