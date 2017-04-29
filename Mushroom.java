import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Enemy
{
    public Mushroom() {
        //public Enemy(int health, int y_velocity, int x_velocity, int x_vel_counter)
        super(10,0,80);
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
        // Delete the object if it reaches the end of the screen
        if(super.getX() < 10){
            this.getWorld().removeObject(this);
            return;
        }
        
        super.act();
    }    
}
