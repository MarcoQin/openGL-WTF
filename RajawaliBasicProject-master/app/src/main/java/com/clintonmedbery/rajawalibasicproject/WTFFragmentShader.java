package com.clintonmedbery.rajawalibasicproject;

import android.opengl.GLES20;

import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.util.RawShaderLoader;


public class WTFFragmentShader extends FragmentShader {
    private int muTextureInfluenceHandle;

    private int muscalexHandle;
    private int muscaleyHandle;
    private int muscalezHandle;


    public float scalez;
    public float scalex;
    public float scaley;

    public WTFFragmentShader()
    {
        super();
        mNeedsBuild = false;
        scalex = 1.0f;
        scaley = 1.0f;
        scalez = 1.0f;

        initialize();
    }

    @Override
    public void initialize()
    {
        mShaderString = RawShaderLoader.fetch(R.raw.wtf_frag_shader);
    }

    @Override
    public void main() {

    }

    @Override
    public void setLocations(final int programHandle)
    {
        super.setLocations(programHandle);
        muTextureInfluenceHandle = getUniformLocation(programHandle, "uInfluencemyTex");
        muscalexHandle = getUniformLocation(programHandle, "uscalex");
        muscaleyHandle = getUniformLocation(programHandle, "uscaley");
        muscalezHandle = getUniformLocation(programHandle, "uscalez");
    }

    @Override
    public void applyParams()
    {
        super.applyParams();
        GLES20.glUniform1f(muTextureInfluenceHandle, .5f);
        GLES20.glUniform1f(muscalexHandle, scalex);
        GLES20.glUniform1f(muscaleyHandle, scaley);
        GLES20.glUniform1f(muscalezHandle, scalez);
    }
}