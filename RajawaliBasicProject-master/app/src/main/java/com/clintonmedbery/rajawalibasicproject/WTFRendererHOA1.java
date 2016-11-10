package com.clintonmedbery.rajawalibasicproject;

import android.content.Context;
import android.opengl.GLES20;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.OrthographicCamera;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.math.Matrix4;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.primitives.Line3D;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

import java.util.Stack;

public class WTFRendererHOA1 extends RajawaliRenderer {

    public Context context;

    private DirectionalLight directionalLight;
    private Sphere earthSphere;
    //    private Cube cube;
//    private WTFCube cube;
    private float scale = 1.0f;
    private boolean isDropping = false;

    private Cube[] cubeArray = new Cube[50];
    private Line3D line;

    private WTFFragmentShader fragShader;
    //    private CustomRawVertexShader vertShader;
    private WTFVertexShader vertShader;

    private Matrix4 mvpMatrix;

    private int mFrameCount = 0;
    //    private Material material;
    private WTFMaterial material;
    private float mTime = 0;

    private WTFToy toy;

    private Line3D l2;

    private Object3D cb = new Object3D();

    private WTFLineCube cube;

    private WTFLineCube[] cbs = new WTFLineCube[100 * 2];
    public WTFRendererHOA1(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
        scale = 1.0f;
    }



    public void initScene(){

        OrthographicCamera orthoCam = new OrthographicCamera();
        orthoCam.enableLookAt();
        orthoCam.setLookAt(-1.5, -0.5, -1.5);
//        orthoCam.setLookAt(0,0,0);
//        orthoCam.setLookAt(0,-0.5,0);
        orthoCam.setZoom(2);
        orthoCam.setPosition(2, 1.5, 2);

        getCurrentScene().switchCamera(orthoCam);

        directionalLight = new DirectionalLight(0.0f, 0.0f, 0.0f);
        directionalLight.setColor(1.0f, 1.0f, 1.0f);
        directionalLight.setPower(10);
        getCurrentScene().addLight(directionalLight);

//        cube = new WTFLineCube(0.5f);
//        cube.addAuxiliaryLine();
//        getCurrentScene().addChild(cube);
        int ii = 0;
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                WTFLineCube cb = new WTFLineCube(0.25f);
//                cb.addAuxiliaryLine();
                getCurrentScene().addChild(cb);
                cb.setPosition(i * 0.5 - 2.5, j * 0.5 - 1, 0);
                cbs[ii++] = cb;
            }
        }

    }


    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glDisable(GLES20.GL_POLYGON_OFFSET_FILL);
        super.onRender(elapsedTime, deltaTime);
        GLES20.glPolygonOffset(1.0f, 1.0f);

//        cube.rotateAround(new Vector3(0, 1, 0), 1, true);
        for(int i = 0; i < 200; i++) {
            cbs[i].rotateAround(new Vector3(0, 1, 0), 1, true);
//            cbs[i].setScale(scale);
        }
        mTime += 0.007f;
        float step = 0.01f;
        if (scale > 2.0f && isDropping == false) {
            scale -= step;
            isDropping = true;
        } else if (scale < 1.0f && isDropping == true) {
            isDropping = false;
            scale = 1.0f;
        } else {
            if (isDropping) {
                scale -= step;
            } else {
                scale += step;
            }
        }
    }


    public void onTouchEvent(MotionEvent event){


    }

    public void onOffsetsChanged(float x, float y, float z, float w, int i, int j){

    }
}

