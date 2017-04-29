import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss_1 extends Actor
{
    private int health;
    private int y_velocity;
    private int x_velocity;
    private int x_vel_counter;
    /**
     * 
     */
    public Boss_1() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*3, image.getHeight()*3);
        image.mirrorHorizontally();
        setImage(image);
        health = 100;
        y_velocity = 1;
        x_velocity = 60;
        x_vel_counter = 0;
    }
    
    /**
     * Act - do whatever the Boss_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(x_vel_counter >= 100) {
            super.setLocation(super.getX() - 1, super.getY());
            x_vel_counter = 0;
        }
        else 
            x_vel_counter += x_velocity;
        if(super.getY() < 20)
            y_velocity = 1;
        if(super.getY() > 580)
            y_velocity = -1;
        super.setLocation(super.getX(), super.getY() + y_velocity);
        
        // Move the object to the beginning of the screen if touches the end before dying.
        if(super.getX() < 10){
            super.setLocation(this.getWorld().getWidth() - 5, super.getY());
        }
            
        // Detects bullet hit
        if(this.isTouching(Bullet.class)) {
            this.removeTouching(Bullet.class);
            if(health > 0)
                health = health - 10;
            else
                this.getWorld().removeObject(this);
        }
    }    
}
