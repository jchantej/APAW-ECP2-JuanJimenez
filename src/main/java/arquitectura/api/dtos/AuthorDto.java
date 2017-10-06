package arquitectura.api.dtos;

import arquitectura.api.entities.Author;

public class AuthorDto {
    
    private long id;
    private String name;
    private String language;

    public AuthorDto() {
    }

    public AuthorDto(Author author) {
        id = author.getId();
        name = author.getName();
        language = author.getLanguage();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
   
        return "{\"id\":" + id + ",\"name\":\"" + name + ",\"language\":\"" + language + "\"}";
    }

}
