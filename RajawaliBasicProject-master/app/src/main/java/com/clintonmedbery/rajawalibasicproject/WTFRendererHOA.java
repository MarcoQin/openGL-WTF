package com.clintonmedbery.rajawalibasicproject;

import android.content.Context;
import android.graphics.Color;
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
import org.rajawali3d.util.exporter.ObjExporter;

import java.util.Stack;

public class WTFRendererHOA extends RajawaliRenderer {

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

    private Object3D cb = new Object3D();

    public WTFRendererHOA(Context context) {
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



        float[] color_t = new float[4];
        color_t[0] = 50f;
        color_t[1] = 50f;
        color_t[2] = 50f;
        color_t[3] = 255f;

//        int color_tt = 0xffffffff;
        int[] color_ct = new int[4];
        color_ct[0] = 253;
        color_ct[1] = 169;
        color_ct[2] = 40;
        color_ct[3] = 255;

        line = new Line3D(points, 3);
        line.setColor(new Vector3(253, 169, 40));
        line.setMaterial(new Material());
//        line.setDrawingMode(GLES20.GL_LINE_LOOP);
//        line.setScale(0.5);
//        getCurrentScene().addChild(line);

        Material pm = new Material();
        pm.setColor(color_t);
        WTFFragmentShaderwwwwww fg = new WTFFragmentShaderwwwwww();
        Material mtr = new Material(new VertexShader(), fg);

        Cube c1 = new Cube(0.97f);
        c1.setMaterial(mtr);
        c1.setPosition(new Vector3(-0.5, 0.5, -0.5));


        Plane p1 = new Plane(1, 1, 1, 1);
        p1.setMaterial(mtr);
        p1.setDoubleSided(true);
//        p1.setPosition(-0.5, 0.5, -1);
        p1.setPosition(-0.5, 0, -1);
//        getCurrentScene().addChild(p1);

        Plane p2 = new Plane(1, 1, 1, 1);
        p2.setMaterial(mtr);
        p2.setDoubleSided(true);
        p2.setPosition(-0.5, 0.5, 0);
//        getCurrentScene().addChild(p2);

        Plane p3 = new Plane(1, 1, 1, 1);
        p3.setMaterial(mtr);
        p3.setDoubleSided(true);
        p3.setPosition(-0.5, 0, -0.5);
        p3.rotate(Vector3.Axis.X, 90);

        Plane p4 = new Plane(1, 1, 1, 1);
        p4.setMaterial(mtr);
        p4.setDoubleSided(true);
        p4.setPosition(-0.5, 1, -0.5);
        p4.rotate(Vector3.Axis.X, 90);

        Plane p5 = new Plane(1, 1, 1, 1);
        p5.setMaterial(mtr);
        p5.setDoubleSided(true);
        p5.setPosition(-1, 0.5, -0.5);
        p5.rotate(Vector3.Axis.Y, 90);

        Plane p6 = new Plane(1, 1, 1, 1);
        p6.setMaterial(mtr);
        p6.setDoubleSided(true);
        p6.setPosition(0, 0.5, -0.5);
        p6.rotate(Vector3.Axis.Y, 90);


        Stack ds = new Stack();
        ds.add(new Vector3(0, 0, 0));
        ds.add(new Vector3(0, 4, 0));
        Line3D ld = new Line3D(ds, 3);
        ld.setMaterial(new Material());

        Stack ds1 = new Stack();
        ds1.add(new Vector3(0, 0, 0));
        ds1.add(new Vector3(4, 0, 0));
        Line3D ld1 = new Line3D(ds1, 3);
        ld1.setMaterial(new Material());

        Stack ds2 = new Stack();
        ds2.add(new Vector3(0, 0, 0));
        ds2.add(new Vector3(0, 0, 4));
        Line3D ld2 = new Line3D(ds2, 3);
        ld2.setMaterial(new Material());

        Vector3 l_old_pos = line.getPosition();
        Vector3 c_old_pos = c1.getPosition();
//        Vector3 new_pos = new Vector3(0.5, 0, 0.5);
        Vector3 new_pos = new Vector3(0.5, -0.5, 0.5);

        line.setPosition(l_old_pos.x + new_pos.x, l_old_pos.y + new_pos.y, l_old_pos.z + new_pos.z);
        c1.setPosition(c_old_pos.x + new_pos.x, c_old_pos.y + new_pos.y, c_old_pos.z + new_pos.z);


        cb.addChild(line);
//        cb.addChild(p1);
//        cb.addChild(p2);
//        cb.addChild(p3);
//        cb.addChild(p4);
//        cb.addChild(p5);
//        cb.addChild(p6);
        cb.addChild(c1);
        cb.addChild(ld);
        cb.addChild(ld1);
        cb.addChild(ld2);
//        cb.setScale(0.5);
        getCurrentScene().addChild(cb);

//        for (int i = 0; i < 50; i ++) {
//            Object3D st = cb.clone();
//            st.setPosition(1, 0, 0);
//            getCurrentScene().addChild(st);
//        }

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
//        getCurrentScene().addChild(pl);



    }


    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glDisable(GLES20.GL_POLYGON_OFFSET_FILL);
        super.onRender(elapsedTime, deltaTime);
//        cb.rotate(Vector3.Axis.Y, 1.0);
//        cb.rotate(Vector3.Axis.X, 1.0);
//        cb.rotate(Vector3.Axis.Z, 1.0);
        GLES20.glPolygonOffset(1.0f, 1.0f);

        cb.rotateAround(new Vector3(0, 1, 0), 1, true);
//        cb.setScale(1, 1, 1);
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

