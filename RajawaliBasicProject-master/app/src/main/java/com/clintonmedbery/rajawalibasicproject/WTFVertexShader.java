package com.clintonmedbery.rajawalibasicproject;

import android.opengl.GLES20;

import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.util.RawShaderLoader;



public class WTFVertexShader extends VertexShader {
    private int muScaleXHandle;
    private int muScaleYHandle;
    private int muScaleZHandle;


    public float ScaleZ;
    public float ScaleX;
    public float ScaleY;

    public WTFVertexShader()
    {
        super();
        mNeedsBuild = false;
        enableTime(true);

        ScaleX = 1.0f;
        ScaleY = 1.0f;
        ScaleZ = 1.0f;

        initialize();
    }

    @Override
    public void initialize()
    {
        mShaderString = RawShaderLoader.fetch(R.raw.wtf_vertex_shader);
    }

    @Override
    public void main() {

    }

    @Override
    public void setLocations(final int programHandle)
    {
        super.setLocations(programHandle);
        muScaleXHandle = getUniformLocation(programHandle, "uScaleX");
        muScaleYHandle = getUniformLocation(programHandle, "uScaleY");
        muScaleZHandle = getUniformLocation(programHandle, "uScaleZ");
    }

    @Override
    public void applyParams() {
//		Log.d("Fuck","fuck");
        super.applyParams();
        GLES20.glUniform1f(muScaleXHandle, ScaleX);
        GLES20.glUniform1f(muScaleYHandle, ScaleY);
        GLES20.glUniform1f(muScaleZHandle, ScaleZ);
    }
}
