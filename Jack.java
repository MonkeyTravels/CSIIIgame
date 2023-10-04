import mayflower.*;

public class Jack extends AnimatedActor
{
    private Animation idle;
    
    public Jack() 
    {
        String[] images = new String[10];
        for (int i = 0; i < images.length; i++){
            images[i] = "img/jack/Idle (" + (i + 1) + ").png";
        }
        idle = new Animation(50000000, images);
        idle.scale(80, 60);
        
        super.setAnimation(idle);
    }
    public void act()
    {
        super.act();
        if(isTouching(Cat.class))
        {
           Object a = getOneIntersectingObject(Cat.class);
           Cat c = (Cat) a;
           World w = getWorld();
           w.removeObject(this);
           c.decreaseLives(1);
        }
        if(isTouching(Dog.class))
        {
           Object b = getOneIntersectingObject(Dog.class);
           Dog d = (Dog) b;
           World w = getWorld();
           w.removeObject(this);
           d.decreaseLives(1);
        }
    }
}