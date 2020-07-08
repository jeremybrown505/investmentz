CREATE TABLE IF NOT EXISTS `Currency`
(
    `currency_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `crypto_symbol` TEXT COLLATE NOCASE,
    `timestamp`     INTEGER,
    `usd_price`     INTEGER
);
CREATE TABLE IF NOT EXISTS `Transaction`
(
    `transaction_id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `sell_currency_id`   INTEGER,
    `buy_currency_id`    INTEGER                           NOT NULL,
    `timestamp`          INTEGER                           NOT NULL,
    `buy_price`          INTEGER                           NOT NULL,
    `quantity_purchased` INTEGER                           NOT NULL,
    `sold_price`         INTEGER                           NOT NULL,
    `quantity_sold`      INTEGER                           NOT NULL,
    FOREIGN KEY (`buy_currency_id`) REFERENCES `Currency` (`currency_id`) ON UPDATE NO ACTION ON DELETE RESTRICT,
    FOREIGN KEY (`sell_currency_id`) REFERENCES `Currency` (`currency_id`) ON UPDATE NO ACTION ON DELETE RESTRICT
);

