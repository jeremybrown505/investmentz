package edu.cnm.deepdive.investmentz.viewmodel;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.investmentz.service.InvestmentzDatabase;
import io.reactivex.schedulers.Schedulers;

public class CurrencyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    InvestmentzDatabase.setContext(this);
    InvestmentzDatabase investmentzDatabase = InvestmentzDatabase.getInstance();
    investmentzDatabase.getCurrencyDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);

  }

}
