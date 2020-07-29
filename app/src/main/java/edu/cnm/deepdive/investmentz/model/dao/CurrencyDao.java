package edu.cnm.deepdive.investmentz.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface CurrencyDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Currency currency);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Currency... currencies);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Currency> currencies);

  @Update
  Single<Integer> update(Currency... currencies);

  @Delete
  Single<Integer> delete(Currency... currencies);

  @Query("SELECT * FROM Currency ORDER BY timestamp ASC")
  LiveData<List<Currency>> selectAll();

  @Query("SELECT * FROM Currency WHERE currency_id = :currencyId")
  Single<Currency> selectByCurrencyId(long currencyId);

  @Query("SELECT * FROM Currency WHERE crypto_symbol = :cryptoSymbol")
  Maybe<Currency> selectByCryptoSymbol(String cryptoSymbol);

  @Query("SELECT * FROM Currency ORDER BY timestamp ASC")
  Single<List<Currency>> selectAllForBackground();

}
