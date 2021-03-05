package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class drawGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer drawShape;
	OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Characters/badlogic.jpg");
		camera = new OrthographicCamera(500,800);
		drawShape = new ShapeRenderer();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		camera.update();
		drawShape.setProjectionMatrix(camera.combined);

		drawShape.begin(ShapeType.Line);
		drawShape.setColor(255, 255, 204, 1);
		drawShape.line(-10, 0, 10, 0);
		drawShape.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}
