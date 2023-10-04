import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor{
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation fallLeft;
    private Animation fallRight;
    private Animation jumpRight;
    private Animation jumpLeft;
    private String currentAction;
    String newAction;
    private String direction;
    private int jump;
    public MovableAnimatedActor(){
        direction = "right";
    }

    public void act(){
        super.act();
        if(newAction == null){
            newAction = "idle";
        }
        //this.getX() + this.getWidth() < 800
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && !isColliding2())
        {
            currentAction = "walkRight";
            setLocation(this.getX() + 5, this.getY());
            if(isBlocked()) 
                setLocation(this.getX() - 5, this.getY());
            if(isColliding2())
            {
                setLocation(this.getX() - 5, this.getY());
                setAnimation(idleRight);
            }
            if(isFalling(true))
                currentAction = "fallRight";
            direction = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && this.getX() > 0 && !isColliding2())
        {
            currentAction = "walkLeft";
            setLocation(this.getX() - 5, this.getY());
            if(isBlocked()) 
                setLocation(this.getX() + 5, this.getY());
            if(isColliding2())
            {
                setLocation(this.getX() + 5, this.getY());
                setAnimation(idleLeft);
            }
            if(isFalling(true) && !isColliding2())
                currentAction = "fallLeft";
            direction = "left";
        }
        else if((Mayflower.isKeyDown(Keyboard.KEY_UP) && isFalling(false) && this.getY() > 0))
        {
            jump = 150;
            
        }
        else if(isColliding2()){
            setLocation(this.getX(), this.getY() - 5);
            setAnimation(idleRight);
            isFalling(false);
            if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
            {
                setLocation(this.getX() + 5, this.getY());
                setAnimation(walkRight);
                direction = "right";
            }
            
            if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
            {
                setLocation(this.getX() - 5, this.getY());
                setAnimation(walkLeft);
                direction = "left";
            }
        }
        else 
        {
            currentAction = "idleRight";
            if(direction.equals("left")) 
                currentAction = "idleLeft";
            if(isFalling(true)){
                currentAction = "fallRight";
                if(direction.equals("left"))
                    currentAction = "fallLeft";
            }
        }

        if(jump < 0)
        {
            setLocation(this.getX(), this.getY() - 10);
            jump -= 10;
        }
        // set animatioms
        if(!currentAction.equals(newAction)){
            if(currentAction.equals("idleRight")){
                setAnimation(idleRight);
            }
            if(currentAction.equals("idleLeft")){
                setAnimation(idleLeft);
            }
            if(currentAction.equals("walkLeft")){
                setAnimation(walkLeft);
            }
            if(currentAction.equals("walkRight")){
                setAnimation(walkRight);
            }
            if(currentAction.equals("fallLeft")){
                setAnimation(fallLeft);
            }
            if(currentAction.equals("fallRight")){
                setAnimation(fallRight);
            }
            if(currentAction.equals("jumpRight")){
                setAnimation(jumpRight);
            }
            if(currentAction.equals("jumpLeft")){
                setAnimation(jumpLeft);
            }
            newAction = currentAction;
        }
    }

    public void setWalkRightAnimation(Animation ani){
        walkRight = ani;
    }

    public void setWalkLeftAnimation(Animation ani){
        walkLeft = ani;
    }

    public void setIdleRightAnimation(Animation ani){
        idleRight = ani;
    }

    public void setIdleLeftAnimation(Animation ani){
        idleLeft = ani;
    }

    public void setFallLeftAnimation(Animation ani){
        fallLeft = ani;
    }

    public void setFallRightAnimation(Animation ani){
        fallRight = ani;
    }
    
    public void setJumpRightAnimation(Animation ani)
    {
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani)
    {
        jumpLeft = ani;
    }
}