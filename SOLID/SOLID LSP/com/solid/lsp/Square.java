package com.solid.lsp;

public class Square implements figure {

    private int area;
    private int side;

    Square(int side) {
        this.setSide(side);
    }

    @Override
    public void setWidth(int width) {this.setSide(width);
    }

    public int getArea(){
        return side*side;
    }

    public int getSide() {
        return this.side;
    }
}
