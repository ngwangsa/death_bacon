import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lizard extends Enemy
{
    
    /**
     * 
     */
    public Lizard() {
        //public Enemy(int health, int y_velocity, int x_velocity) 
        super(100,1,60);
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*3/2, image.getHeight()*3/2);
        image.mirrorHorizontally();
        setImage(image);
    }
    
    /**
     * Act - do whatever the Boss_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Move the object to the beginning of the screen if touches the end before dying.
        if(super.getX() < 10){
            super.setLocation(this.getWorld().getWidth() - 5, super.getY());
        }
            
        super.act();
    }
        
}    

