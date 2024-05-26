# Online Wallet App

## Описание

Online Wallet App — это приложение для управления электронным кошельком, предоставляющее функции пополнения и вывода средств. Приложение включает REST API для выполнения операций с кошельками.

## Стек технологий

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Liquibase
- PostgreSQL
- Docker

## Приложение предоставляет следующие эндпоинты:

- Получение информации о кошельке

   URL: http://localhost:8081/api/v1/wallets/{walletId}

   Метод: GET
- Пополнение и вывод средств

  URL: /api/v1/wallet

  Метод: POST

  Тело запроса:

{
"walletId": "11111111-1111-1111-1111-111111111111",

"amount": 500,

"operationType": "DEPOSIT" // или "WITHDRAW"
}

## Миграция базы данных


База данных автоматически обновляется при запуске приложения с использованием Liquibase.
Миграции базы данных находятся в директории src/main/resources/db/changelog.
Приложение применит эти миграции при первом запуске.

Для тестировании в Postman вложены тестовые кошельки с id:

- 11111111-1111-1111-1111-111111111111
- 22222222-2222-2222-2222-222222222222
- 33333333-3333-3333-3333-333333333333

##  Конфигурация
### Порт
Приложение запускается на порту 8081, что настроено в файле application.yaml
### Подключение к базе данных
Приложение использует PostgreSQL для хранения данных.
Конфигурация базы данных находится в файле application.yaml

## Логи
Логи приложения сохраняются в файл onlineWalletApp.log в корне проекта.


