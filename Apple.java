import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Lee
 * @version April 2025
 */
public class Apple extends Actor
{
    GreenfootSound loseSound = new GreenfootSound ("loseSound.mp3");
    public Apple(){
        GreenfootImage apple = new GreenfootImage("Apple1.png");
        apple.scale(60,60);
        setImage(apple);
        
    }
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 2;
    public void act()
    {
        // Apple falls downwards.
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight()){
            loseSound.play();
            world.gameOver();
            world.removeObject(this);
            // Remove all Bomb objects
            world.getObjects(Bomb.class).forEach(world::removeObject);
            // Remove all Boost objects
            world.getObjects(Boost.class).forEach(world::removeObject);
        }
        
        if(world.touching) {
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}
