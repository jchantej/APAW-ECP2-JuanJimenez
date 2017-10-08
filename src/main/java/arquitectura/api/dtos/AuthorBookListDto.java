package arquitectura.api.dtos;

import java.util.List;

public class AuthorBookListDto {

    private AuthorDto authorDto;

    private List<Integer> isbnList;
    
    public AuthorBookListDto() {
        super();

    }
    
    public AuthorBookListDto(AuthorDto authorDto, List<Integer> isbnList) {
        super();
        this.authorDto = authorDto;
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
        return "AuthorBookListDto [authorDto=" + authorDto + ", isbnList=" + isbnList + "]";
    }
        

}
