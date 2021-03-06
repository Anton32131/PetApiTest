#language: ru
Функционал:  petstore

    #noinspection NonAsciiCharacters
  Предыстория:  добавление питомца
    * добавление  питомца в базу данных сайта
      | 5 | Барсик | кот | https://pbs.twimg.com/profile_images/948294484596375552/RyGNqDEM_400x400.jpg | черный мех | available |

  Сценарий: проверки
    * убедиться что добавлен новый питомец
    * проверяем наличие питомца с именем "Барсик"
    * проверяем наличие питомца с id "5"
    * проверяем добавление фотографий к питомцу "https://schulzmuseum.org/wp-content/uploads/2017/06/920608_FlyingAce-200.jpg"
    * проверяем добавление особенностей к питомцу "пушистый хвост"
    * проверяем добавление различных статусов
    * проверяем можно ли  получить питомца по другому id например "2"
    * проверяем можно ли в поле id ввести имя "Vasya"
    * проверяем что будет если отправить запрос без параметра

