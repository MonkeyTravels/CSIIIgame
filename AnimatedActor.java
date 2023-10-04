import mayflower.*;

public class AnimatedActor extends GravityActor{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor() 
    {
    }
    public void setAnimation(Animation a){
        animation = a;
        animationTimer = new Timer(50000000);
    }
    
    public void act()
    {
        if(animation == null){
            return;
        }
        if(animationTimer.isDone()){
            animationTimer.reset();
            setImage(animation.getNextFrame());
        }
        super.act();
    }
}