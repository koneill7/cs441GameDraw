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
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;



public class drawGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer drawShape;
	OrthographicCamera camera;
	Rectangle grass, r1, r2, r3, water;
	Circle sunOuter, sunInner, collision; //collision is for detecting shapes being touched on collision

	int moveGrass, moveSunOut, moveSunIn, moveR1, moveR2, moveR3, moveWater = 0; //0 is initial state before a shape is clicked
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("Characters/badlogic.jpg");
		drawShape = new ShapeRenderer();
		grass = new Rectangle(200, 1000, 100, 2000);
		sunOuter = new Circle(300, 750, 100);
		sunInner = new Circle(1000, 750, 75);
		r1 = new Rectangle(1600, 800, 75, 2000);
		r2 = new Rectangle(700, 900, 125, 2000);
		r3 = new Rectangle(300, 200, 200, 2000);
		water = new Rectangle(20, 890, 200, 2000);

		collision = new Circle(); //collision circle is never drawn, so on touch collision is invisible

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 2000, 1200);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		drawShape.setProjectionMatrix(camera.combined);

		drawShape.begin(ShapeType.Filled);

		if(moveGrass == 1) grass.setPosition(1000, 0);
		if(moveSunOut == 1) sunOuter.setPosition(1000, 600);
		if(moveSunIn == 1) sunInner.setPosition(1000, 600);
		if(moveR1 == 1) r1.setPosition(930, 0);
		if(moveR2 == 1) r2.setPosition(820,0);
		if(moveR3 == 1) r3.setPosition(650, 0);
		if(moveWater == 1) water.setPosition(1050,0);

		drawShape.setColor(Color.PINK);
		drawShape.rect(r1.x, r1.y, r1.width, r1.height);
		drawShape.setColor(1, 0.5f, 0, 1);
		drawShape.rect(r2.x, r2.y, r2.width, r2.height);
		drawShape.setColor(Color.YELLOW);
		drawShape.rect(r3.x, r3.y, r3.width, r3.height);
		drawShape.setColor(Color.CYAN);
		drawShape.rect(water.x, water.y, water.width, water.height);

		drawShape.setColor(Color.ORANGE);
		drawShape.circle(sunOuter.x, sunOuter.y, sunOuter.radius);
		drawShape.setColor(1f, 0.5f, 0, 1);
		drawShape.circle(sunInner.x, sunInner.y, sunInner.radius);
		drawShape.setColor(0, 1, 0, 1);
		drawShape.rect(grass.x, grass.y, grass.width, grass.height);

		drawShape.end();


		if(Gdx.input.isTouched()){
			collision.set(Gdx.input.getX(),Gdx.graphics.getHeight() - Gdx.input.getY() + 200, 80);
			if(Intersector.overlaps(collision, sunOuter)) moveSunOut = (moveSunOut == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, sunInner)) moveSunIn = (moveSunIn == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, grass)) moveGrass = (moveGrass == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, r1)) moveR1 = (moveR1 == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, r2)) moveR2 = (moveR2 == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, r3)) moveR3 = (moveR3 == 0) ? 1 : 0;
			if(Intersector.overlaps(collision, water)) moveWater = (moveWater == 0) ? 1 : 0;
		}

	}
	
	//@Override
	//public void dispose () {
	//	batch.dispose();
	//	img.dispose();
	//}

}
