precision highp float;

const float GT = 1.0;
const float LT = 0.0;

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

void main() {
    vec4 newColor = vec4(vTimeVec.x,vTimeVec.y,vTimeVec.z, 1.0);

//    vec4 newColor = vec4(0.0,0.0,0.0,1.0);

    float lineWidth = 0.008 * vScaleX;

    float leftX = - (vWidth / 2.0) + lineWidth;
    float rightX = (vWidth / 2.0) - lineWidth / 2.0;

    float bottomY = lineWidth;
    float topY = vWidth - lineWidth / 2.0;

    float backZ = - (vWidth / 2.0) + lineWidth;
    float frontZ = (vWidth / 2.0) - lineWidth / 2.0;

    float rX = smoothstep(leftX,rightX,vTimeVec.x);
    float rZ = smoothstep(backZ,frontZ,vTimeVec.z);
    float rY = smoothstep(bottomY,topY,vTimeVec.y);

    if ( (rX == LT) ||
    (rX == GT && rY == GT) ||
    (rX == GT && rZ == GT) ||
    (rY == GT && rZ == GT) ||
    (rZ == LT) ||
    (rY == LT)) {
         newColor.g = 1.0;
         newColor.r = 0.0;
         newColor.b = 0.0;
    }

    gl_FragColor = newColor;
}
