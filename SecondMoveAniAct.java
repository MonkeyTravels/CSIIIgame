import mayflower.*;
public class SecondMoveAniAct extends AnimatedActor{
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation fallLeft;
    private Animation fallRight;
    private String currentAction;
    String newAction;
    private String direction;
    public SecondMoveAniAct(){
        direction = "right";
    }

    public void act(){
        super.act();
        if(newAction == null){
            newAction = "idle";
        }

        if(Mayflower.isKeyDown(Keyboard.KEY_D))
        {
            currentAction = "walkRight";
            setLocation(this.getX() + 5, this.getY());
            if(isBlocked()) 
                setLocation(this.getX() - 5, this.getY());
            if(isColliding())
                setLocation(this.getX() -5, this.getY());
            if(isFalling(true))
                currentAction = "fallRight";
            direction = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_A) && this.getX() > 0)
        {
            currentAction = "walkLeft";
            setLocation(this.getX() - 5, this.getY());
            if(isBlocked()) 
                setLocation(this.getX() + 5, this.getY());
            if(isColliding())
            {
                setLocation(this.getX() + 5, this.getY());
                setAnimation(idleLeft);
            }
            if(isFalling(true))
                currentAction = "fallLeft";
            direction = "left";
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
}
