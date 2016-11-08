precision mediump float;

const float GT = 1.0;
const float LT = 0.0;

#define Thickness 0.003

uniform float uColorInfluence;
uniform float uTime;
uniform float uInfluencemyTex;
uniform float scale;
uniform vec4  uCustomColor;
uniform sampler2D myTex;

varying vec2 vTextureCoord;
varying vec4 vColor;
varying vec3 vTimeVec;

varying float vScaleZ;
varying float vScaleX;
varying float vScaleY;

varying float vWidth;
varying float vScaleMode;

void main() {
//    vec4 newColor = vec4(vTimeVec.x,vTimeVec.y,vTimeVec.z, 1.0);

    vec4 newColor = vec4(0.0,0.0,0.0,1.0);

    float lineWidth = 0.004;

    float leftX = - (vWidth * vScaleX / 2.0) + lineWidth;
    float rightX = (vWidth * vScaleX / 2.0) - lineWidth / 2.0;

    float bottomY;
    float topY;

    if (vScaleMode == 1.0) {
        bottomY = lineWidth;
        topY = vWidth * vScaleY - lineWidth / 2.0;
    } else {
        bottomY =  - vWidth * vScaleY + lineWidth;
        topY = - lineWidth / 2.0;
    }

    float backZ = - (vWidth * vScaleZ / 2.0) + lineWidth;
    float frontZ = (vWidth * vScaleZ / 2.0) - lineWidth / 2.0;

    float rX = smoothstep(leftX,rightX,vTimeVec.x);
    float rZ = smoothstep(backZ,frontZ,vTimeVec.z);
    float rY = smoothstep(bottomY,topY,vTimeVec.y);

    if ( (rX == LT) ||
    (rX == GT && rY == GT) ||
    (rX == GT && rZ == GT) ||
    (rY == GT && rZ == GT) ||
    (rZ == LT) ||
    (rY == LT)) {
         newColor.g = 0.659;
         newColor.r = 0.976;
         newColor.b = 0.192;
    }

    gl_FragColor = newColor;
}
