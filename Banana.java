import mayflower.*;

public class Banana extends Actor
{
    

    public Banana()
    {
        setImage("img/Object/Banana.gif");
    }
    
    public void act()
    {
        if(isTouching(Cat.class))
        {
           Object a = getOneIntersectingObject(Cat.class);
           Cat c = (Cat) a;
           World w = getWorld();
           w.removeObject(this);
           c.increaseScore(1);
        }
        if(isTouching(Dog.class))
        {
           Object b = getOneIntersectingObject(Dog.class);
           Dog d = (Dog) b;
           World w = getWorld();
           w.removeObject(this);
           d.increaseScore(1);
        }
    }
}