package uk.co.unitycoders.fracture.world;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldModelTest {
    private WorldModel model;

    @Test
    public void testSizeReportedCorrectly() {
        int rows = 10;
        int cols = 15;

        model = new WorldModelIpl(rows, cols);

        assertEquals(rows, model.getWidth());
        assertEquals(cols, model.getHeight());
    }

    @Test
    public void testFloorGetterSetter() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 0;
        int y = 0;
        Floor floor = new Floor(0);

        //test
        model.setFloorAt(x, y, floor);
        Floor result = model.getFloorAt(x, y);

        assertEquals(floor, result);
    }

    @Test
    public void testItemGetterSetter() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 0;
        int y = 0;
        Item item = new Item(0, false, false);

        //test
        model.setItemAt(x, y, item);
        Item result = model.getItemAt(x, y);

        assertEquals(item, result);
    }

    @Test
    public void testAvatarGetterSetter() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 0;
        int y = 0;
        Avatar avatar = new Avatar(0);

        //test
        model.setAvatarAt(x, y, avatar);
        Avatar result = model.getAvatarAt(x, y);

        assertEquals(avatar, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRowGetFloor() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 13;
        int y = 12;

        //test
        model.getFloorAt(x, y);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidColGetFloor() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 7;
        int y = 17;

        //test
        model.getFloorAt(x, y);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRowSetFloor() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 13;
        int y = 12;
        Floor demo = new Floor(0);

        //test
        model.setFloorAt(x, y, demo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidColSetFloor() {
        model = new WorldModelIpl(10, 15);

        //params
        int x = 7;
        int y = 17;
        Floor demo = new Floor(0);

        //test
        model.setFloorAt(x, y, demo);
    }
}
