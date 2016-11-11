package com.clintonmedbery.rajawalibasicproject;


import android.opengl.GLES20;

import org.rajawali3d.Object3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.util.RawShaderLoader;


class PlaneFragShader extends FragmentShader {
    private int muTextureInfluenceHandle;
    private int muColorHandle;
    private float[] mColor = new float[]{1.0f, 1.0f, 1.0f, 1.0f};


    public PlaneFragShader()
    {
        super();
        mNeedsBuild = false;

        initialize();
    }

    @Override
    public void initialize()
    {
        mShaderString = RawShaderLoader.fetch(R.raw.circle);
    }

    @Override
    public void setLocations(final int programHandle)
    {
        super.setLocations(programHandle);
        muTextureInfluenceHandle = getUniformLocation(programHandle, "uInfluencemyTex");
    }

    @Override
    public void applyParams()
    {
        super.applyParams();
        GLES20.glUniform1f(muTextureInfluenceHandle, .5f);
    }

    public void setColor(float r, float g, float b, float a){
        mColor[0] = r;
        mColor[1] = g;
        mColor[2] = b;
        mColor[3] = a;
    }

}
public class WTFLinePlane extends Object3D{
    Plane mPlane;
    PlaneFragShader fgShader;

    public WTFLinePlane(float size) {
        mPlane = new Plane(size, size, 1, 1);
        fgShader = new PlaneFragShader();
        Material mat = new Material(new VertexShader(), fgShader);
        mPlane.setMaterial(mat);
        addChild(mPlane);
        mPlane.rotate(Vector3.X, -90);
        mPlane.setY(-0.01);
    }

}
