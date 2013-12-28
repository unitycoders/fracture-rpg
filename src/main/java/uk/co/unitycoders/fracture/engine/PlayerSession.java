package uk.co.unitycoders.fracture.engine;

/**
 * Created by webpigeon on 28/12/13.
 */
public interface PlayerSession {

    public void moveNorth();
    public void moveSouth();
    public void moveEast();
    public void moveWest();

    public void pickUp();
    public void use();
}
