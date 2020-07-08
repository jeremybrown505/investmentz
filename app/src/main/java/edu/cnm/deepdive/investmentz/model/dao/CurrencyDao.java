package edu.cnm.deepdive.investmentz.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import io.reactivex.Single;
import java.util.List;

@Dao
public interface CurrencyDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Currency currency);

  @Update
  Single<Integer> update(Currency... currencies);

  @Delete
  Single<Integer> delete(Currency... currencies);

  @Query("SELECT * FROM Currency ORDER BY timestamp ASC")
  LiveData<List<Currency>> selectAll();

  @Query("SELECT * FROM Currency where currency_id = :currencyId")
  LiveData<List<Currency>> selectByCurrencyId(long currencyId);

}
