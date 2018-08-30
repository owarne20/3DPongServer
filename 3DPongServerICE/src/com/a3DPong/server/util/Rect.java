package com.a3DPong.server.util;

public class Rect {

    public float left, right, top, bottom;

    public Rect(float xCenter, float yCenter, float halfWidth, float halfHeight)
    {
        left = xCenter - halfWidth;
        right = xCenter + halfWidth;
        top = yCenter + halfHeight;
        bottom = yCenter -halfHeight;
    }

    public boolean intersects(Rect rect)
    {
        return this.left < rect.right && this.right > rect.left &&
                this.top > rect.bottom && this.bottom < rect.top;
    }

    public Lang.Side sideIntersected(Rect intersected, Rect previous)
    {
        Vector direction = new Vector(this.left - previous.left, this.top - previous.top);

        if(direction.x > 0)
        {
            //East direction
            if(direction.y > 0)
            {
                //North East
                //Get two lines represented by points and see if they intersect to find which side was intersected (to see if ball should bounce off the side of the paddle)
                if(Lang.doIntersect(new Point(previous.right, previous.top), new Point(this.right, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.right, intersected.bottom)))
                {
                    return Lang.Side.bottom;
                }
                if(Lang.doIntersect(new Point(previous.left, previous.top), new Point(this.left, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.right, intersected.bottom)))
                {
                    return Lang.Side.bottom;
                }

                if(Lang.doIntersect(new Point(previous.right, previous.top), new Point(this.right, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.left, intersected.top)))
                {
                    return Lang.Side.left;
                }
                if(Lang.doIntersect(new Point(previous.right, previous.bottom), new Point(this.right, this.bottom), new Point(intersected.left, intersected.bottom), new Point(intersected.left, intersected.top)))
                {
                    return Lang.Side.left;
                }

            }

            if(direction.y < 0)
            {
                //South East
                if(Lang.doIntersect(new Point(previous.right, previous.bottom), new Point(this.right, this.bottom), new Point(intersected.left, intersected.top), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.top;
                }
                if(Lang.doIntersect(new Point(previous.left, previous.bottom), new Point(this.left, this.bottom), new Point(intersected.left, intersected.top), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.top;
                }

                if(Lang.doIntersect(new Point(previous.right, previous.bottom), new Point(this.right, this.bottom), new Point(intersected.left, intersected.bottom), new Point(intersected.left, intersected.top)))
                {
                    return Lang.Side.left;
                }
                if(Lang.doIntersect(new Point(previous.right, previous.top), new Point(this.right, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.left, intersected.top)))
                {
                    return Lang.Side.left;
                }
            }
        }
        if(direction.x < 0)
        {
            //West direction
            if(direction.y > 0)
            {
                //North West
                if(Lang.doIntersect(new Point(previous.left, previous.top), new Point(this.left, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.right, intersected.bottom)))
                {
                    return Lang.Side.bottom;
                }
                if(Lang.doIntersect(new Point(previous.right, previous.top), new Point(this.right, this.top), new Point(intersected.left, intersected.bottom), new Point(intersected.right, intersected.bottom)))
                {
                    return Lang.Side.bottom;
                }

                if(Lang.doIntersect(new Point(previous.left, previous.top), new Point(this.left, this.top), new Point(intersected.right, intersected.bottom), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.right;
                }
                if(Lang.doIntersect(new Point(previous.left, previous.bottom), new Point(this.left, this.bottom), new Point(intersected.right, intersected.bottom), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.right;
                }
            }

            if(direction.y < 0)
            {
                //South West
                if(Lang.doIntersect(new Point(previous.left, previous.bottom), new Point(this.left, this.bottom), new Point(intersected.left, intersected.top), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.top;
                }
                if(Lang.doIntersect(new Point(previous.right, previous.bottom), new Point(this.right, this.bottom), new Point(intersected.left, intersected.top), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.top;
                }

                if(Lang.doIntersect(new Point(previous.left, previous.bottom), new Point(this.left, this.bottom), new Point(intersected.right, intersected.bottom), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.right;
                }
                if(Lang.doIntersect(new Point(previous.left, previous.top), new Point(this.left, this.top), new Point(intersected.right, intersected.bottom), new Point(intersected.right, intersected.top)))
                {
                    return Lang.Side.right;
                }
            }
        }
        return Lang.Side.none;
    }
}
