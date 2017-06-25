package inf221.trabalho.com.farrago.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoDeDadosSingleton {

	private String NOME_BANCO = "farra_go.db";
	private BancoDeDadosSingleton INSTANCE = new BancoDeDadosSingleton();
	private String[] SCRIPT_DATABASE_CREATE = new String[]{};
	protected SQLiteDatabase db;

	private BancoDeDadosSingleton() {
		// TODO - implement BancoDeDadosSingleton.BancoDeDadosSingleton
		throw new UnsupportedOperationException();
	}

	public BancoDeDadosSingleton getInstance() {
		// TODO - implement BancoDeDadosSingleton.getInstance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabelas
	 * @param valores
	 */
	public long inserir(String tabelas, ContentValues valores) {
		// TODO - implement BancoDeDadosSingleton.inserir
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabela
	 * @param where
	 */
	public int deletar(String tabela, String where) {
		// TODO - implement BancoDeDadosSingleton.deletar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabelas
	 * @param colunas
	 * @param where
	 * @param orderby
	 */
	public void atualizar(String tabelas, String[] colunas, String where, String orderby) {
		// TODO - implement BancoDeDadosSingleton.atualizar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabelas
	 * @param colunas
	 * @param where
	 * @param orderBy
	 */
	public Cursor buscar(String tabelas, String[] colunas, String where, String orderBy) {
		// TODO - implement BancoDeDadosSingleton.buscar
		throw new UnsupportedOperationException();
	}

	public void abrir() {
		// TODO - implement BancoDeDadosSingleton.abrir
		throw new UnsupportedOperationException();
	}

	public void fechar() {
		// TODO - implement BancoDeDadosSingleton.fechar
		throw new UnsupportedOperationException();
	}

}