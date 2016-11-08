package com.clintonmedbery.rajawalibasicproject;

import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.shaders.FragmentShader;
import org.rajawali3d.materials.shaders.VertexShader;


public class WTFMaterial extends Material {


    public WTFMaterial() {
        super(false);
    }

    public WTFMaterial(boolean deferCapabilitiesCheck) {
        super(deferCapabilitiesCheck);
    }

    public WTFMaterial(boolean a, boolean b) {
        super(new WTFVertexShader(), new WTFFragmentShader(), false);
    }

    public WTFMaterial(VertexShader customVertexShader, FragmentShader customFragmentShader) {
        super(customVertexShader, customFragmentShader);
    }

    public WTFMaterial(VertexShader customVertexShader, FragmentShader customFragmentShader, boolean deferCapabilitiesCheck) {
        super(customVertexShader, customFragmentShader, deferCapabilitiesCheck);
    }

    public WTFVertexShader getVetexShader(){
        return (WTFVertexShader) this.mCustomVertexShader;
    }

    public FragmentShader getFragmentShader() {
        return this.mCustomFragmentShader;
    }
}
