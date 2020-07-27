package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.Tags;
import org.apache.http.HttpStatus;
import util.TestProperties;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

public class MainSteps {
    String endpoint = TestProperties.getInstance().getProperties().getProperty("endpoint");
    String endpointID = TestProperties.getInstance().getProperties().getProperty("endpointId");

    Pet pet;
    RequestSpecification requestSpec = given().log().body()
            .contentType(ContentType.JSON);

    @Step("добавляется питомец с id {0} и name {1}")
    void addPet(List<Pet> petList) {
        petList.forEach(value -> {
            this.pet = value;
            postRequest(pet);
        });

    }

    @Step("выполняется проверка питомца c именем {0}")
    void checkPet(String name) {
        getRequest(pet).body(" name", equalTo(name));
    }

    @Step("выполняется проверка питомца с id {0}")
    void checkPetId(String id) {
        given().pathParam("id", id)
                .when().get(endpointID)
                .then().log().body().statusCode(HttpStatus.SC_OK).and()
                .body("id", equalTo(Integer.parseInt(pet.getId())));
    }

    @Step("выполняется проверка питомца с id {0}")
    void checkPetAnotherId(String id) {
        given().pathParam("id", id)
                .when().get(endpointID)
                .then().log().body().assertThat()
                .body("id", not(equalTo(Integer.parseInt(pet.getId()))));
    }

    @Step("выполняется проверка ввода имени {0} в поле id ")
    void checkCanInputNameInId(String name) {
        pet.setId(name);
        requestSpec.body(pet)
                .when().post(endpoint)
                .then().log().body().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Step("выполняется проверка запроса без параметра")
    public void checkRequestNoParameter() {
        given().pathParam("id", "")
                .when().get(endpointID)
                .then().log().body().assertThat().statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);

    }

    @Step("проверка что новый питомец добавился в базу сайта")
    public void checkAddNewPet() {
        getRequest(pet).body("id", equalTo(Integer.parseInt(pet.getId())))
                .body("category.name", equalTo(pet.getCategory().getName()))
                .body("name", equalTo(pet.getName()))
                .body("photoUrls", equalTo(pet.getPhotoUrls()))
                .body("tags[0].name", equalTo(pet.getTags().get(0).getName()))
                .body("status", equalTo(pet.getStatus()));
    }

    @Step("метод проверки добавления фотографии питомца")
    public void checkAddPicture(String picture) {
        pet.setPhotoUrls(picture);
        postRequest(pet);
        getRequest(pet)
                .body("photoUrls", equalTo(pet.getPhotoUrls()));
    }

    @Step("метод проверки добавления особенностей питомцу")
    public void checkAddTags(String tags) {
        pet.setTags(new Tags("2", tags));
        postRequest(pet);
        getRequest(pet).body("tags[1].name", equalTo(pet.getTags().get(1).getName()));

    }

    @Step("метод проверки изменения статусов питомца")
    public void checkStatus() {
        pet.setStatus("sold");
        postRequest(pet);
        getRequest(pet).body("status", equalTo(pet.getStatus()));
        pet.setStatus("pending");
        postRequest(pet);
        getRequest(pet).body("status", equalTo(pet.getStatus()));

    }

    //метод get запроса
    private io.restassured.response.ValidatableResponse getRequest(Pet pet) {
        return given().pathParam("id", pet.getId())
                .when().get(endpointID)
                .then().log().body().assertThat().statusCode(HttpStatus.SC_OK).and();

    }

    // метод post запроса
    private void postRequest(Pet pet) {
        requestSpec.body(pet)
                .when().post(endpoint)
                .then().log().body().statusCode(HttpStatus.SC_OK);
    }
}