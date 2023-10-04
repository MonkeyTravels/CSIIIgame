import mayflower.*;

public class Dog extends SecondMoveAniAct
{
    private Animation walkRight;
    private Animation idleRight;
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private int score;
    private int lives;
    
    public Dog() 
    {
        String[] walkRightImages = new String[10];
        for (int i = 0; i < walkRightImages.length; i++){
            walkRightImages[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        walkRight = new Animation(50000000, walkRightImages);
        walkRight.scale(100, 87);
        walkRight.setTransparency(0);
        walkRight.setBounds(18, 5, 54, 80);
        
        String[] idleImages = new String[10];
        for (int i = 0; i < idleImages.length; i++){
            idleImages[i] = "img/dog/Idle (" + (i + 1) + ").png";
        }
        idleRight = new Animation(50000000, idleImages);
        idleRight.scale(100, 87);
        idleRight.setTransparency(0);
        idleRight.setBounds(18, 5, 54, 80);
        
        idleLeft = new Animation(50000000, idleImages);
        idleLeft.scale(100, 87);
        idleLeft.setTransparency(0);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        
        walkLeft = new Animation(50000000, walkRightImages);
        walkLeft.scale(100, 87);
        walkLeft.setTransparency(0);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        setWalkRightAnimation(walkRight);
        setIdleRightAnimation(idleRight);
        setWalkLeftAnimation(walkLeft);
        setIdleLeftAnimation(idleLeft);
        
        String[] fallingImages = new String[8];
        for (int i = 0; i < fallingImages.length; i++){
            fallingImages[i] = "img/dog/Fall (" + (i + 1) + ").png";
        }
        fallRight = new Animation(50000000, fallingImages);
        fallRight.scale(100, 87);
        fallRight.setBounds(13, 2, 54, 82);
        setFallRightAnimation(fallRight);
        
        fallLeft = new Animation(50000000, fallingImages);
        fallLeft.scale(100, 87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(33, 2, 54, 82);
        setFallLeftAnimation(fallLeft);
        
        setAnimation(fallLeft);
    }
    
    public void increaseScore(int amount)
    {
        score += amount;
        updateText();
    }
    
    public void decreaseLives(int amount)
    {
        lives -= amount;
        updateText();
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    private void updateText()
    {
       World w = getWorld();
       w.removeText(10, 30);
       w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    public void act()
    {
        super.act();
    }
}
