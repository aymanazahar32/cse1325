
package mdi;
import java.util.Scanner;
import library.Publication;
import library.Publication.InvalidCheckInException;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;


/**
 * Main class that manages the library operation
 */
public class LibraryManager{
    /**
     * the main method where execution begins
     * @param args      Command line argument. Not used in this method.
     */
    public static void main(String[] args){
        
        Library library = new Library("UTA Central Library");
        
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));
       
        Scanner scanner = new Scanner (System.in);
        //scanner.nextLine();
        while( true){
            menu();
            int choice =  scanner.nextInt();
            switch(choice) {
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    list(library);
                    break;
                case 2:
                    addPublication(library, scanner);
                    break;
                case 3:
                    addVideo(library, scanner);
                    break;
                case 4:
                    checkingOut(library, scanner);
                    break;
                case 5:
                    checkingIn(library, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
            //scanner.close();
        }
        //scanner.close();
    }

        static void menu(){
            System.out.println("=========\nMain Menu\n=========");
            System.out.println("UTA Central Library");
            System.out.println("0)Exit\n1)List\n2)Add Publication\n3)Add Video\n4)Check out\n5)Check in");
        }

        static void list(Library library){
            System.out.println(library);
        }

        static void addPublication(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.print("Enter the title of the Publication: ");
            String title = scanner.nextLine();
            System.out.print("Enter the author of the Publication: ");
            String author = scanner.nextLine();
            System.out.print("Enter the copyright year of the Publication: ");
            int copyright = scanner.nextInt();
            scanner.nextLine();

            Publication publication = new Publication(title, author, copyright);
            library.addPublication(publication);
            System.out.println("Publication added successfully!");
        }

        static void addVideo(Library library, Scanner scanner) {
            scanner.nextLine();
            System.out.print("Enter the title of the Video: ");
            String title = scanner.nextLine();
            
            System.out.print("Enter the director of the Video: ");
            String director = scanner.nextLine();
            System.out.print("Enter the copyright year of the Video: ");
            int copyright = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter the runtime of the Video (in minutes): ");
            int runtime = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            try {
                Video video = new Video(title, director, copyright, runtime);
                library.addPublication(video);
                System.out.println("Video added successfully!");
            } catch (Video.InvalidRuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        static void checkingOut(Library library, Scanner scanner){
            //scanner = new Scanner (System.in);
            scanner.nextLine();
            System.out.print("Which book to check out? ");
            int index = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Who are you? ");
            String patronName = scanner.nextLine();
            //scanner.close();
                try {
                    library.checkOut(index, patronName);
            
                    } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid publication index");
                    } catch (InvalidRuntimeException e){
                    System.out.println(e.getMessage());    
                    }
            
        }

        static void checkingIn(Library library, Scanner scanner){
            scanner.nextLine();
            System.out.print("Which book to check in? ");
            int index = scanner.nextInt();
            scanner.nextLine();

            
            //scanner.close();
            try {
                //library.checkOut(index, patron );
                library.checkIn(index);
            
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid publication index");
                } catch (InvalidRuntimeException e){
                System.out.println(e.getMessage());
                } catch (InvalidCheckInException e){
                System.out.println(e.getMessage());    
            }
            
        }



        
        /*System.out.println(library);

        Scanner scanner = new Scanner (System.in);
        System.out.print("Which book to check out? ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Who are you? ");
        String patronName = scanner.nextLine();
        scanner.close();
        //try {
        library.checkOut(index, patronName);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index");
        } catch (InvalidRuntimeException e){
            System.out.println(e.getMessage());    
        }
    
        System.out.println(library);*/
        
    
}
