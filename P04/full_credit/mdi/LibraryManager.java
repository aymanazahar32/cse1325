 package mdi;
import java.util.Scanner;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;



public class LibraryManager{
    public static void main(String[] args){
        Library library = new Library("UTA Central Library");

        library.addPublication(new Publication("The Fault in Our Stars", "John Green", 2012));
        library.addPublication(new Publication("Charlie and the Chocolate Factory", "Roald Dahl", 1964));
        library.addPublication(new Publication("The Adventures of Tintin- The shooting star", "Herge", 1942));
        library.addPublication(new Video("The Dark Knight", "Christopher Nolan", 2008, 152));
        library.addPublication(new Video("Oppenheimer", "Christopher Nolan", 2023, 180));
        library.addPublication(new Video("Scarface", "Brian De Palma", 1983,170));



        System.out.println(library);

        Scanner scanner = new Scanner (System.in);
        System.out.print("Which book to check out? ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Who are you? ");
        String patronName = scanner.nextLine();

        try {
            library.checkOut(index, patronName);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index");
        } catch (InvalidRuntimeException e){
            System.out.println(e.getMessage());    
        }
        scanner.close();

        System.out.println(library);

        
    }

}