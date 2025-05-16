import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Lee
 * @version April 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("Background.jpg");
        addObject(titleLabel, getWidth()/3 + 20, 120);
        prepare();
    }

    /** 
     * The main world act loop
     */
    public void act(){
        // Starts game when user presses space
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,456,116);
        Label label = new Label("Press Space to Start", 40);
        addObject(label,292,213);
        Label label2 = new Label("Use \u2190 and \u2192 to catch the apple", 40);
        addObject(label2,299,250);
        Label label3 = new Label("Collect fries for speed boost", 40);
        addObject(label3,301,286);
        Label label4 = new Label("Dodge the bombs!", 40);
        addObject(label4,317,328);
    }
}
