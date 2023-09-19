package library;
import java.time.LocalDate;



public class Publication{

    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright){
        int currentYear = LocalDate.now().getYear();
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Copyright year is invalid");

        this.title = title;
        this.author = author;
        this.copyright = copyright;


    }

    public void checkOut(String patron){
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    protected String toStringBuilder(String pre, String mid){
        StringBuilder stringInfo = new StringBuilder(pre);

        stringInfo.append("\"").append(title).append("\" author ").append(author).append(" ,copyright: ").append(copyright);
        
        if(mid != null)
            {
                stringInfo.append(", ").append(mid);
            }
        if(loanedTo != null)
            {
                stringInfo.append("\n    :").append(" loaned to ").append(loanedTo).append(" until ").append(dueDate);
            }

        stringInfo.append("\n");
        return stringInfo.toString();
    }

    @Override
    public String toString(){
        return toStringBuilder("Book", "");    
    }
    
}