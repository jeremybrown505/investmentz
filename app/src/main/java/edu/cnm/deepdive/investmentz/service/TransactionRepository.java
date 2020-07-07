package edu.cnm.deepdive.investmentz.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.investmentz.model.dao.CurrencyDao;
import edu.cnm.deepdive.investmentz.model.dao.TransactionDao;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import edu.cnm.deepdive.investmentz.model.entity.Transaction;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class TransactionRepository {

  private final Context context;
  private final InvestmentzDatabase database;
  private final TransactionDao transactionDao;



  public TransactionRepository(Context context) {
    this.context = context;
    database = InvestmentzDatabase.getInstance();
    transactionDao = database.getTransactionDao();


  }

  public LiveData<List<Transaction>> getAll() {
    return transactionDao.selectAll();
  }

  public LiveData<List<Transaction>> get(long id) {
    return transactionDao.selectByCurrencyId(id);
  }

  public Completable save(Transaction transaction) {
    if (transaction.getTransactionId() == 0) {
      return Completable.fromSingle(transactionDao
          .insert(transaction))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(transactionDao.update(transaction))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Transaction transaction) {
    if (transaction.getTransactionId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(transactionDao.delete(transaction))
          .subscribeOn(Schedulers.io());
    }
  }




}

