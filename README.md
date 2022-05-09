### The app provides a service of converting one currency to another based on the current exchange rates using http://api.nbp.pl/
---
### Instalation guide using git bash:
#### 1. Clone the repository.
```
git clone https://github.com/Zonner93/CurrencyConverter.git
```
#### 2. Go inside application root directory.
```
cd CurrencyConverter
```
#### 3. Build jar file.
```
./mvnw clean compile package
```
#### 4. Run docker compose.
```
docker-compose up
```
---
### Description of response parameters for currency exchange rates:
#### *currency* - name of currency.
#### *code* - currency code.
#### *effectiveDate* - publication date.
#### *bid* - currency buying rate.
#### *ask* - currency selling rate.
#### *result* - calculated amount of the new currency.
---
### Enpoints:
---
#### GET */api/currency/{currencyCode}*
#### *{currencyCode}* - request parameter (*usd, aud, cad, eur, huf, chf, gbp, jpy, czk, dkk, nok, sek, xdr*).
#### example curl:
```
curl -X GET -F 'currencyCode=eur' http://localhost:8080/api/currency/
```
#### example output:
```json
{
    "currency": "euro",
    "code": "EUR",
    "effectiveDate": "2022-05-06",
    "bid": 4.6067,
    "ask": 4.6997
}
```
---
#### GET */api/currency/list{currencyCodeList}*
#### *{currencyCodeList}* - request parameter, list of currency codes.
#### example curl:
```
curl -X GET -F 'currencyCodeList=eur,gbp,czk' http://localhost:8080/api/currency/list
```
#### example output:
```json
[
    {
        "currency": "euro",
        "code": "EUR",
        "effectiveDate": "2022-05-06",
        "bid": 4.6067,
        "ask": 4.6997
    },
    {
        "currency": "funt szterling",
        "code": "GBP",
        "effectiveDate": "2022-05-06",
        "bid": 5.4047,
        "ask": 5.5139
    },
    {
        "currency": "korona czeska",
        "code": "CZK",
        "effectiveDate": "2022-05-06",
        "bid": 0.188,
        "ask": 0.1918
    }
]
```
---
#### GET */api/currency/list/available*
#### Returns list of available currency codes.
#### example curl:
```
curl -X GET http://localhost:8080/api/currency/available
```
#### example output:
```json
{
    "currencyCodeList": [
        "usd",
        "aud",
        "cad",
        "eur",
        "huf",
        "chf",
        "gbp",
        "jpy",
        "czk",
        "dkk",
        "nok",
        "sek",
        "xdr"
    ]
}
```
---
#### GET */api/currency/convert{quantity}&{currencyCodeFrom}&{currencyCodeTo}*
#### *{quantity}* - the amount of currency want to convert.
#### *{currencyCodeFrom}* - the currency want to convert.
#### *{currencyCodeTo}* - the currency want to convert to.
#### example curl:
```
curl -X GET -F 'quantity=100' -F 'currencyCodeFrom=gbp' -F 'currencyCodeTo=jpy' http://localhost:8080/api/currency/convert
```
#### example output:
```json
{
    "date": "2022-05-08T14:11:16.441044200",
    "quantity": 100.0,
    "currencyFrom": "funt szterling",
    "currencyTo": "jen (Japonia)",
    "codeFrom": "gbp",
    "codeTo": "jpy",
    "result": 15812.926065712865
}
```
---
#### GET */api/currency/history*
#### Returns a history of all conversions.
#### example curl:
```
curl -X GET 'currencyCodeTo=jpy' http://localhost:8080/api/currency/history
```
#### example output:
```json
[
    {
        "date": "2022-05-07T14:10:25.847332800",
        "quantity": 100.0,
        "currencyFrom": "dolar amerykański",
        "currencyTo": "funt szterling",
        "codeFrom": "usd",
        "codeTo": "gbp",
        "result": 79.13817805908704
    },
    {
        "date": "2022-05-07T14:10:46.441851",
        "quantity": 100.0,
        "currencyFrom": "funt szterling",
        "currencyTo": "dolar amerykański",
        "codeFrom": "gbp",
        "codeTo": "usd",
        "result": 121.40482501460083
    }, ...

]
```
---
