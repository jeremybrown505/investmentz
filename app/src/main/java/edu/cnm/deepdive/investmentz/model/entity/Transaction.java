package edu.cnm.deepdive.investmentz.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.math.BigDecimal;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Currency.class,
            parentColumns = "currency_id",
            childColumns = "buy_currency_id",
            onDelete = ForeignKey.RESTRICT
        ),
        @ForeignKey(
            entity = Currency.class,
            parentColumns = "currency_id",
            childColumns = "sell_currency_id",
            onDelete = ForeignKey.RESTRICT
        )
    }
)
public class Transaction {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "transaction_id")
  private long transactionId;

  @ColumnInfo(name = "sell_currency_id", index = true)
  private Long sellCurrencyId;
  //ask about nullable value on fks
  @ColumnInfo(name = "buy_currency_id", index = true)
  private long buyCurrencyId;

  @ColumnInfo(index = true)
  private Date timestamp;
// TODO update erd to add index to timestamp.

  @ColumnInfo(name = "buy_price")
  private BigDecimal buyPrice;

  @ColumnInfo(name = "quantity_purchased")
  private BigDecimal quantityPurchased;

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Long getSellCurrency() {
    return sellCurrencyId;
  }

  public void setSellCurrency(Long sellCurrency) {
    this.sellCurrencyId = sellCurrency;
  }

  public long getBuyCurrency() {
    return buyCurrencyId;
  }

  public void setBuyCurrency(long buyCurrency) {
    this.buyCurrencyId = buyCurrency;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public BigDecimal getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(BigDecimal buyPrice) {
    this.buyPrice = buyPrice;
  }

  public BigDecimal getQuantityPurchased() {
    return quantityPurchased;
  }

  public void setQuantityPurchased(BigDecimal quantityPurchased) {
    this.quantityPurchased = quantityPurchased;
  }
}
