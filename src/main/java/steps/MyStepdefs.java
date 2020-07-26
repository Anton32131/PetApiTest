package steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import model.Pet;

import java.util.List;

public class MyStepdefs {
    MainSteps mainSteps = new MainSteps();

    @Тогда("проверяем наличие питомца с именем {string}")
    public void checkPet(String name) {
        mainSteps.checkPet(name);
    }

    @Тогда("проверяем наличие питомца с id {string}")
    public void checkPetId(String id) {
        mainSteps.checkPetId(id);
    }

    @Тогда("проверяем можно ли  получить питомца по другому id например {string}")
    public void checkPetAnotherId(String id) {
        mainSteps.checkPetAnotherId(id);
    }

    @Тогда("проверяем можно ли в поле id ввести имя {string}")
    public void checkCanInputNameInId(String name) {
        mainSteps.checkCanInputNameInId(name);
    }

    @Тогда("проверяем что будет если отправить запрос без параметра")
    public void checkRequestNoParametr() {
        mainSteps.checkRequestNoParameter();
    }

    @Дано("добавление  питомца в базу данных сайта")
    public void addPet(List<Pet> list) {
        mainSteps.addPet(list);
    }

    @Тогда("убедиться что добавлен новый питомец")
    public void checkAddNewPet() {
        mainSteps.checkAddNewPet();
    }

    @Тогда("проверяем добавление фотографий к питомцу {string}")
    public void checkAddPicture(String picture) {
        mainSteps.checkAddPicture(picture);
    }

    @Тогда("проверяем добавление особенностей к питомцу {string}")
    public void checkAddTags(String tags) {
        mainSteps.checkAddTags(tags);
    }
}
