precision mediump float;

uniform float uColorInfluence;
uniform float uTime;
uniform float uInfluencemyTex;
uniform float scale;
uniform vec4  uCustomColor;
uniform sampler2D myTex;
uniform float uScaleZ;
uniform float uScaleX;
uniform float uScaleY;

attribute vec4 aPosition;

varying vec2 vTextureCoord;
varying vec4 vColor;

void main() {
        vec3 directionVec = normalize(vec3(aPosition));

        vec3 tmpVec = vec3(directionVec.x/uScaleX,directionVec.y/uScaleY,directionVec.z/uScaleZ);

        vec4 newColor = vec4(0.0, 0.0, 0.0, 1.0);

        if ((tmpVec.x < 0.02 && tmpVec.z == 1.0) || ((1.0 - tmpVec.x) < 0.02 && tmpVec.z == 1.0)) {
             newColor.g = 1.0;
             newColor.r = 1.0;
             newColor.b = 1.0;
        }

        gl_FragColor = newColor;
}
