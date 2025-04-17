## Запуск сервиса
Находясь в корне проекта выполнить команду docker compose up -d.

REST API:
http://localhost:8082/api/v1/login
Получения access токена, который необходимо включать в каждый запрос, для доступа к endpoint.
Body:
`JSON  
{ "login": "test", "password": "test"} - credentianals тестового пользователя, который создан в realm`

http://localhost:8082/api/v1/hello - GET запрос предоставления username пользователя, который авторизирован. В запрос необходимо включить access токен полученный через `/api/v1/login`.  
Response:
`Hello %username%`
