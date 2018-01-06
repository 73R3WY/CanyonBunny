package jeremypacabis.libgdx.canyonbunny;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Jeremy Patrick on 7/21/2016.
 * Author: Jeremy Patrick G. Pacabis
 * for jeremypacabis.libgdx.canyonbunny @ CanyonBunny
 */
public class Feather extends AbstractGameObject {
    private TextureRegion regFeather;
    public boolean collected;

    public Feather() {
        init();
    }

    private void init() {
        dimension.set(0.5f, 0.5f);
        regFeather = Assets.instance.feather.feather;
// Set bounding box for collision detection
        bounds.set(0, 0, dimension.x, dimension.y);
        collected = false;
    }

    public int getScore() {
        return 250;
    }


    @Override
    public void render(SpriteBatch batch) {
        if (collected) return;
        TextureRegion reg = null;
        reg = regFeather;
        batch.draw(reg.getTexture(), position.x, position.y,
                origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
                rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }
}
