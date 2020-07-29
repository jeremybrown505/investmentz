package edu.cnm.deepdive.investmentz.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.investmentz.model.dao.CurrencyDao;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import edu.cnm.deepdive.investmentz.service.CoinbaseService.InstanceHolder;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class CurrencyRepository {

  private final Context context;
  private final InvestmentzDatabase database;
  private final CurrencyDao currencyDao;



  public CurrencyRepository(Context context) {
    this.context = context;
    database = InvestmentzDatabase.getInstance();
    currencyDao = database.getCurrencyDao();


  }

  public LiveData<List<Currency>> getAll() {
    return currencyDao.selectAll();
  }

  public Single<List<Currency>> getAllForBackground() {
    return currencyDao.selectAllForBackground()
        .subscribeOn(Schedulers.io());
  }

  public Single<Currency> get(long id) {
    return currencyDao.selectByCurrencyId(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Currency currency) {
    if (currency.getCurrencyId() == 0) {
      return Completable.fromSingle(currencyDao
          .insert(currency))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(currencyDao.update(currency))
          .subscribeOn(Schedulers.io());
    }
  }


  public Completable delete(Currency currency) {
    if (currency.getCurrencyId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(currencyDao.delete(currency))
          .subscribeOn(Schedulers.io());
    }
  }



}
