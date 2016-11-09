precision mediump float;

const float GT = 1.0;
const float LT = 0.0;


uniform float uColorInfluence;
uniform float uTime;
uniform float uInfluencemyTex;
uniform float scale;
uniform vec4 uCustomColor;
uniform sampler2D myTex;

uniform vec4 uColor;

varying vec2 vTextureCoord;
varying vec4 vColor;
varying vec3 vTimeVec;

varying float vScaleZ;
varying float vScaleX;
varying float vScaleY;

varying float vWidth;
varying float vScaleMode;

void main() {

    vec4 newColor = vec4(0.0, 0.0, 0.0, 1.0);

    float lineWidth = 0.008;
//    float lineWidth = 0.01;

    float leftX = -(vWidth * vScaleX / 2.0) + lineWidth;
    float rightX = (vWidth * vScaleX / 2.0) - lineWidth / 2.0;

    float bottomY;
    float topY;

    if (vScaleMode == 1.0) {
        bottomY = lineWidth;
        topY = vWidth * vScaleY - lineWidth / 2.0;
    } else {
        bottomY = -vWidth * vScaleY + lineWidth;
        topY = -lineWidth / 2.0;
    }

    float backZ = -(vWidth * vScaleZ / 2.0) + lineWidth;
    float frontZ = (vWidth * vScaleZ / 2.0) - lineWidth / 2.0;

    float rX = smoothstep(leftX, rightX, vTimeVec.x);
    float rZ = smoothstep(backZ, frontZ, vTimeVec.z);
    float rY = smoothstep(bottomY, topY, vTimeVec.y);

    if (
        (rX == GT && rY == GT) ||
        (rX == GT && rZ == GT) ||
        (rY == GT && rZ == GT) ||

        (rX == LT && rY == LT) ||
        (rX == LT && rZ == LT) ||
        (rY == LT && rZ == LT) ||

        (rX == GT && rY == LT) ||
        (rX == GT && rZ == LT) ||
        (rY == GT && rZ == LT) ||

        (rX == LT && rY == GT) ||
        (rX == LT && rZ == GT) ||
        (rY == LT && rZ == GT)

    ) {
//        newColor.g = 0.659;
        newColor.g = uColor.y;
//        newColor.r = 0.976;
        newColor.r = uColor.x;
//        newColor.b = 0.192;
        newColor.b = uColor.z;
    }

    gl_FragColor = newColor;
}