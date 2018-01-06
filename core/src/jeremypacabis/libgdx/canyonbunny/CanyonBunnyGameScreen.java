package jeremypacabis.libgdx.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Jeremy Patrick on 7/20/2016.
 * Author: Jeremy Patrick G. Pacabis
 * for jeremypacabis.libgdx.canyonbunny @ CanyonBunny
 */
public class CanyonBunnyGameScreen implements Screen {
    final CanyonBunny game;
    private static final String TAG = CanyonBunnyGameScreen.class.getName();
    private WorldController worldController;
    private WorldRenderer worldRenderer;
    private boolean paused;

    public CanyonBunnyGameScreen(final CanyonBunny game) {
        this.game = game;
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Assets.instance.init(new AssetManager());
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
        paused = false;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (!paused) {
            worldController.update(delta);
        }

        Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        worldRenderer.dispose();
        Assets.instance.dispose();
    }
}
