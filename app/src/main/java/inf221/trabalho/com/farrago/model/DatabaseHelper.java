package inf221.trabalho.com.farrago.model;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.modelBKP.Comprador1;
import inf221.trabalho.com.farrago.modelBKP.CompradorIngresso;
import inf221.trabalho.com.farrago.modelBKP.Evento;
import inf221.trabalho.com.farrago.modelBKP.Ingresso;
import inf221.trabalho.com.farrago.modelBKP.Vendedor;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "farrago.db";
    private static final int DATABASE_VERSION = 2;

    private Dao<Ingresso, Integer> ingressoDao;
    private Dao<Evento, Integer> eventoDao;
    private Dao<CompradorIngresso, Integer> compradorIngressoDao;
    private Dao<Comprador1, Integer> compradorDao;
    private Dao<Vendedor, Integer> vendedorDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {

            // Create tables. This onCreate() method will be invoked only once of the application life time i.e. the first time when the application starts.
            TableUtils.createTable(connectionSource, Ingresso.class);
            TableUtils.createTable(connectionSource, Evento.class);
            TableUtils.createTable(connectionSource, CompradorIngresso.class);
            TableUtils.createTable(connectionSource, Comprador1.class);
            TableUtils.createTable(connectionSource, Vendedor.class);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Erro ao criar tabelas", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {

            // In case of change in database of next version of application, please increase the value of DATABASE_VERSION variable, then this method will be invoked
            //automatically. Developer needs to handle the upgrade logic here, i.e. create a new table or a new column to an existing table, take the backups of the
            // existing database etc.

            TableUtils.createTableIfNotExists(connectionSource, Comprador1.class);
            TableUtils.createTableIfNotExists(connectionSource, Vendedor.class);
            onCreate(sqliteDatabase, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Nao foi possivel atualizar da versao " + oldVer + " para "
                    + newVer, e);
        }
    }

    public Dao<Ingresso, Integer> getIngressoDao() throws SQLException {
        if (ingressoDao == null) {
            ingressoDao = getDao(Ingresso.class);
        }
        return ingressoDao;
    }

    public Dao<Evento, Integer> getEventoDao() throws SQLException {
        if (eventoDao == null) {
            eventoDao = getDao(Evento.class);
        }
        return eventoDao;
    }

    public Dao<CompradorIngresso, Integer> getCompradorIngressoDao() throws SQLException {
        if (compradorIngressoDao == null) {
            compradorIngressoDao = getDao(CompradorIngresso.class);
        }
        return compradorIngressoDao;
    }

    public Dao<Comprador1, Integer> getCompradorDao() throws SQLException {
        if (compradorDao == null) {
            compradorDao = getDao(Comprador1.class);
        }
        return compradorDao;
    }

    public Dao<Vendedor, Integer> getVendedorDao() throws SQLException {
        if (vendedorDao == null) {
            vendedorDao = getDao(Vendedor.class);
        }
        return vendedorDao;
    }

}
