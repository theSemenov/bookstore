Инструкция по запуску

1. Если лень возиться с настройкой БД:
Перенести аннотацию @Primary с класса RepositoryBookstoreService yf rkfcc InMemoryBookstoreService. Запустить приложеие.

2. Настройка докера c MySQL. Если не хочется ставить MySQL и настроен докер
2.1. Запустить докер c MySQL коммандой
docker run --name my-sql-container -p 3306:3306 -e MYSQL_DATABASE=bookstoredb -e MYSQL_USER=mysqluser -e  MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password -e  -d mysql/mysql-server:8.0
на докере настроен проброс порта 3306 в хост машину. 

Данные для подключения к БД
Хост: localhost
Порт: 3306
user: mysqluser
pass: password
database: bookstoredb

2.2. Выполнить скрипт sql/books_tbl.sql
2.3. Убедится что аннотация @Primary стоит на RepositoryBookstoreService и вперед к запуску

3. Еcли БД MySQL уже развернута:
3.1. Поправить конфиги т.к. по умолчанию они смотрят на БД настроенную на доккере. Править надо src/main/webapp/WEB-INF/db-config.xml bean c id "bookstoreDataSource"
3.2. Выполнить скрипт sql/books_tbl.sql
После этого можно запускать сервер.

4. Запуск
Находясь в корне проекта выполнить ./gradlew clean vaadinRun. Запустится jetty с развернутым приложением. Приложение будет доступно по адресу http://localhost:8080/
После заверщшения работы желательно проверить порт 8080 на наличие живых процкссов. И завершить их.

5. Создание war
./gradlew clean war
Файл появится в дирктории build/libs/