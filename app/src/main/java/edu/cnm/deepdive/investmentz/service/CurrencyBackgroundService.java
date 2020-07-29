package edu.cnm.deepdive.investmentz.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CurrencyBackgroundService extends JobService {

  public static final String BASE_CURRENCY = "USD";
  private static final int POOL_SIZE = 4;

  private final CurrencyRepository currencyRepository;
  private final CoinbaseService coinbaseService;
  private final ExecutorService pool;

  public CurrencyBackgroundService() {
    currencyRepository = new CurrencyRepository(this);
    coinbaseService = CoinbaseService.getInstance();
    pool = Executors.newFixedThreadPool(POOL_SIZE);
  }

  @Override
  public boolean onStartJob(JobParameters params) {
    currencyRepository.getAllForBackground()
        .map((currencies) -> {
          for(Currency currency : currencies) {
            if (!currency.getCryptoSymbol().equals(BASE_CURRENCY)) {
              coinbaseService.get(currency.getCryptoSymbol(), BASE_CURRENCY,  1)
                  .subscribeOn(Schedulers.from(pool))
                  .flatMapCompletable(response -> {
                    currency.setUsdPrice(response.getAsk().getValue());
                    currency.setTimestamp(new Date());
                    return currencyRepository.save(currency);
                  })
                  .subscribe();
            }
          }
          return currencies;
        })
        .subscribe();


    return false;
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    return true;
  }
}
