package library;
import java.util.ArrayList;

public class Library{

    private String name;
    private ArrayList<Publication> publications = new ArrayList<>() ;

    public Library(String name){
        this.name = name;
        
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron){
        if(publicationIndex >= 0 && publicationIndex < publications.size())
            publications.get(publicationIndex).checkOut(patron);
        else
            throw new IndexOutOfBoundsException("Publication index is invalid");    
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder(name + "\n");

        for(int i = 0; i < publications.size(); i++)
            {
                info.append(i).append(") ").append(publications.get(i));

            }

        return info.toString();

    }
}