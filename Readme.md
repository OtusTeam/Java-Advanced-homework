# Пошаговая инструкция
Описание последовательности шагов, которые нужно сделать для выполнения ДЗ:

1) Одна репа на всех - https://github.com/OtusTeam/Java-Advanced-homework
2) Студенты присылают свои учётки методисту
3) Методист предоставляет доступ
4) Для идентификации студента НУЖНО использовать фамилию студента в Транслитерации (Ваш nickname github'а будет отображаться в коммитах)
5) Каждый студент "живёт" в своей папке в репозитории: например, **tsarev/task_name_1/, tsarev/task_name_2/** и д.т.
6) Для сборки проекта в корневой pom.xml добавляется папка студента, как maven модуль (**<module>tsarev</module>**)
6) В своей папке студент может вести один общий проект с ДЗ или аналогично делить на подпапки
7) Система сборки maven, в папке студента создается корневой pom.xml со списком ДЗ (**<module>task1</module><module>task2</module>** и т.д.) 
8) Обязательно исчерпывающее ReadMe.md для каждого ДЗ, в котором написано как запустить приложение и что нужно сделать, чтобы получить нужный ответ или результаты (с таблицами, скринами, кодом, логами, м.б. графиками - https://plugins.jetbrains.com/plugin/20146-mermaid помощь)
9) Под каждое ДЗ заводится своя ветка по шаблону **students/$фамилия_студента/$task_name**
10) task_name - название ДЗ уточняет преподаватель (чтобы у всех оно было одинаково)
11) Каждое ДЗ в отдельной папке (maven модуле): task1, task2 ...
12) ДЗ сдаётся в виде Pull Request'а из своей ветки из п.6 в ветку master
13) На GitHub запускается pipeline про проверке сборки ДЗ (**mvn verify**)
12) Ссылка на Pull Request (PR) сдаётся в личном кабинете Otus
13) Далее проверяющий смотрит PR и либо аппрувит, если всё хорошо, либо оставляет комментарии к PR'у. Вся история о правках кода после ревью будет оставаться в PR'е.
14) Студент итеративным подходом добивается аппрува PR'а и далее сам делает мерж в master
15) После мержа (который останется в истории) ДЗ считается зачтённым.
