package uk.co.unitycoders.fracture.world;

import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
class WorldModelIpl implements WorldModel {
    private final Cell[] cells;
    private final Avatar[] avatars;
    private final Dimension size;

    public WorldModelIpl(int rows, int cols, Cell[] cells) {
        this.cells = cells;
        this.avatars = new Avatar[rows * cols];
        this.size = new Dimension(rows, cols);
    }

    public WorldModelIpl(int rows, int cols) {
        this(rows, cols, new Cell[rows * cols]);
        initCells();
    }

    private void initCells() {
        for (int i=0; i<size.width; i++) {
            for (int j=0; j<size.height; j++) {
                Cell cell = new Cell();
                cell.point = new WorldPoint(i, j);
                cells[posToInt(i,j)] = cell;
            }
        }
    }

    @Override
    public Floor getFloorAt(int x, int y) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        return cells[posToInt(x, y)].floor;
    }

    @Override
    public void setFloorAt(int x, int y, Floor floor) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        cells[posToInt(x, y)].floor = floor;
    }

    @Override
    public Item getItemAt(int x, int y) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        return cells[posToInt(x, y)].item;
    }

    @Override
    public void setItemAt(int x, int y, Item item) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        cells[posToInt(x, y)].item = item;
    }

    @Override
    public Avatar getAvatarAt(int x, int y) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        return avatars[posToInt(x, y)];
    }

    @Override
    public void setAvatarAt(int x, int y, Avatar avatar) {
        if (!checkValues(x, y)) {
            throw new IllegalArgumentException("Invalid range for x or y");
        }
        avatars[posToInt(x, y)] = avatar;
        if (avatar != null) {
            avatar.notifyPlacement(x, y);
        }
    }

    public int getWidth() {
        return size.width;
    }

    public int getHeight() {
        return size.height;
    }

    @Override
    public Cell getCellAt(int row, int col) {
        return cells[posToInt(row, col)];
    }

    private int posToInt(int x, int y) {
        return y * size.width + x;
    }

    private Point intToPos(int id) {
        return new Point(id / size.width, id % size.width);
    }

    private boolean checkValues(int x, int y) {
        if (x < 0 || x >= size.width) return false;
        if (y < 0 || y >= size.height) return false;
        return true;
    }
}
