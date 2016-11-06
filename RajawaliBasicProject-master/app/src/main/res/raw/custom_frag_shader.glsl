precision mediump float;

uniform float uColorInfluence;
uniform float uTime;
uniform float uInfluencemyTex;
uniform float scale;
uniform vec4  uCustomColor;
uniform sampler2D myTex;

varying vec2 vTextureCoord;
varying vec4 vColor;

void main() {
        vec4 newColor = vec4(0.0, 0.0, 0.0, 1.0);
        float x = min(vTextureCoord.s, 1.0 - vTextureCoord.s);
        float y = min(vTextureCoord.t, 1.0 - vTextureCoord.t);

        if (x < 0.01) {
            newColor.g = 1.0;
            newColor.r = 1.0;
            newColor.b = 1.0;
        }

        if (y < 0.01) {
            newColor.g = 1.0;
            newColor.r = 1.0;
            newColor.b = 1.0;
        }
        gl_FragColor = newColor;
}
