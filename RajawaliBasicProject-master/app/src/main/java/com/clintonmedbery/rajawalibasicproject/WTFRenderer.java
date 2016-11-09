package com.clintonmedbery.rajawalibasicproject;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.view.MotionEvent;

import org.rajawali3d.OrthographicCamera;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.math.Matrix4;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.primitives.Line3D;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

import java.util.Stack;

public class WTFRenderer extends RajawaliRenderer {

    public Context context;

    private DirectionalLight directionalLight;
    private Sphere earthSphere;
    //    private Cube cube;
    private WTFCube cube;
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

    public WTFRenderer(Context context) {
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


        fragShader = new WTFFragmentShader();
        vertShader = new WTFVertexShader();

        mvpMatrix = new Matrix4 (new float[] {
                1.0f,0.0f,0.0f,0.0f,
                0.0f,1.0f,0.0f,0.0f,
                0.0f,0.0f,1.0f,0.0f,
                0.0f,0.0f,0.0f,1.0f
        });

        material = new WTFMaterial(vertShader,fragShader);
        material.enableLighting(true);
        material.enableTime(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColorInfluence(1.0f);

        float[] color = new float[4];
        color[0] = 1.0f;
        color[1] = 1.0f;
        color[2] = 1.0f;
        color[3] = 1.0f;

        material.setColor(Color.rgb(255,0,0));

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



        int[] color_t = new int[4];
        color_t[0] = 255;
        color_t[1] = 255;
        color_t[2] = 255;
        color_t[3] = 255;

        int color_tt = 0xffffffff;

        line = new Line3D(points, 3, color_tt);
        line.setMaterial(material);
//        line.setDrawingMode(GLES20.GL_LINE_LOOP);
        line.setScale(0.5);
//        getCurrentScene().addChild(line);

        cube = new WTFCube(0.5f);
        cube.setMaterial(material);
//        getCurrentScene().addChild(cube);

        cube.rotate(Vector3.Axis.Y, 45.0f);
        cube.rotate(Vector3.Axis.X, -45);

        toy = new WTFToy();
        toy.addToScene(getCurrentScene());
        toy.StartCircleRotate();


        WTFFragmentShaderwwwwww fg = new WTFFragmentShaderwwwwww();
        Material mtr = new Material(new VertexShader(), fg);
        Plane pl = new Plane(3, 3, 1, 1);
        pl.setDoubleSided(true);
//        pl.setMaterial(new Material());
        mtr.enableLighting(true);
        mtr.enableTime(true);
        mtr.setDiffuseMethod(new DiffuseMethod.Lambert());
        mtr.setColorInfluence(1.0f);
        pl.setMaterial(mtr);
        pl.setPosition(0, -0.3, 0);
        pl.rotate(Vector3.Axis.X, -90);
        getCurrentScene().addChild(pl);

        Stack st = new Stack();
        st.add(new Vector3(0, -0.5, 0));
        st.add(new Vector3(0, 1, 0));
        Line3D l1 = new Line3D(st, 3, color_tt);
        l1.setMaterial(new Material());
        getCurrentScene().addChild(l1);

        Stack lt = new Stack();
        lt.add(new Vector3(0, -0.28, 0));
        lt.add(new Vector3(1.5, -0.28, 0));
        l2 = new Line3D(lt, 3, color_tt);
        l2.setMaterial(new Material());
        getCurrentScene().addChild(l2);

    }


    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glDisable(GLES20.GL_POLYGON_OFFSET_FILL);
        super.onRender(elapsedTime, deltaTime);
//        line.rotate(Vector3.Axis.Y, 1.0);
//        line.rotate(Vector3.Axis.X, 1.0);
//        line.rotate(Vector3.Axis.Z, 1.0);
        GLES20.glPolygonOffset(1.0f, 1.0f);

//        material.setMVPMatrix(mvpMatrix);
//        material.setTime(mTime);
        mTime += 0.007f;
//        cube.rotateAround(new Vector3(0, 1, 0), 10, true);
        toy.toyRotatCircle();
        l2.rotateAround(new Vector3(0, 1, 0), 1, true);

//        cube.setScale(scale, scale, scale);
        toy.setHeadScale(scale);
//        toy.setScale(scale);
//        toy.headRotate();
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

