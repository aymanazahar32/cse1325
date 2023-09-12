import java.util.ArrayList;
import java.util.List;

class Library{


    private String name; 
    private List<Publication> publications;

    public Library(String name){
        this.name = name; 
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkout(int publicationIndex, String patron){
        if (publicationIndex >= 0 && publicationIndex < publications.size())
        {
            Publication publication = publications.get(publicationIndex);
            publication.checkOut(patron);
        }
        else
        {
            throw new IndexOutOfBoundsException("Publication index is invalid");
        }
    }

    @Override
    public String toString()
    {
        StringBuilder libraryInfo = new StringBuilder();
        libraryInfo.append("Library name: ").append(name).append("\n");

        for(int i = 0; i < publications.size(); i++)
        {
            Publication publication = publications.get(i); 
            libraryInfo.append(i).append(": ").append(publication).append("\n");
        }

        return libraryInfo.toString();
    }
}