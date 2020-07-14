#!/bin/bash
echo "Вы запустили скрипт настройки окружения для параллельного тестирования"
echo "Скачиваю образ selenoid"
curl -Lo cm https://github.com/aerokube/cm/releases/download/1.2.0/cm_darwin_amd64
echo "Образ selenoid скачен"
echo "Изменяю права на исполняемый файл"
chmod +x ./cm
echo "Права на исполняемый файл изменены"
echo "Запускаю selenoid"
./cm selenoid start --vnc
echo "Selenoid запущен на порту 4444"
echo "Запускаю selenoid-ui"
./cm selenoid-ui start
echo "Selenoid-ui запущен на порту 8080"
echo "Запускаю тесты"
mvn clean test -DsuiteXmlFile=testng.xml