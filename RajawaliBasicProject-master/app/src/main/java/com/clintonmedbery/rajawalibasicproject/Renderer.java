package com.clintonmedbery.rajawalibasicproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Debug;
import android.util.Log;
import android.view.MotionEvent;

import org.rajawali3d.OrthographicCamera;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.materials.shaders.VertexShader;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.primitives.Line3D;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

import org.rajawali3d.Geometry3D;
import org.rajawali3d.Object3D;
import org.rajawali3d.math.vector.Vector3;
import java.util.Stack;

/**
 * Created by clintonmedbery on 4/6/15.
 */
public class Renderer extends RajawaliRenderer {

    public Context context;

    private DirectionalLight directionalLight;
    private Sphere earthSphere;
    private Cube cube;
    private double scale = 1.0f;
    private boolean isDropping = false;

    private Cube[] cubeArray = new Cube[50];

    public Renderer(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
        scale = 1.0f;
    }

    public void initScene(){

        OrthographicCamera orthoCam = new OrthographicCamera();
        orthoCam.setLookAt(0, 0, 0);
        orthoCam.enableLookAt();
        orthoCam.setZoom(2);

        getCurrentScene().switchCamera(orthoCam);

        directionalLight = new DirectionalLight(0.0f, 0.0f, 0.0f);
        directionalLight.setColor(1.0f, 1.0f, 1.0f);
        directionalLight.setPower(10);
        getCurrentScene().addLight(directionalLight);

        Material material = new Material(new VertexShader(),new CustomShader());
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
//        Texture earthTexture = new Texture("Earth", R.drawable.earthtruecolor_nasa_big);
//        try{
//            material.addTexture(earthTexture);
//
//        } catch (ATexture.TextureException error){
//            Log.d("DEBUG", "TEXTURE ERROR");
//        }

//        earthSphere = new Sphere(1, 24, 24);
//        earthSphere.setMaterial(material);
//        getCurrentScene().addChild(earthSphere);
//        getCurrentCamera().setZ(4.2f);

        Stack points = new Stack();
        points.add(new Vector3(0, 0, 0));
        points.add(new Vector3(1, 0, 0));
        points.add(new Vector3(0, 1, 0));
        points.add(new Vector3(-1, 1, 0));
        points.add(new Vector3(0, 0, 0));

        int[] color_t = new int[4];
        color_t[0] = 255;
        color_t[1] = 255;
        color_t[2] = 255;
        color_t[3] = 255;

        int color_tt = 0xffffffff;

        Line3D line = new Line3D(points, 1, color_tt);
        line.setMaterial(material);
        getCurrentScene().addChild(line);

        float t_x = -2.5f;
        float t_y = -1.0f;

        for (int i = 0; i< 50;i++) {
            Cube t_cube = new Cube(0.3f);
            t_cube.setX(t_x);
            t_cube.setY(t_y);

            if (t_x > 2.5f) {
                t_x = - 2.5f;
                t_y += 0.6f;
            } else {
                t_x += 0.6f;
            }

            t_cube.setMaterial(material);
//        cube.setColor(Color.rgb(255, 255, 255));
            getCurrentScene().addChild(t_cube);

            t_cube.rotate(Vector3.Axis.Y, 45.0);
            t_cube.rotate(Vector3.Axis.X, -45);

            cubeArray[i] = t_cube;
        }
//        cube = new Cube(0.5f);
//        cube.setMaterial(material);
////        cube.setColor(Color.rgb(255, 255, 255));
//        getCurrentScene().addChild(cube);
//
//        cube.rotate(Vector3.Axis.Y, 45.0);
//        cube.rotate(Vector3.Axis.X, -22.5);
    }


    @Override
     public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);

        for ( Cube t : cubeArray) {
//            t.rotate(Vector3.Axis.Y, 1.0);
//            t.rotate(Vector3.Axis.X, 1.0);
//            t.rotate(Vector3.Axis.Z, 1.0);
        }
//        earthSphere.rotate(Vector3.Axis.Y, 1.0);
//        cube.rotate(Vector3.Axis.Y, 1.0);
//        cube.rotate(Vector3.Axis.X, 1.0);
//        cube.rotate(Vector3.Axis.Z, 1.0);
//        cube.setScale(scale);
//        if (scale > 2.0f && isDropping == false) {
//            scale -= 0.005f;
//            isDropping = true;
//        } else if (scale < 1.0f && isDropping == true) {
//            isDropping = false;
//            scale = 1.0f;
//        } else {
//            if (isDropping) {
//                scale -= 0.005f;
//            } else {
//                scale += 0.005f;
//            }
//        }
    }


    public void onTouchEvent(MotionEvent event){


    }

    public void onOffsetsChanged(float x, float y, float z, float w, int i, int j){

    }
}
