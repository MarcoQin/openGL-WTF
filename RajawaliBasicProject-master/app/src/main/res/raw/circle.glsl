precision mediump float;
 varying vec2 vTextureCoord;
 void main() {
// gl_FragColor  = vec4(0, 0, 0, 1.0);
 //    gl_FragColor = ( length(vTextureCoord.xy - 0.5) < 0.5 ) ? (length(vTextureCoord.xy - 0.5) > 0.49 ? vec4(1.0,1.0,1.0,1.0) : vec4(0,0,0,1.0)) : vec4(0,0,0,1.0);
    float r = length(vTextureCoord.xy - 0.5);
    vec4 newColor = vec4(0, 0, 0, 1.0);
    float r1 = 0.5;
    float r2 = 0.3;
    float r3 = 0.1;
    float thick = 0.005;
    if ((r < r1 && r > (r1 - thick)) || (r < r2 && r > (r2 - thick)) || (r < r3 && r > (r3 - thick))) {
        newColor.rgb = vec3(1.0, 1.0, 1.0);
    }
    gl_FragColor = newColor;
 }
