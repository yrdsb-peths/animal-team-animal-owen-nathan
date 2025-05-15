import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in.
 * 
 * @author Lee
 * @version April 2025
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int baseSpeed = 2;
    
    public boolean touching = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        setBackground("Background.jpg");
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create a label
        scoreLabel = new Label(0, 60);
        addObject(scoreLabel, 50, 50);
        
        createApple();
        
        Bomb bomb = new Bomb();
        addObject(bomb, Greenfoot.getRandomNumber(600), 0);
        
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    /**
     * Increase Score
     */
    public void increaseScore(){
       score++; 
       scoreLabel.setValue(score);
       
       if(score % 5 == 0){
           baseSpeed++;
       }
    }
    /**
     * Create a new apple at a random location at the top of the screen
     */
    public void createApple(){
        Apple apple = new Apple();
        apple.setSpeed(baseSpeed);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(apple, x, y);
    }
}
