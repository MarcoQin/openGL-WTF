precision mediump float;
varying vec2 vTextureCoord;
void main() {
gl_FragColor  = vec4(0, 0, 0, 1.0);
//    gl_FragColor = ( length(vTextureCoord.xy - 0.5) < 0.5 ) ? (length(vTextureCoord.xy - 0.5) > 0.49 ? vec4(1.0,1.0,1.0,1.0) : vec4(0,0,0,1.0)) : vec4(0,0,0,1.0);
}
