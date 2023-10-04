import mayflower.*;
public class Animation{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    
    public Animation(int frameTime, String[] imageArray){
        frames = new MayflowerImage[imageArray.length];
        framerate = frameTime;
        
        
        for (int i = 0; i < imageArray.length; i++){
            frames[i] = new MayflowerImage(imageArray[i]);
        }
    }
    
    public int getFrameRate(){
        return framerate;
    }
    public MayflowerImage getNextFrame(){
        currentFrame++;
        return frames[currentFrame%(frames.length-1)];
    }
    public void scale(int w, int h){
        for (int i = 0; i < frames.length; i++){
            frames[i].scale(w, h);
        }
    }
    public void setTransparency(int percent){
        for (int i = 0; i < frames.length; i++){
            frames[i].setTransparency(percent);
        }
    }
    public void mirrorHorizontally(){
        for (int i = 0; i < frames.length; i++){
            frames[i].mirrorHorizontally();
        }
    }
    public void setBounds(int x, int y, int w, int h){
        for (int i = 0; i < frames.length; i++){
            frames[i].crop(x, y, w, h);
        }
    }
}