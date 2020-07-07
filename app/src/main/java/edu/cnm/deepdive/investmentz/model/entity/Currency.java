package edu.cnm.deepdive.investmentz.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.math.BigDecimal;
import java.util.Date;

@Entity(indices = @Index(value = "crypto_symbol", unique = true))

public class Currency {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "currency_id")
    private long currencyId;

    @ColumnInfo(name = "crypto_symbol", collate = ColumnInfo.NOCASE)
    private String cryptoSymbol = "";

    @ColumnInfo(index = true)
    private Date timestamp;

//    @ColumnInfo(name = "usd_price")
//    private BigDecimal usdPrice;

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCryptoSymbol() {
        return cryptoSymbol;
    }

    public void setCryptoSymbol(String cryptoSymbol) {
        this.cryptoSymbol = cryptoSymbol;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

//    public BigDecimal getUsdPrice() {
//        return usdPrice;
//    }
//
//    public void setUsdPrice(BigDecimal usdPrice) {
//        this.usdPrice = usdPrice;
//    }
    //todo check comments
}
