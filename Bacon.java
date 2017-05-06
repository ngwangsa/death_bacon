import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bacon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bacon extends Actor
{
    private boolean alive;
    private int timer = 0;
    //initializes stuff
    public Bacon() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        alive = true;
    }
    
    /**
     * Act - do whatever the Bacon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //checks if alive
        if(alive) {
            //movement
            if (Greenfoot.isKeyDown("up")) {
                super.setLocation(super.getX(), super. getY()-1);
            }
            if (Greenfoot.isKeyDown("down")) {
                super.setLocation(super.getX(), super. getY()+1);
            }
            if (Greenfoot.isKeyDown("left")) {
                super.setLocation(super.getX()-2, super. getY());
            }
            if (Greenfoot.isKeyDown("right")) {
                super.setLocation(super.getX()+2, super. getY());
            }
            if (Greenfoot.isKeyDown("space")) {
                shoot();
            }
            
            // Detects enemy hit
            if(this.isTouching(Enemy.class)) {
                this.setImage("bacon.gif");
                this.removeTouching(Mushroom.class);
                GreenfootImage image = getImage();
                image.scale(image.getWidth()/4, image.getHeight()/4);
                setImage(image);
                alive = false;
                GreenfootSound die = new GreenfootSound("pig_die.mp3");
                die.play();
            }
                    
            // Attack timer
            timer++;
        }
        
        
    }    
    
    public void shoot() {
            //allows to shoot
            if(timer > 100) {
                this.getWorld().addObject(new Bullet(),super.getX() + 3, super.getY());
                timer = 0;
            }
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public void die() {
        
    }
}
