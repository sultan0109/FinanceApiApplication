# Financial Product API

## Запуск проекта:

1. Клонируйте репозиторий:
    git clone https://github.com/sultan0109/FinanceApiApplication
    
2. Сборка проекта:
    mvn clean install

3. Запуск проекта:
    mvn spring-boot:run

## Запуск с Docker:

1. Соберите Docker образ:
    docker build -t financial-api .

2. Запустите контейнер:
    docker run -p 8080:8080 financial-api

## SQL для создания таблиц:

-- Таблица пользователей
CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    balance DECIMAL(10, 2) DEFAULT 0
);

-- Таблица транзакций
CREATE TABLE transactions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    amount DECIMAL(10, 2) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255)
);
