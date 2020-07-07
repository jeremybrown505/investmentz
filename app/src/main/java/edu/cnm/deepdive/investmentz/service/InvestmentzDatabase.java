package edu.cnm.deepdive.investmentz.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.investmentz.model.dao.CurrencyDao;
import edu.cnm.deepdive.investmentz.model.dao.TransactionDao;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import edu.cnm.deepdive.investmentz.model.entity.Transaction;
import edu.cnm.deepdive.investmentz.service.InvestmentzDatabase.Converters;
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
            .build();
  }


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