package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;

import java.awt.Rectangle;

public class drawGame extends ApplicationAdapter {
	//SpriteBatch batch;
	//Texture img;
	ShapeRenderer drawShape;
	OrthographicCamera camera;
	Rectangle grass;
	Circle sunOuter, sunInner;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("Characters/badlogic.jpg");
		drawShape = new ShapeRenderer();
		grass = new Rectangle();
		sunOuter = new Circle();
		sunInner = new Circle();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 400, 250);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		camera.update();
		drawShape.setProjectionMatrix(camera.combined);

		grass.setLocation(210, 0);
		grass.setSize(80, 20);
		sunOuter.set(200, 125, 20);
		sunInner.set(200, 125, 15);

		drawShape.begin(ShapeType.Filled);
		drawShape.setColor(Color.ORANGE);
		drawShape.circle(sunOuter.x, sunOuter.y, sunOuter.radius);
		drawShape.setColor(1f, 0.5f, 0, 1);
		drawShape.circle(sunInner.x, sunInner.y, sunInner.radius);
		drawShape.setColor(0, 1, 0, 1);
		drawShape.rect(grass.x, grass.y, grass.width, grass.height);
		drawShape.end();

	}
	
	//@Override
	//public void dispose () {
		//batch.dispose();
		//img.dispose();
	//}

}
