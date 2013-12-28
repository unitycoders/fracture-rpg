package uk.co.unitycoders.fracture.world;

/**
 * Created by webpigeon on 28/12/13.
 */
public interface WorldModel {

    /**
     * get the floor at a given location on the model
     *
     * @param x the x co-ordinate
     * @param y the y co-ordinate
     * @return the floor at the given location, null if unknown or not set
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public Floor getFloorAt(int x, int y);

    /**
     * set the floor at a given location on the model
     *
     * @param x     the x co-ordinate
     * @param y     the y co-ordinate
     * @param floor the new floor to be set
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public void setFloorAt(int x, int y, Floor floor);

    /**
     * get the item at a given location on the model
     *
     * @param x the x co-ordinate
     * @param y the y co-ordinate
     * @return the item at the given location, null if unknown or not set
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public Item getItemAt(int x, int y);

    /**
     * set the item at a given location on the model
     *
     * @param x    the x co-ordinate
     * @param y    the y co-ordinate
     * @param item the new item for the given location
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public void setItemAt(int x, int y, Item item);

    /**
     * get the avatar at a given location on the model
     *
     * @param x the x co-ordinate
     * @param y the y co-ordinate
     * @return the avatar at the given location, null if unknown or not set
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public Avatar getAvatarAt(int x, int y);

    /**
     * set the avatar at a given location on the model
     *
     * @param x      the x co-ordinate
     * @param y      the y co-ordinate
     * @param avatar the new avatar for the given location
     * @throws java.lang.IllegalArgumentException if x or y is out of range
     */
    public void setAvatarAt(int x, int y, Avatar avatar);

    /**
     * get the width of the world
     *
     * @return the width of the current world
     */
    public int getWidth();

    /**
     * get the height of the world
     *
     * @return the height of the current world
     */
    public int getHeight();
}
