package library;
import java.time.LocalDate;

/**
 * Represents a publication
 */

public class Publication{


    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;
    /**
     * Constructs a new publication using the specified title, author and copyright . 
     * @param title         The title of the publication
     * @param author        The author of the publication
     * @param copyright     The copyright of the publication
     */

     public class InvalidCheckInException extends RuntimeException {
        public InvalidCheckInException(String message) {
            super(message);
        }
    }
    public Publication(String title, String author, int copyright){
        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Invalid copyright year");

        this.title = title;
        this.author = author;
        this.copyright = copyright;


    }
    /**
     * 
     * @param patron        name of the patron who checks out the publication.
     * 
     */

    public void checkOut(String patron){
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void checkIn(){
        if ( loanedTo == null || dueDate == null){
            throw new InvalidCheckInException("Publication index is not checked out");
        }
        loanedTo = null;
        dueDate = null;
    }    
    /**
     *  
     * @param pre       Prefix for book or video
     * @param mid       Further publishing info
     * @return          string representing the publication. 
     */

    protected String toStringBuilder(String pre, String mid){
        StringBuilder stringInfo = new StringBuilder(pre);

        stringInfo.append(" \"").append(title).append("\" by the author ").append(author).append(" ,copyright: ").append(copyright);
        
        if(mid != null){
            stringInfo.append(", ").append(mid);
        }
        if(loanedTo != null){
            stringInfo.append("\n    :").append(" loaned to").append(loanedTo).append(" until ").append(dueDate);
        }

        stringInfo.append("\n");
        return stringInfo.toString();
    }
    /**
     * 
     * @return a string containing details of the book.
     */

    @Override
    public String toString(){
        return toStringBuilder("Book", "");    
    }
    
}