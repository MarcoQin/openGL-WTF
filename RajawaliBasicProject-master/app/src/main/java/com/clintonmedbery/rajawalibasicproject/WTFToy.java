package com.clintonmedbery.rajawalibasicproject;

import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.scene.RajawaliScene;


public class WTFToy {
    private WTFCube head;
    private WTFCube body;
    private WTFCube leftArm;
    private WTFCube rightArm;
    private WTFCube leftLeg;
    private WTFCube rightLeg;

    public WTFToy() {
        head = new WTFCube(0.2f, new WTFMaterial(false, false));
        body = new WTFCube(0.4f, new WTFMaterial(false, false));
        leftArm = new WTFCube(0.4f, new WTFMaterial(false, false));
        rightArm = new WTFCube(0.4f, new WTFMaterial(false, false));
        leftLeg = new WTFCube(0.4f, new WTFMaterial(false, false));
        rightLeg = new WTFCube(0.4f, new WTFMaterial(false, false));
        resize();
        reposition();
    }

    private void resize() {
        body.setScale(1, 2, 0.5);
        leftArm.setScale(0.5, 2, 0.5);
        rightArm.setScale(0.5, 2, 0.5);
        leftLeg.setScale(0.5, 2, 0.5);
        rightLeg.setScale(0.5, 2, 0.5);
    }

    private void reposition() {
        head.setPosition(0, 1, 0);
        body.setPosition(0, 0.5, 0);
        leftArm.setPosition(-0.3, 0.5, 0);
        rightArm.setPosition(0.3, 0.5, 0);
        leftLeg.setPosition(-0.1, -0.3, 0);
        rightLeg.setPosition(0.1, -0.3, 0);
    }

    public void addToScene(RajawaliScene scene) {
        scene.addChild(head);
        scene.addChild(body);
        scene.addChild(leftArm);
        scene.addChild(rightArm);
        scene.addChild(leftLeg);
        scene.addChild(rightLeg);
    }

    public void setHeadScale(double scale) {
        head.setScale(scale);
    }
}
