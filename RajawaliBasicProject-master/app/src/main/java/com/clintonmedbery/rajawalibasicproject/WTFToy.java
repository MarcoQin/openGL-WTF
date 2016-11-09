package com.clintonmedbery.rajawalibasicproject;

import org.rajawali3d.Object3D;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.scene.RajawaliScene;


public class WTFToy {
    private WTFCube head;
    private WTFCube body;
    private WTFCube leftArm;
    private WTFCube rightArm;
    private WTFCube leftLeg;
    private WTFCube rightLeg;

    private boolean circleRotateStarted = false;
    private Vector3 position = new Vector3(0, 0, 0);

    private Object3D obj = new Object3D();

    public WTFToy() {
        head = new WTFCube(0.2f, new WTFMaterial(false, false));
        body = new WTFCube(0.4f, new WTFMaterial(false, false));
        leftArm = new WTFCube(0.4f, new WTFMaterial(false, false));
        rightArm = new WTFCube(0.4f, new WTFMaterial(false, false));
        leftLeg = new WTFCube(0.4f, new WTFMaterial(false, false));
        rightLeg = new WTFCube(0.4f, new WTFMaterial(false, false));
        obj.addChild(head);
        obj.addChild(body);
        obj.addChild(leftArm);
        obj.addChild(rightArm);
        obj.addChild(leftLeg);
        obj.addChild(rightLeg);
        resize();
        reposition();
        setcolor();
    }

    private void resize() {
        body.setScale(1, 2, 0.5);
        leftArm.setScale(0.5, 2, 0.5);
        rightArm.setScale(0.5, 2, 0.5);
        leftLeg.setScale(0.5, 2, 0.5);
        rightLeg.setScale(0.5, 2, 0.5);
    }

    private void reposition() {
        head.setPosition(0, 1.3, 0);
        body.setPosition(0, 0.5, 0);
        leftArm.setPosition(-0.3, 0.5, 0);
        rightArm.setPosition(0.3, 0.5, 0);
        leftLeg.setPosition(-0.1, -0.3, 0);
        rightLeg.setPosition(0.1, -0.3, 0);
    }

    private void setcolor() {
        head.setColor(new float[]{0.992f, 0.663f, 0.157f, 1.0f});
        body.setColor(new float[]{0.8f, 0.8f, 0.8f, 1.0f});
        leftArm.setColor(new float[]{0.0f, 0.612f, 1.0f, 1.0f});
        rightArm.setColor(new float[]{0.0f, 0.612f, 1.0f, 1.0f});
        leftLeg.setColor(new float[]{0.988f, 0.227f, 0.188f, 1.0f});
        rightLeg.setColor(new float[]{0.988f, 0.227f, 0.188f, 1.0f});
    }

    public void addToScene(RajawaliScene scene) {
//        scene.addChild(head);
//        scene.addChild(body);
//        scene.addChild(leftArm);
//        scene.addChild(rightArm);
//        scene.addChild(leftLeg);
//        scene.addChild(rightLeg);
        scene.addChild(obj);
    }

    public void setHeadScale(double scale) {
        head.setScale(scale);
    }

    public void setScale(double scale) {
        obj.setScale(scale);
    }

    public void headRotate() {
        head.rotateAround(new Vector3(0, 1, 0), 10, true);
    }

    public void setPosition(Vector3 pos) {
        Vector3 new_pos = new Vector3(pos.x - position.x, pos.y - position.y, pos.z - position.z);
        position = new_pos;
        Vector3 old_pos = head.getPosition();
        head.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
        old_pos = body.getPosition();
        body.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
        old_pos = leftArm.getPosition();
        leftArm.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
        old_pos = rightArm.getPosition();
        rightArm.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
        old_pos = leftLeg.getPosition();
        leftLeg.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
        old_pos = rightLeg.getPosition();
        rightLeg.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
    }

    public void toyRotatCircle() {
        Vector3 axis = new Vector3(-1, 1, 0);
//        head.rotateAround(axis, 10, true);
//        body.rotateAround(axis, 10, true);
//        leftArm.rotateAround(axis, 10, true);
//        rightArm.rotateAround(axis, 10, true);
//        leftLeg.rotateAround(axis, 10, true);
//        rightLeg.rotateAround(axis, 10, true);
        obj.rotateAround(new Vector3(0, 1, 0), 1, true);
    }

    public void StartCircleRotate() {
        if (!circleRotateStarted) {
            circleRotateStarted = true;
            setPosition(new Vector3(1.5, 0, 0));
        }
    }

    public void StopCircleRotate() {
        if (circleRotateStarted) {
            circleRotateStarted = false;
            setPosition(new Vector3(0, 0, 0));
        }
    }
}
