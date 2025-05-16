import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int y = -5;
    private int num;    
    
    public Bomb() {
        GreenfootImage bomb = new GreenfootImage("images/bomb.png");
        bomb.scale(60, 60);
        setImage(bomb);
    }
    
    public void act()
    {
        // Apple falls downwards.
        int x = getX();
        int y = getY() + 5;
        setLocation(x,y);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight()){
            resetBomb();
        }
        
        if(isTouching(Elephant.class)) {
            Elephant elephant = (Elephant)getOneIntersectingObject(Elephant.class);
            world.gameOver();
            world.removeObject(this);
            world.removeObject(elephant);
            world.touching = true;
            world.removeObjects(world.getObjects(Boost.class));
            world.removeObjects(world.getObjects(Apple.class));
        }
    }
    
    public void resetBomb(){
        num = Greenfoot.getRandomNumber(2);
        if(num == 0){
            setLocation(Greenfoot.getRandomNumber(600),0);
        } else{
            setLocation(Greenfoot.getRandomNumber(600),0);
        }
        
    }
}
