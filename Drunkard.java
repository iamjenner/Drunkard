import java.util.Random;

public class Drunkard{

    private int xLocation;
    private int yLocation;
    private int initialX;
    private int initialY;
    private Random generator;

    public Drunkard(int x, int y){
        xLocation = x;
        initialX = x;
        initialY = y;
        yLocation = y;
        generator = new Random();
    }

    /* step is a method that moves the drunkard to the next randomly chosen adjacent intersection
     */
    public void step(){
        int direction = 1 + generator.nextInt(4); // generates a random number between 1-4
        /* 1 = up one avenue
         * 2 = down one avenue
         * 3 = up one street
         * 4 = down one street
         */
        if(direction == 1){
            xLocation++;
        } else if(direction == 2){
            xLocation--;
        } else if(direction == 3){
            yLocation++;
        } else{
            yLocation--;
        }

    }

    /*  fastForward is a method that moves the drunkard steps intersections from his current location
        @param steps number of intersections to move
     */
    public void fastForward(int steps){
        for(int i = 1; i <= steps; i++){
            step();
        }
    }

    /* getLocation is a method that returns the drunkard’s current location
     */
    public String getLocation(){
        return "(" + xLocation + " ," + yLocation + ")";
    }

    /* the howFar method reports the drunkards distance in blocks from where he started calculated 
     * using the Manhattan distance metric.
     */
    public int howFar(){
        return Math.abs(initialX - xLocation) + Math.abs(initialY - yLocation);
    }
}
