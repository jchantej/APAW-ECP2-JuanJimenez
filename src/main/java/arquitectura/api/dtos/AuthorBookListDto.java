package arquitectura.api.dtos;

import java.util.List;

import arquitectura.api.entities.Author;

public class AuthorBookListDto {

    private AuthorDto authorDto;

    private List<Integer> isbnList;
    
    public AuthorBookListDto() {
        super();

    }
      
    public AuthorBookListDto(Author author, List<Integer> isbnList) {
        this.authorDto = new AuthorDto(author);
        this.isbnList = isbnList;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public List<Integer> getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(List<Integer> isbnList) {
        this.isbnList = isbnList;
    }

    @Override
    public String toString() {
 
        return "{" + authorDto + "," + isbnList + "}";
    }
        

}
