package library;
import java.time.Duration;

public class Video extends Publication{
    private Duration runtime;
    public Video(String title, String author, int copyright, int runtime){
        super(title, author, copyright);
        this.runtime = Duration.ofMinutes(runtime);

        if( runtime <= 0)
        {
            throw new InvalidRuntimeException(title, runtime);
        }
    }

    public static class InvalidRuntimeException extends ArithmeticException{
        //class is inherited from Arithmetic
        public InvalidRuntimeException(){
             super();
        }
        public InvalidRuntimeException(String s){
             super(s);
        }

        //Custom constructor 
        public InvalidRuntimeException(String title, int runtime){
            super( title + " runtime is invalid " + runtime );
        }
    }

    @Override
    public String toString(){
        return toStringBuilder("Video", "runtime "+ runtime.toMinutes()+ " minutes");
        
    }
    
}