package com.a3DPong.server.util;

import java.util.Random;

public class Vector {

    public float x, y;

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector scale(float scale){
        return new Vector(x * scale, y * scale);
    }
    public float length(){
        return (float) Math.sqrt((x*x)+(y*y));
    }

    public Vector translate(Vector other){
        return new Vector(
                this.x + other.x,
                this.y + other.y);
    }

    public static Vector random2DNormalisedVector(float speed){
        Random r = new Random();
        final boolean b = r.nextBoolean();
        int directionInDegrees = b ? 60 + r.nextInt(50) : 240 + r.nextInt(50);
        if(Math.abs(directionInDegrees)  == 0 || Math.abs(directionInDegrees)  == 90 || Math.abs(directionInDegrees)  == 180 || Math.abs(directionInDegrees) == 270 || Math.abs(directionInDegrees) == 360){
        	directionInDegrees = b ? 60 + r.nextInt(50) : 240 + r.nextInt(50);
        }
        final float x = (float) Math.cos(Math.toRadians(directionInDegrees)) * speed;
        final float y = (float) Math.sin(Math.toRadians(directionInDegrees)) * speed;
        return new Vector(x, y);
    }
}
