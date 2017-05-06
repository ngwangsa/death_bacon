import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public Bullet() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //makes it move
        super.setLocation(super.getX() + 3, super.getY());
        if(super.getX() > getWorld().getWidth() - 10)
            this.getWorld().removeObject(this);
    }    
    /*
         * Move to the correct directory (folder).
    
    1. Open "Git Bash".
    2. Use the "cd" command to move to the repository.
        - cd = change directory
        - cd Desktop
    
    Ensure that you have the latest data.
    
    1. Use the "git pull" command
    
    How to push to the repository.
    
    1. git add .
    2. git commit -m "<ENTER THE COMMIT MESSAGE>"
    3. git push
         * 
         * 
         * 
     */
}
