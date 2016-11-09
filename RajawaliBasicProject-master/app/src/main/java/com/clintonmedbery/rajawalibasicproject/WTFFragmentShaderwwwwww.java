package com.clintonmedbery.rajawalibasicproject;

import android.opengl.GLES20;

import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.util.RawShaderLoader;


public class WTFFragmentShaderwwwwww extends FragmentShader {
    private int muTextureInfluenceHandle;
    private int muColorHandle;
    private float[] mColor = new float[]{1.0f, 1.0f, 1.0f, 1.0f};


    public WTFFragmentShaderwwwwww()
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
    public void main() {

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