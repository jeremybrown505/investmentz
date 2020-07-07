package edu.cnm.deepdive.investmentz.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.investmentz.model.entity.Currency;
import edu.cnm.deepdive.investmentz.model.entity.Transaction;
import io.reactivex.Single;
import java.util.List;

public interface TransactionDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Transaction transaction);

  @Update
  Single<Integer> update(Transaction... transactions);

  @Delete
  Single<Integer> delete(Transaction... transactions);

  @Query("SELECT * FROM `Transaction` ORDER BY timestamp ASC")
  LiveData<List<Transaction>> selectAll();

  @Query("SELECT * FROM `Transaction` WHERE buy_currency_id = :currencyId OR sell_currency_id = :currencyId ORDER BY timestamp ASC")
  LiveData<List<Transaction>> selectByCurrencyId(long currencyId);


}
