package edu.cnm.deepdive.investmentz.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import edu.cnm.deepdive.investmentz.service.CurrencyRepository;

public class HomeViewModel extends AndroidViewModel {

    private final CurrencyRepository currencyRepository;

    public HomeViewModel(@NonNull Application application) {
      super(application);
      currencyRepository = new CurrencyRepository(application);

    }

}
