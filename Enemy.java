import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int health;
    private int y_velocity;
    private int x_velocity;
    private int x_vel_counter;
    private boolean alive;
    
    public Enemy(int h, int y, int x )
    {
        health = h;
        y_velocity = y;
        x_velocity = x;
        x_vel_counter = 0;    
        alive = true;
    }
    
    public void act() 
    {
        if (alive)
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
            
            // Detects bullet hit
            if(this.isTouching(Bullet.class)) {
                this.removeTouching(Bullet.class);
                if(health > 0)
                    health = health - 10;
                else
                {
                    alive = false;
                    this.getWorld().removeObject(this);
                }
            }
        }
    }    
}
