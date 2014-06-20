package gem.sparseboolean.chameleonbox;

import gem.sparseboolean.math.Vector3;
import gem.sparseboolean.math.Vector4;
import gem.sparseboolean.math.Point3D;

import android.graphics.Color;

import java.util.ArrayList;

public abstract class IconTextureSource {
    public enum TransformIndex
    {
      TRANSFORM_TILE,
      TRANSFORM_IMAGE,
      TRANSFORM_HIT_AREA,
      TRANSFORM_GLOW,
      TRANSFORM_EMBLEM,
      TRANSFORM_SIZE
    }

    public IconTextureSource() {}

    public ArrayList<Vector4> getTransform(TransformIndex index, int monitor) {//TODO
        return null;
    }

    public Point3D lastRenderCenter(int monitor) { // todo
        return null;
    }
    
    public Point3D lastLogicalCenter(int monitor) {
        return null;
    }
    
    public Vector3 lastRotation(int monitor) {
        return null;
    }
    
    public void rememberCenters(int monitor, Point3D render, Point3D logical) {
    }
    public void rememberRotation(int monitor, Vector3 rotation) {
        
    }

    public void rememberSkip(int monitor, boolean skip) {
        
    }
    public boolean sasSkipping(int monitor) {
        return false;
    }

    public void rememberEmblem(int monitor, boolean has_emblem) {
        
    }
    public boolean hadEmblem(int monitor) {
        
    }

    public abstract Color backgroundColor();

    public abstract Color glowColor();

    virtual nux::BaseTexture* TextureForSize(int size) = 0;

    virtual nux::BaseTexture* Emblem() = 0;

  private ArrayList<Boolean> skip_;
  private ArrayList<Boolean> had_emblem_;
  private ArrayList<Point3D> last_render_center_;
  private ArrayList<Point3D> last_logical_center_;
  private ArrayList<Vector3> last_rotation_;
  private ArrayList<ArrayList<ArrayList<Vector4>>> transformations_;
}
