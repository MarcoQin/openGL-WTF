package com.clintonmedbery.rajawalibasicproject;

import android.opengl.GLES20;
import android.os.Debug;
import android.util.Log;

import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.util.RawShaderLoader;

public class CustomRawVertexShader extends VertexShader {
	private int muScaleXHandle;
	private int muScaleYHandle;
	private int muScaleZHandle;
	private int muWidthHandle;
	private int muScaleModeHandle;

	public float ScaleZ;
	public float ScaleX;
	public float ScaleY;
	public float Width;
	public int ScaleMode;

	public CustomRawVertexShader()
	{
		super();
		mNeedsBuild = false;
		enableTime(true);

		ScaleX = 1.0f;
		ScaleY = 1.0f;
		ScaleZ = 1.0f;

		ScaleMode = 1;

		initialize();
	}

	@Override
	public void initialize()
	{
		mShaderString = RawShaderLoader.fetch(R.raw.littleman_vertex_shader);
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
		muWidthHandle = getUniformLocation(programHandle, "uWidth");
		muScaleModeHandle = getUniformLocation(programHandle, "uScaleMode");
	}

	@Override
	public void applyParams() {
//		Log.d("Fuck","fuck");
		super.applyParams();
		GLES20.glUniform1f(muScaleXHandle, ScaleX);
		GLES20.glUniform1f(muScaleYHandle, ScaleY);
		GLES20.glUniform1f(muScaleZHandle, ScaleZ);
		GLES20.glUniform1f(muWidthHandle, Width);
		GLES20.glUniform1i(muScaleModeHandle, ScaleMode);
	}
}
