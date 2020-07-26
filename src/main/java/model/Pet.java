package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {
    private String id;
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<Tags> tags = new ArrayList<>();
    private String status;

    public Pet(String id, Category category, String name, List<String> photoUrls, List<Tags> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {

    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls.add(photoUrls);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags.add(tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) &&
                Objects.equals(category, pet.category) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(photoUrls, pet.photoUrls) &&
                Objects.equals(tags, pet.tags) &&
                Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, photoUrls, tags, status);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pet{");
        sb.append("id='").append(id).append('\'');
        sb.append(", category=").append(category);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tags=").append(tags);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
