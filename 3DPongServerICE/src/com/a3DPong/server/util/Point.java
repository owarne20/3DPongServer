package com.a3DPong.server.util;

/**
 * Created by Oscar Warne on 28/06/2018 for 3DPong.
 */
public class Point {

    public float x, y;
    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Point translateY(float distance){
        return new Point(x, y + distance);
    }
    public Point translate(Vector vector)
    {
        return new Point(
                x + vector.x,
                y + vector.y
        );
    }

}
