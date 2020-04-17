# My test project

<br>

### Todo:
- [x] Проект Maven
- [x] Файл .feature сценария;
- [x] Класс CommonSteps - реализация шагов Cucumber;
- [x] Класс реализующий паттерн Page Object с методами работы со страницей и основными элементами;
- [x] Класс Init, в котором будет инициализация webdriver, запуск нужного webdriver, ожидание загрузки страницы, парсинг property файла;
- [x] Реализовать возможность прогонять тесты на удаленном сервере (selenium grid), требуемый адрес указывать в property файле;
- [x] В проекте должны быть указаны необходимые настройки, что бы была возможность прогонять тесты в несколько потоков; 

 
## Запуск
```bash
# Конфигурация selenoid
docker-compose up selenoid_cm_update

# Запуск selenoid
docker-compose up selenoid

# Запуск тестов
mvn -Dconfig.run.threads=1 \
    -Dconfig.selenium.local=false \
    -Dconfig.selenium.browser=chrome \
    -Dconfig.test.user.name=username \
    -Dconfig.test.user.password=password \
    test
```

