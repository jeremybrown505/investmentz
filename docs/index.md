## Introduction
Investmentz is an android based platform that will allow its users to setup an account,
and use fake money and start trading crypto-currency pairs using live market data. Investmentz
will have several tools such as the ability to buy and sell with fake money before risking
their real life assets, setting up buy and sell orders from the app, keep a history of those orders,
and some basic profit analysis to help a trader monitor and analyze the effectiveness of their 
strategies.

* The ability to set up a username and password

* Access live market data.

* Storing a history of data. What was purchased, when, for what price, and what it sold for, 
as well as the profit/loss in raw dollar amounts and percentage of initial investment.

* The program will create a simulated environment using fake money and live market data allow the
user to practice their crypto trading skills while recording and analyzing the results.
    

## User Stories

New traders who want to use play money and develop some strategies using real market conditions,
 and analyze their decisions before rising their real life assets.
 
> “As a new trader I really want a platform that uses live, real market data to allow me to set up
fake trades and test my strategy."

Day traders who want to create and tweak new strategies, and be able to use real fake funds to
execute trades and have access to some tools to help them analyze the results before risking actual
assets.

> “As a day trader I wonder how effective the trades I have made have been, with this software 
I can evaluate my preformance to maximize my profits."


## Design documentation

* [Wireframe diagram](wireframe.md)
* [Entity relationships](entity-relationships.md)
* [Entity Classes](entity-classes.md)

## External services

### Coinbase

* I plan on integrating with Coinbase's API, and using it to extract the current
market price of crypto-currencies as measured in USD and display that to the user, records it in
a database, and runs some primitive profit calculations on them.

* If my app loses connection to the internet and the API, the app will lock any transactions and
prevent further trades until reconnected to the network.  

* The Coinbase API is documented at <https://docs.pro.coinbase.com/#introduction>.