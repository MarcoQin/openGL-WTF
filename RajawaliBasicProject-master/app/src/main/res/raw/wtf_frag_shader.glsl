precision mediump float;

uniform float uColorInfluence;
uniform float uTime;
uniform float uInfluencemyTex;
uniform float scale;
uniform vec4  uCustomColor;
uniform sampler2D myTex;
uniform float uscalex;
//uniform float uscaley;
//uniform float uscalez;

varying vec2 vTextureCoord;
varying vec4 vColor;

void main() {
        vec4 newColor = vec4(0.0, 0.0, 0.0, 1.0);
//        float x = min(vTextureCoord.s, 1.0 - vTextureCoord.s);
//        float y = min(vTextureCoord.t, 1.0 - vTextureCoord.t);
//
//        if (x < 0.01) {
//            newColor.g = 1.0;
//            newColor.r = 1.0;
//            newColor.b = 1.0;
//        }
//
//        if (y < 0.01) {
//            newColor.g = 1.0;
//            newColor.r = 1.0;
//            newColor.b = 1.0;
//        }
//        gl_FragColor = newColor;


                float x = vTextureCoord.x;
                float y = vTextureCoord.y;
                float lineThick = 0.02;
//                float scale = uscalex;
//                if (scale < 1.0){
//                    scale += 1.0;
//                } else if (scale > 1.0) {
//                    scale -= 1.0;
//                 }

//                lineThick *= scale;
                if (x <= lineThick || y <= lineThick || x >= 1.0- lineThick || y >= 1.0-lineThick) {
                    newColor.g = 0.62;
                    newColor.r = 0.9;
                    newColor.b = 0.17;
        //            newColor.a = 0;
                } else {
                    newColor.a = 0.5;
                 }
                 gl_FragColor = newColor;
}
