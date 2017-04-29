import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager extends Actor
{
    private int enemySpawnTimer;
    private int levelCounter;
    private int enemyCount;
    private boolean boss_alive;
    private boolean boss_spawn;
    
    private Bacon player;
    
    private GreenfootSound bgm;
    
    public GameManager(Bacon bacon) {
        enemyCount = 0;
        enemySpawnTimer = 0;
        bgm = new GreenfootSound("bike.mp3");
        player = bacon;
        boss_alive = false;
        boss_spawn = true;
    }
   
    /**
     * Act - do whatever the EnemySpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Check if the game is supposed to be running or not
        if(player.isAlive()) {
            bgm.playLoop();
            if(enemySpawnTimer > 150 && !boss_alive){
                spawn(0);
                enemyCount++;
                enemySpawnTimer = 0;
            }
            enemySpawnTimer++;
            if(enemyCount == 5){
                boss_alive = true;
                if(boss_spawn){
                    spawn(1);
                    boss_spawn = false;
                }
            }
        }
        else {
            bgm.stop();
        }
    }
    
    private void spawn(int type) {
        if(type == 0)
            this.getWorld().addObject(new Mushroom(),this.getWorld().getWidth(), getRandomNumber(10, 590));
        else if(type == 1)
            this.getWorld().addObject(new Boss_1(),this.getWorld().getWidth() - 100, 300);
        else 
            this.getWorld().addObject(new Mushroom(),this.getWorld().getWidth(), getRandomNumber(10, 590));
        }
    
    private void startGame() {
        
    }
    
    private void endGame() {
        
    }
    
    /**
     * getRandomNumber - return an integer between the given input parameters
     */
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal + start;
    }
    
    
}
