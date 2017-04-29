import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{
    public Mushroom() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/15, image.getHeight()/15);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Poison wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.setLocation(super.getX() - 1, super.getY());
        
        // Delete the object if it reaches the end of the screen
        if(super.getX() < 10){
            this.getWorld().removeObject(this);
            return;
        }
            
        // Detects bullet hit
        if(this.isTouching(Bullet.class)) {
            this.removeTouching(Bullet.class);
            this.getWorld().removeObject(this);
        }
    }    
}
