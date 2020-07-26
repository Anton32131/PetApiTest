package steps;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableRowTransformer;
import model.Category;
import model.Pet;
import model.Tags;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return new Locale("ru");
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(
                Pet.class,
                (TableRowTransformer<Pet>) list -> {
                    Pet pet = new Pet();
                    pet.setId(list.get(0));
                    pet.setName(list.get(1));
                    pet.setCategory(new Category("1",list.get(2)));
                    pet.setPhotoUrls(list.get(3));
                    pet.setTags(new Tags("1", list.get(4)));
                    pet.setStatus(list.get(5));
                    return pet;
                }
        ));
    }
}

