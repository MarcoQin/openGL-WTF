precision highp float;

uniform mat4 uMVPMatrix;
uniform float uTime;

uniform float uScaleZ;
uniform float uScaleX;
uniform float uScaleY;

uniform float uWidth;

attribute vec4 aPosition;
attribute vec2 aTextureCoord;
attribute vec4 aColor;

varying vec2 vTextureCoord;
varying vec4 vColor;
varying vec3 vTimeVec;
varying float vMax;

varying float vScaleZ;
varying float vScaleX;
varying float vScaleY;

varying float vWidth;

void main() {
    // -- normalized direction from the origin (0,0,0)

    vWidth = uWidth * uScaleX;

    vec3 directionVec = vec3(aPosition.x,aPosition.y,aPosition.z);

    vec4 timeVec = vec4(directionVec, 1.0);

    float time = uTime * 0.05;
    // -- multiply all the parameters to get the final

    timeVec.x = directionVec.x * uScaleX;
    timeVec.y = directionVec.y * uScaleY * 2.0;
    timeVec.z = directionVec.z * uScaleZ;

//    vColor = vec4(timeVec.x,timeVec.y,timeVec.z, 1.0);
//    if (timeVec.z < 0.0) {
//        timeVec.z = 0.0;
//    }
//
//    if (timeVec.x < 0.0) {
//        timeVec.x = 0.0;
//    }
//
    if (timeVec.y < 0.0) {
        timeVec.y = 0.0;
    }

    vec3 tmpVec = vec3(timeVec.x,timeVec.y,timeVec.z);

    vec4 newPosition = uMVPMatrix * timeVec;
    gl_Position = newPosition;

    vTextureCoord = aTextureCoord;
    vTimeVec = tmpVec;

    vScaleX = uScaleX;
    vScaleY = uScaleY;
    vScaleZ = uScaleZ;

//    vColor = newColor;
}