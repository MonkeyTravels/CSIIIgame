import mayflower.*;

public class GravityActor extends Actor{
    public GravityActor(){
        
    }
    public void act(){
        setLocation(this.getX(), this.getY() + 1);
        if(isBlocked()) setLocation(this.getX(), this.getY() - 1);
    }
    public boolean isBlocked(){
        return isTouching(Block.class);
    }
    public boolean isFalling(boolean b){
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 10);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 10);
        return !ret;
    }
    public boolean isJumping(){
        boolean ret;
        setLocation(getX(), getY() - 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() + 1);
        return !ret;
    }
    public boolean isColliding()
    {
        return isTouching(Cat.class);
    }
    public boolean isColliding2()
    {
        return isTouching(Dog.class);
    }
}
