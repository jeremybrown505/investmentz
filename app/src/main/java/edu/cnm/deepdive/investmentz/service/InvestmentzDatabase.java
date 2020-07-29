package edu.cnm.deepdive.investmentz.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.investmentz.model.dao.CurrencyDao;
import edu.cnm.deepdive.investmentz.model.dao.TransactionDao;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import edu.cnm.deepdive.investmentz.model.entity.Transaction;
import edu.cnm.deepdive.investmentz.service.InvestmentzDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

@Database(
    entities = {Currency.class, Transaction.class},
    version = 1,
    exportSchema = true
)

@TypeConverters({Converters.class})
public abstract class InvestmentzDatabase extends RoomDatabase {

  private static final String DB_NAME = "investmentz_db";

  private static Application context;

  public static void setContext(Application context) {InvestmentzDatabase.context = context;
  }


  public abstract CurrencyDao getCurrencyDao();

  public abstract TransactionDao getTransactionDao();

  public static InvestmentzDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final InvestmentzDatabase INSTANCE =
        Room.databaseBuilder(context, InvestmentzDatabase.class, DB_NAME)
            .addCallback(new Callback(context))
            .build();
  }

  private static class Callback extends RoomDatabase.Callback {

    private final Context context;

    private Callback(Context context) {
      this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      CurrencyDao currencyDao = InvestmentzDatabase.getInstance().getCurrencyDao();
      Currency usd = new Currency();
      usd.setCryptoSymbol("USD");
      usd.setUsdPrice(100L);
      usd.setTimestamp(new Date());
      Currency btc = new Currency();
      btc.setCryptoSymbol("BTC");
      btc.setUsdPrice(9000_00L);
      btc.setTimestamp(new Date());
      currencyDao.insert(usd, btc)
          .subscribeOn(Schedulers.io())
          .subscribe();
    }
  }
  // TODO study android lifecycles
  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }
}