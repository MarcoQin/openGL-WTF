package com.clintonmedbery.rajawalibasicproject;


import org.rajawali3d.Object3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.primitives.Line3D;
import org.rajawali3d.scene.RajawaliScene;

import java.util.Stack;

public class WTFLineCube extends Object3D{

    private Vector3 mPivot = new Vector3(0, 0, 0);
//    Object3D mCube = new Object3D();
    private Line3D _outLine;
    private Cube _innerCube;

    public WTFLineCube(float size) {
        this(size, new Material());
    }

    public WTFLineCube(float size, Material mat) {
        this(size, mat, new Vector3(0, 0, 0));
    }

    public WTFLineCube(float size, Material mat, Vector3 pivot) {
        super();
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

        _outLine = new Line3D(points, 3, 0xffffff);
        _outLine.setMaterial(mat);
        _innerCube = new Cube(0.97f);
        WTFFragmentShaderwwwwww fg = new WTFFragmentShaderwwwwww();
        Material mtr = new Material(new VertexShader(), fg);
        _innerCube.setMaterial(mtr);
        _innerCube.setPosition(new Vector3(-0.5, 0.5, -0.5));

        addChild(_outLine);
        addChild(_innerCube);
        setScale(size);
        resetPivot();
    }

    private void resetPivot() {
        Vector3 l_old_pos = _outLine.getPosition();
        Vector3 c_old_pos = _innerCube.getPosition();
//        Vector3 new_pos = new Vector3(0.5, 0, 0.5);
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
        Material mat = new Material();
        Stack ds = new Stack();
        ds.add(new Vector3(0, 0, 0));
        ds.add(new Vector3(0, 4, 0));
        Line3D ld = new Line3D(ds, 3);
        ld.setMaterial(mat);

        Stack ds1 = new Stack();
        ds1.add(new Vector3(0, 0, 0));
        ds1.add(new Vector3(4, 0, 0));
        Line3D ld1 = new Line3D(ds1, 3);
        ld1.setMaterial(mat);

        Stack ds2 = new Stack();
        ds2.add(new Vector3(0, 0, 0));
        ds2.add(new Vector3(0, 0, 4));
        Line3D ld2 = new Line3D(ds2, 3);
        ld2.setMaterial(mat);

        addChild(ld);
        addChild(ld1);
        addChild(ld2);
    }
}
