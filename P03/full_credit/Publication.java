import java.time.LocalDate; 

class Publication{

    private String title;
    private String author;
    private int copyright; 
    private String loanedTo; 
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright)
    {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
        {
            throw new IllegalArgumentException("Copyright year is invalid");
        }

        this.title = title; 
        this.author = author; 
        this.copyright = copyright; 
    }

    public void checkOut(String patron){

        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }


    @Override
    public String toString(){
        String publicationInfo = "Title: " + title + "\nAuthor: " + author + "\nCopyright: " + copyright;
        
        if(loanedTo != null)
        {
            publicationInfo += "\nLoaned to: " + loanedTo + "\nDue Date: " + dueDate;
        }
        return publicationInfo;
    }

}
