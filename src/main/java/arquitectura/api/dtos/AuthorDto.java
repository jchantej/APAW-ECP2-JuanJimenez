package arquitectura.api.dtos;

import arquitectura.api.entities.Author;

public class AuthorDto {
    
    private long authorId;

    private String authorName;

    private String authorLanguage;

    public AuthorDto() {    
    }

    public AuthorDto(Author author) {
        authorId = author.getId();
        authorName = author.getName();
        authorLanguage ="Español";
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLanguage() {
        return authorLanguage;
    }

    public void setAuthorLanguage(String authorLanguage) {
        this.authorLanguage = authorLanguage;
    }

    @Override
    public String toString() {

        return "{\"id\":" + authorId + ",\"name\":\"" + authorName + ",\"language\":\"" + authorLanguage + "\"}";
    }

}
