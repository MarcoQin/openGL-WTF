package com.clintonmedbery.rajawalibasicproject;

import org.rajawali3d.ATransformable3D;
import org.rajawali3d.Object3D;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.scene.RajawaliScene;


public class WTFLineToy extends Object3D{
    /*
        小人的 pivot 默认在两腿中心的脚底板处，目前还木有写setPivot方法，不过先设定两腿中心脚底板处为Vector3(0, 0, 0).
     */


    private WTFLineCube head;
    private WTFLineCube body;
    private WTFLineCube leftArm;
    private WTFLineCube rightArm;
    private WTFLineCube leftLeg;
    private WTFLineCube rightLeg;

    private boolean circleRotateStarted = false;
    private Vector3 position = new Vector3(0, 0, 0);

    private Object3D obj = new Object3D();

    public WTFLineToy() {
        head = new WTFLineCube(0.2f);
        body = new WTFLineCube(0.4f);
        leftArm = new WTFLineCube(0.4f);
        rightArm = new WTFLineCube(0.4f);
        leftLeg = new WTFLineCube(0.4f);
        rightLeg = new WTFLineCube(0.4f);
//        head.addAuxiliaryLine();
//        body.addAuxiliaryLine();
//        leftArm.addAuxiliaryLine();
//        rightArm.addAuxiliaryLine();
//        leftLeg.addAuxiliaryLine();
//        rightLeg.addAuxiliaryLine();
        addChild(head);
        addChild(body);
        addChild(leftArm);
        addChild(rightArm);
        addChild(leftLeg);
        addChild(rightLeg);
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
        float yFixed = 0.7f;
        head.setPosition(0, 0.91 + yFixed, 0);
        head.setPivot(new Vector3(0, -0.5, 0));
        body.setPosition(0, 0.5 + yFixed, 0);
        leftArm.setPosition(-0.31, 0.5 + yFixed, 0);
        rightArm.setPosition(0.31, 0.5 + yFixed, 0);
        leftLeg.setPosition(-0.11, -0.31 + yFixed, 0);
        rightLeg.setPosition(0.11, -0.31 + yFixed, 0);
    }

    private void setcolor() {
        head.setColor(new float[]{0.992f, 0.663f, 0.157f, 1.0f});
        body.setColor(new float[]{0.8f, 0.8f, 0.8f, 1.0f});
        leftArm.setColor(new float[]{0.0f, 0.612f, 1.0f, 1.0f});
        rightArm.setColor(new float[]{0.0f, 0.612f, 1.0f, 1.0f});
        leftLeg.setColor(new float[]{0.988f, 0.227f, 0.188f, 1.0f});
        rightLeg.setColor(new float[]{0.988f, 0.227f, 0.188f, 1.0f});
    }


    public void setHeadScale(double scale) {
        head.setScale(scale);
    }

    public void headRotate() {
        head.rotateAround(new Vector3(0, 1, 0), 10, true);
    }

//    public void setPosition(Vector3 pos) {
//        Vector3 new_pos = new Vector3(pos.x - position.x, pos.y - position.y, pos.z - position.z);
//        position = new_pos;
//        Vector3 old_pos = head.getPosition();
//        head.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//        old_pos = body.getPosition();
//        body.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//        old_pos = leftArm.getPosition();
//        leftArm.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//        old_pos = rightArm.getPosition();
//        rightArm.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//        old_pos = leftLeg.getPosition();
//        leftLeg.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//        old_pos = rightLeg.getPosition();
//        rightLeg.setPosition(new_pos.x + old_pos.x, new_pos.y + old_pos.y, new_pos.z + old_pos.z);
//    }

//    public void toyRotatCircle() {
//        obj.rotateAround(new Vector3(0, 1, 0), 1, true);
//    }

//    public void StartCircleRotate() {
//        if (!circleRotateStarted) {
//            circleRotateStarted = true;
//            setPosition(new Vector3(1.5, 0, 0));
//        }
//    }
//
//    public void StopCircleRotate() {
//        if (circleRotateStarted) {
//            circleRotateStarted = false;
//            setPosition(new Vector3(0, 0, 0));
//        }
//    }
}
