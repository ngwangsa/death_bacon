import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        this.setBackground("space_bg.jpg");
        
        // Add an actor to the world.
        Bacon bacon = new Bacon();
        super.addObject(bacon, 100, 300);
        
        // Enemy Spawner
        GameManager gm = new GameManager(bacon);
        super.addObject(gm, 0, 0);
    }

}
