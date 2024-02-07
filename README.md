
## Название проекта: <span style="font-weight: normal;">Triangle Calculator</span>

## Описание проекта: <span style="font-weight: normal;"> 
API для вычисления различных параметров треугольника на основе заданных сторон и углов. 

Для начала вычислений требуется минимальный набор данных о треугольнике, который может быть представлен в одном из следующих форматов:
* SSS (Side-Side-Side): Вводятся длины всех трех сторон треугольника. 
Это наиболее прямой способ определения треугольника, позволяющий вычислить все его углы и другие характеристики.
* SAS (Side-Angle-Side): Вводятся длины двух сторон и угол между ними. 
Этот метод позволяет однозначно определить треугольник и рассчитать все неизвестные параметры, включая третью сторону.
* ASA (Angle-Side-Angle): Вводятся два угла и длина стороны между ними. 
Этот подход также однозначно определяет треугольник, позволяя вычислить длины остальных сторон и оставшийся угол.

Поддерживается вычисление:
* Периметра
* Площади
* Типа треугольника по сторонам (равносторонний, равнобедренный, разносторонний) и углам (остроугольный, тупоугольный, прямоугольный)
* Длин медиан, биссектрис и высот
* Площадей вписанной и описанной окружностей
* Тригонометрических функций углов (синус, косинус, тангенс)

## Ключевые компоненты:

* [TriangleDto](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/dto/TriangleDto.java): DTO для входных данных треугольника.
* [TriangleCalculateDto](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/dto/TriangleCalculateDto.java): DTO для результатов вычислений.
* [TriangleController](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/controller/TriangleController.java): Контроллер, обрабатывающий HTTP запросы к API.
* [TriangleDataValidator](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/validation/TriangleDataValidator.java): Валидатор входных данных.
* [TriangleDataService](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/service/TriangleDataService.java): Сервис, выполняющий вычисления базовых параметров треугольника.
* [TriangleCalculateService](https://github.com/RasulMurtuzaliev/TriangleCalculator/blob/main/src/main/java/Spar/TriangleCalculator/service/TriangleCalculateService.java): Сервис, выполняющий все вычисления.

## Технологии:

* Spring Boot для создания RESTful API.
* Lombok для минимизации бойлерплейта.
* MapStruct для маппинга между DTO.
* JUnit 5 для юнит тестирования.

## Запуск приложения:
1) Убедитесь, что у вас установлена Java 11 или выше.
2) Склонируйте репозиторий с помощью следующей команды: **git clone https://github.com/RasulMurtuzaliev/TriangleCalculator.git**
3) Перейдите в каталог проекта и запустите приложение: 
* Если у вас установлен Gradle, используйте команду **gradle bootRun** для запуска приложения.
* Если Gradle не установлен, но в вашем проекте есть Gradle Wrapper, используйте команду **./gradlew bootRun** на Mac/Linux 
или **gradlew.bat bootRun** на Windows.
4) Далее приложение будет доступно через Swagger: **http://localhost:8080/swagger-ui/index.html?#/**
