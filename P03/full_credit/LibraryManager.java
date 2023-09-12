import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        Library library = new Library("My library: ");

        library.addPublication(new Publication("The Fault in Our Stars", "John Green", 2012));
        library.addPublication(new Publication("Charlie and the Chocolate Factory", "Roald Dahl", 1964));
        library.addPublication(new Publication("The Adventures of Tintin- The shooting star", "Herge", 1942));

        System.out.println("Contents: ");
        System.out.println(library);


        System.out.println("Enter index to check out book: ");
        int publicationIndex = scanner.nextInt();

        try{
            library.checkout(publicationIndex,"Ayman");
            System.out.println("\nContents after Checkjng out: ");
            System.out.println(library);
            
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Publication index is invalid");
        }

        scanner.close();

    }

}