import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When boost is picked up, elephant speed increases permanently
 * 
 * @author Lee
 * @version May 13
 */
public class Boost extends Actor
{
    public Boost(){
        setImage("chips-1.png");
    }
    /**
     * Act - do whatever the Boost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 20;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight()){
            world.removeObject(this);
            world.createBoost();
        }
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}
