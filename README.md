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


### todo_decomposition
- [x] research_junit5
- [x] research_allure
- [x] research_cucumber
- [x] research_selenium
- [] research_jenkins
- [] research_report

- [x] project_implementation_junit5
- [x] project_implementation_allure
- [x] project_implementation_cucumber
- [x] project_implementation_selenium
- [x] project_maven_base
- [x] project_maven_module_core
- [x] project_maven_module_assemble
- [x] project_maven_module_test
- [x] project_maven_configure
- [x] project_maven_build
- [] project_ci_jenkins
- [] project_ci_report_allure
- [] project_ci_report_mail

- [] project_testing
- [x] project_deploy_github
 
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

