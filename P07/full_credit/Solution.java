import java.lang.Comparable;

public class Solution implements Comparable<Solution>
{ 
    public Solution(String name, String word, int x, int y, Direction direction) 
    {
        this.name = name;
        this.word = word;
        this.x = x;
        this.y = y;;
        this.direction = direction;
    }

    @Override
    public int compareTo(Solution sol)
    {
         
        if(this.name.equals(sol.name) == true)
        {
            return this.word.compareTo(sol.word);
        }
        else
        {
            return this.name.compareTo(sol.name);
        }
    }

    @Override
    public String toString() 
    {
        return String.format(" %s: %s found at (%d,%d,%s)", name, word, x, y, direction);
    }

    private String name;
    private String word;
    private int x;
    private int y;
    private Direction direction;
}
