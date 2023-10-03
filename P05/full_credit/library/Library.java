package library;
import java.util.ArrayList;


/**
 * Library class for a collection of publications 
 */
public class Library{

    private String name;
    private ArrayList<Publication> publications = new ArrayList<>() ;
    /**
     * 
     * @param name      name of the Library
     */
    public Library(String name){
        this.name = name;
        //this.publication  
    }
    /**
     *
     * @param publication   the publication of the library. 
     */
    public void addPublication(Publication publication){
        publications.add(publication);
    }
    /**
     * 
     * @param publicationIndex              Index of the publication to check out.
     * @param patron                        Name of the Patron checking out.
     * @throws IndexOutOfBoundsException     publication index is invalid.                                                                 
     */
    public void checkOut(int publicationIndex, String patron){
        if(publicationIndex >= 0 && publicationIndex < publications.size())
            publications.get(publicationIndex).checkOut(patron);
        else
            throw new IndexOutOfBoundsException("Invalid publication index, Try Again");    
    }

    public void checkIn( int publicationIndex){
        publications.get(publicationIndex).checkIn();

    }

    /**
     * 
     * @return    a String containing the list of library publications.
     */
    @Override
    public String toString(){
        StringBuilder info = new StringBuilder(name + "\n");

        for(int i = 0; i < publications.size(); i++){
            info.append(i).append(") ").append(publications.get(i));

        }
        return info.toString();

    }
}