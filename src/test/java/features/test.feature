#language: ru
@Test
  Функционал: Тестовый
@SignIn
  Сценарий: Авторизация

    И Открываем страницу "Главная"
    И на странице "Главная" нажимаем кнопку "Войти"
    И на странице "Главная" заполняем форму "Логин" данными "yilana1117@tmajre.com"
    И на странице "Главная" заполняем форму "Пароль" данными "n7lanit12345"
    И на странице "Главная" нажимаем кнопку "Отправить"
  
@AddMessage
    Сценарий: Отправка сообщения во вкадке Темы

      Если авторизация прошла успешно
      Тогда на странице "Главная" кликаем "заголовок" из "Список Тем" не являющейся "Опрос"
      И на странице "Топик" нажимаем кнопку "Ответить"
      И на странице "Топик" вводим в форму текст "карабли лавировали,лавировали, да..."
      И на странице "Топик" нажимаем кнопку "Отправить ответ"
      Если на странице "Топик" сообщение "карабли лавировали,лавировали, да..." отобразилось
     Тогда на странице "Топик" переходим на вкладку "Темы"
@AddMessage
    Сценарий: Повторная отправка сообщения во вкадке Темы

      Тогда на странице "Главная" кликаем "заголовок" из "Список Тем" не являющейся "Опрос"
      И на странице "Топик" нажимаем кнопку "Ответить"
      И на странице "Топик" вводим в форму текст "карабли лавировали,лавировали, да вылавировали"
      И на странице "Топик" нажимаем кнопку "Отправить ответ"
      Если на странице "Топик" сообщение "карабли лавировали,лавировали, да вылавировали" отобразилось
      Тогда на странице "Топик" переходим на вкладку "Темы"

    @AddSubscribe
     Сценарий: Если авторизация прошла успешно
      Тогда на странице "Главная" выбираем тему из "Список Тем" нажимаем на кнопку "Неактивна" и выбираем "Подписаться"
       И на странице "Главная" выбираем тему из "Список Тем" нажимаем на кнопку "Неактивна" и выбираем "Подписаться"
       И на странице "Главная" переходим на вкладку "Подписки"
        И на странице "Подписок" в "Списке подписок" проверяем подписки
      И на странице "Подписок" в "Списке подписок" на каждой нажимаем "кнопка подписки" и выбераем "Отписаться"



