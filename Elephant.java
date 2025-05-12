import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Lee
 * @version April 2025
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[9];
    GreenfootImage[] idleLeft = new GreenfootImage[9];
    
    // Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - Runs one time whne object is created
     */
    
    public Elephant(){
        for(int i = 0; i < 9; i ++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(80,80);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80,80);
        }
        
        animationTimer.mark();
         
        //Initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the object
     */
    int imageIndex = 0;
    public void animateElephant(){
        if(animationTimer.millisElapsed()< 100){
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")){
            move(-4);
            facing = "left";
        } else if (Greenfoot.isKeyDown("right")){
            move(4);
            facing = "right";
        }
        
        // Remove apple if elephant eats it
        eat();
        
        // Animate the elephant
        
        animateElephant();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
        
    }
}
