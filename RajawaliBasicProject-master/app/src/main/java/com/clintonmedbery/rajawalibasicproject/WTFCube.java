package com.clintonmedbery.rajawalibasicproject;

import org.rajawali3d.ATransformable3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;


public class WTFCube extends Cube{
    private Cube _cube;
    private WTFMaterial _mat;
    private float _size;
    private Vector3 _pivot;
    private int _scaleMode;

    public WTFCube(float size) {
        this(size, null);
    }

    public WTFCube(float size, int scaleMode) {
        this(size, null, null, scaleMode);
    }

    public WTFCube(float size, WTFMaterial mat) {
        this(size, mat, null, 1);
    }

    public WTFCube(float size, WTFMaterial mat, Vector3 pivot, int scaleMode) {
        super(size);
        _size = size;
        _pivot = pivot;
        _scaleMode = scaleMode;
        this.setMaterial(mat);

    }

    public void setMaterial(WTFMaterial mat) {
        _mat = mat;
        if (_mat != null) {
            super.setMaterial(_mat);
            _mat.getVetexShader().ScaleMode = _scaleMode;
            _mat.getVetexShader().Width = _size;
        }
    }

    public ATransformable3D setScale(double scale) {
        return this.setScale(scale, scale, scale);
    }

    public ATransformable3D setScale(Vector3 scale) {
        return this.setScale(scale.x, scale.y, scale.z);
    }

    public ATransformable3D setScale(double scaleX, double scaleY, double scaleZ) {
        _mat.getVetexShader().ScaleX = (float)scaleX;
        _mat.getVetexShader().ScaleY = (float)scaleY;
        _mat.getVetexShader().ScaleZ = (float)scaleZ;
        return null;
    }

    public void setColor(float[] color) {
        this.setColor(color[0],color[1],color[2],color[3]);
    }

    public void setColor(float r, float g, float b, float a){
        _mat.getFragmentShader().setColor(r, g, b, a);
    }

}
