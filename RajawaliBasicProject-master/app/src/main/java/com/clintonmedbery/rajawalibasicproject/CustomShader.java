package com.clintonmedbery.rajawalibasicproject;

/**
 * Created by sergiochan on 2016/11/4.
 */

import android.opengl.GLES20;
import com.clintonmedbery.rajawalibasicproject.R;
import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.util.RawShaderLoader;

public class CustomShader extends FragmentShader {
    private int muTextureInfluenceHandle;

    private int muScaleXHandle;
    private int muScaleYHandle;
    private int muScaleZHandle;


    public float ScaleZ;
    public float ScaleX;
    public float ScaleY;

    public CustomShader()
    {
        super();
        mNeedsBuild = false;
        ScaleX = 1.0f;
        ScaleY = 1.0f;
        ScaleZ = 1.0f;

        initialize();
    }

    @Override
    public void initialize()
    {
        mShaderString = RawShaderLoader.fetch(R.raw.custom_frag_shader);
    }

    @Override
    public void main() {

    }

    @Override
    public void setLocations(final int programHandle)
    {
        super.setLocations(programHandle);
        muTextureInfluenceHandle = getUniformLocation(programHandle, "uInfluencemyTex");
        muScaleXHandle = getUniformLocation(programHandle, "uScaleX");
        muScaleYHandle = getUniformLocation(programHandle, "uScaleY");
        muScaleZHandle = getUniformLocation(programHandle, "uScaleZ");
    }

    @Override
    public void applyParams()
    {
        super.applyParams();
        GLES20.glUniform1f(muTextureInfluenceHandle, .5f);
        GLES20.glUniform1f(muScaleXHandle, ScaleX);
        GLES20.glUniform1f(muScaleYHandle, ScaleY);
        GLES20.glUniform1f(muScaleZHandle, ScaleZ);
    }
}
