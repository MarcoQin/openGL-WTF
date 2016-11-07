// -- normalized axis vectors. we'll use these to
//    get the angles
const vec3 cXaxis = vec3(1.0, 0.0, 0.0);
const vec3 cYaxis = vec3(0.0, 1.0, 0.0);
const vec3 cZaxis = vec3(0.0, 0.0, 1.0);
// -- the amplitude of the 'wave' effect
const float cStrength = 0.5;

uniform mat4 uMVPMatrix;
uniform float uTime;

uniform float uScaleZ;
uniform float uScaleX;
uniform float uScaleY;

attribute vec4 aPosition;
attribute vec2 aTextureCoord;
attribute vec4 aColor;

varying vec2 vTextureCoord;
varying vec4 vColor;

void main() {
    // -- normalized direction from the origin (0,0,0)

    vec3 directionVec = normalize(vec3(aPosition));

    vec4 timeVec = vec4(directionVec, 1.0);

    float time = uTime * 0.05;
    // -- multiply all the parameters to get the final

    timeVec.x = directionVec.x;
    timeVec.y = directionVec.y;
    timeVec.z = directionVec.z * uScaleZ;

//    vColor = vec4(timeVec.x,timeVec.y,timeVec.z, 1.0);
    if (timeVec.z < 0.0) {
        timeVec.z = 0.0;
    }

    if (timeVec.x < 0.0) {
        timeVec.x = 0.0;
    }

    if (timeVec.y < 0.0) {
        timeVec.y = 0.0;
    }

    vec3 tmpVec = vec3(timeVec.x/uScaleX,timeVec.y/uScaleY,timeVec.z/uScaleZ);

    if (tmpVec.z > 1.0) {
        tmpVec.z = 1.0;
    }

    if (tmpVec.x > 1.0) {
        tmpVec.x = 1.0;
    }

    if (tmpVec.y > 1.0) {
        tmpVec.y = 1.0;
    }

    vec4 newColor = vec4(tmpVec.x,tmpVec.y,tmpVec.z, 1.0);

       float b = 0.2;
    if ((tmpVec.x < b && abs(tmpVec.z - 1.0) < b) || ((1.0 - tmpVec.x) < b && abs(tmpVec.z - 1.0) < b)) {
         newColor.g = 1.0;
         newColor.r = 1.0;
         newColor.b = 1.0;
    }

    vec4 newPosition = uMVPMatrix * timeVec;
    gl_Position = newPosition;
    vTextureCoord = aTextureCoord;

    vColor = newColor;
    // -- use the (normalized) direction vector as the
    //    vertex color to get a nice colorful effect
}