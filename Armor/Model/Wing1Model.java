package FizzyClubMods.Armor.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Wing1Model extends ModelBase
{
  ModelRenderer WingL;
  ModelRenderer WingR;

  public Wing1Model()
  {
    textureWidth = 128;
    textureHeight = 128;

    WingL = new ModelRenderer(this, 0, -40);
    WingL.addBox(0.0F, -25.0F, 1.0F, 0, 40, 40);
    WingL.setRotationPoint(-2.0F, 18.0F, 0.0F);
    WingL.setTextureSize(128, 128);
    WingL.mirror = true;
    setRotation(WingL, 0.0F, -0.4363323F, 0.0F);
    WingR = new ModelRenderer(this, 0, -40);
    WingR.addBox(2.0F, -25.0F, 2.0F, 0, 40, 40);
    WingR.setRotationPoint(0.0F, 18.0F, 0.0F);
    WingR.setTextureSize(128, 128);
    WingR.mirror = true;
    setRotation(WingR, 0.0F, 0.4363323F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    WingL.render(f5);
    WingR.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

  public void renderWing(float f)
  {
    WingL.render(f);
    WingR.render(f);
  }
}