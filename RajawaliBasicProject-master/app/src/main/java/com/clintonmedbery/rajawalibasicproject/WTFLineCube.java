package com.clintonmedbery.rajawalibasicproject;


import org.rajawali3d.ATransformable3D;
import org.rajawali3d.Object3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.primitives.Line3D;
import org.rajawali3d.scene.RajawaliScene;

import java.util.Stack;

public class WTFLineCube extends Object3D{
    /*
        Cube的pivot默认为正方体的中心点 Vector3(0, 0, 0).所以，Cube正下方中心点为Vector3(0, -0.5, 0);
     */

    private Vector3 mPivot = new Vector3(0, 0, 0);
    private Line3D _outLine;
    private Cube _innerCube;
    private Vector3 mSize;

    public WTFLineCube(float size) {
        this(size, new Material());
    }

    public WTFLineCube(float size, Material mat) {
        this(size, mat, new Vector3(0, 0, 0));
    }

    public WTFLineCube(float size, Material mat, Vector3 pivot) {
        super();
        mSize = new Vector3(size, size, size);
        mPivot = pivot;
        Stack points = new Stack();
        points.add(new Vector3(-1, 1, 0));
        points.add(new Vector3(-1, 1, -1));
        points.add(new Vector3(0, 1, -1));
        points.add(new Vector3(0, 1, 0));
        points.add(new Vector3(-1, 1, 0));
        points.add(new Vector3(-1, 0, 0));
        points.add(new Vector3(0, 0, 0));
        points.add(new Vector3(0, 1, 0));
        points.add(new Vector3(0, 1, -1));
        points.add(new Vector3(0, 0, -1));
        points.add(new Vector3(0, 0, 0));
        points.add(new Vector3(-1, 0, 0));
        points.add(new Vector3(-1, 0, -1));
        points.add(new Vector3(0, 0, -1));
        points.add(new Vector3(-1, 0, -1));
        points.add(new Vector3(-1, 1, -1));

        _outLine = new Line3D(points, 3);
        _outLine.setMaterial(mat);
        _innerCube = new Cube(0.99f);
        Material m = new Material();
        m.setColor(new float[]{0, 0, 0, 255});
//        m.setColor(new float[]{10, 10, 10, 255});
        _innerCube.setMaterial(m);
        _innerCube.setPosition(new Vector3(-0.5, 0.5, -0.5));

        addChild(_outLine);
        addChild(_innerCube);
        super.setScale(size);
        resetPivot();
    }

    public ATransformable3D setScale(Vector3 scale) {
        return super.setScale(scale.x * mSize.x, scale.y * mSize.y, scale.z * mSize.z);
    }

    public ATransformable3D setScale(double scale) {
        return super.setScale(mSize.x * scale, mSize.y * scale, mSize.z * scale);
    }

    public ATransformable3D setScale(double scaleX, double scaleY, double scaleZ) {
        return super.setScale(scaleX * mSize.x, scaleY * mSize.y, scaleZ * mSize.z);
    }

    // range: 0-1
    public void setColor(Vector3 color) {
        _outLine.setColor(color);
    }

    // range: 0-255
    public void setColor(int R, int G, int B) {
        _outLine.setColor(new Vector3(R/255f, G/255f, B/255f));
    }

    // range: 0-1
    public void setColor(float r, float g, float b) {
        _outLine.setColor(new Vector3(r, g, b));
    }

    // range: 0-1
    public void setColor(float[] color) {
        _outLine.setColor(new Vector3(color[0], color[1], color[2]));
    }

    private void resetPivot() {
        Vector3 l_old_pos = _outLine.getPosition();
        Vector3 c_old_pos = _innerCube.getPosition();
        Vector3 new_pos = new Vector3(0.5, -0.5, 0.5);

        _outLine.setPosition(l_old_pos.x + new_pos.x, l_old_pos.y + new_pos.y, l_old_pos.z + new_pos.z);
        _innerCube.setPosition(c_old_pos.x + new_pos.x, c_old_pos.y + new_pos.y, c_old_pos.z + new_pos.z);
    }

    // Cube's center point is Vect3(0, 0, 0)
    public void setPivot(Vector3 pivot) {
        Vector3 new_pos = new Vector3(mPivot.x-pivot.x, mPivot.y-pivot.y, mPivot.z-pivot.z);
        mPivot = pivot;
        Vector3 l_old_pos = _outLine.getPosition();
        Vector3 c_old_pos = _innerCube.getPosition();

        _outLine.setPosition(l_old_pos.x + new_pos.x, l_old_pos.y + new_pos.y, l_old_pos.z + new_pos.z);
        _innerCube.setPosition(c_old_pos.x + new_pos.x, c_old_pos.y + new_pos.y, c_old_pos.z + new_pos.z);
    }

    public void addAuxiliaryLine() {
        Material matY = new Material();
        matY.setColor(new float[]{0, 1, 0, 1});
        Stack ds = new Stack();
        ds.add(new Vector3(0, 0, 0));
        ds.add(new Vector3(0, 4, 0));
        Line3D ld = new Line3D(ds, 3);
        ld.setMaterial(matY);

        Material matX = new Material();
        matX.setColor(new float[]{1, 0, 0, 1});
        Stack ds1 = new Stack();
        ds1.add(new Vector3(0, 0, 0));
        ds1.add(new Vector3(4, 0, 0));
        Line3D ld1 = new Line3D(ds1, 3);
        ld1.setMaterial(matX);

        Material matZ = new Material();
        matZ.setColor(new float[]{0, 0, 1, 1});
        Stack ds2 = new Stack();
        ds2.add(new Vector3(0, 0, 0));
        ds2.add(new Vector3(0, 0, 4));
        Line3D ld2 = new Line3D(ds2, 3);
        ld2.setMaterial(matZ);

        addChild(ld);
        addChild(ld1);
        addChild(ld2);
    }


    public void addGlobalAuxiliaryLine(RajawaliScene scene) {
        Material matY = new Material();
        matY.setColor(new float[]{0, 1, 0, 1});
        Stack ds = new Stack();
        ds.add(new Vector3(0, 0, 0));
        ds.add(new Vector3(0, 4, 0));
        Line3D ld = new Line3D(ds, 3);
        ld.setMaterial(matY);

        Material matX = new Material();
        matX.setColor(new float[]{1, 0, 0, 1});
        Stack ds1 = new Stack();
        ds1.add(new Vector3(0, 0, 0));
        ds1.add(new Vector3(4, 0, 0));
        Line3D ld1 = new Line3D(ds1, 3);
        ld1.setMaterial(matX);

        Material matZ = new Material();
        matZ.setColor(new float[]{0, 0, 1, 1});
        Stack ds2 = new Stack();
        ds2.add(new Vector3(0, 0, 0));
        ds2.add(new Vector3(0, 0, 4));
        Line3D ld2 = new Line3D(ds2, 3);
        ld2.setMaterial(matZ);

        scene.addChild(ld);
        scene.addChild(ld1);
        scene.addChild(ld2);
    }
}
