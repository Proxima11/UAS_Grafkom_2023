import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;

public class Test {
    private Window window =
            new Window
                    (800,800,"Hello World");
    private ArrayList<Object> objects
            = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    boolean pressed = false;
    boolean pressed1 = false;
    float rotation = 0.0f;

    public void init(){
        window.init();
        GL.createCapabilities();

        camera.setPosition(0.0f, 0.0f, 1.5f);
        camera.setRotation(((float)Math.toRadians(0.0f)), ((float) Math.toRadians(0.0f)));

        //code
        objects.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0,0,0), 1f, 1f, 1f
        ));


    }

    public void setPos(){
        Vector3f pos = objects.get(0).model.transformPosition(new Vector3f());

        ArrayList<Vector3f> vertices = new ArrayList<>(List.of());

        for(double i=0;i<360;i+=360/360){
            float x = (float)(pos.x + 2f*Math.sin(Math.toRadians(i)));
            float z = (float)(pos.z + 2f*Math.cos(Math.toRadians(i)));
            vertices.add(new Vector3f(x, pos.y, z));
        }

        camera.setPosition(vertices.get((int)rotation).x,vertices.get((int)rotation).y, vertices.get((int)rotation).z);
    }

    public void input(){

        float move = 0.5f;

        if (window.isKeyPressed(GLFW_KEY_W)){
            camera.moveForward(move);
        }
        else if (window.isKeyPressed(GLFW_KEY_S)){
            camera.moveBackwards(move);
        }

        if (window.isKeyPressed(GLFW_KEY_A)){
            camera.moveLeft(move);
        }
        else if (window.isKeyPressed(GLFW_KEY_D)){
            camera.moveRight(move);
        }


        if (window.getMouseInput().isLeftButtonPressed()){
            Vector2f displVec = window.getMouseInput().getDisplVec();
            camera.addRotation((float) Math.toRadians(displVec.x * 0.1f), (float) Math.toRadians(displVec.y * 0.1f));
        }

        if (window.getMouseInput().getScroll().y != 0){
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.1f));
            window.getMouseInput().setScroll(new Vector2f());
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT)){
            objects.get(0).translateObject(-0.05f, 0.0f, 0.0f);
            setPos();
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)){
            objects.get(0).translateObject(0.05f, 0.0f, 0.0f);
            setPos();
        }

        if (window.isKeyPressed(GLFW_KEY_UP)){
            objects.get(0).translateObject(0.0f, 0.0f, -0.05f);
            setPos();
        }

        if (window.isKeyPressed(GLFW_KEY_DOWN)){
            objects.get(0).translateObject(0.0f, 0.0f, 0.05f);
            setPos();
        }

        if (window.isKeyPressed(GLFW_KEY_P)){
            objects.get(0).translateObject(0.0f, 0.05f, 0.0f);
            setPos();
        }

        if (window.isKeyPressed(GLFW_KEY_O)){
            objects.get(0).translateObject(0.0f, -0.05f, 0.0f);
            setPos();
        }



        if (window.isKeyPressed(GLFW_KEY_M)){
            pressed = true;
        }

        if (pressed){
            float posx = camera.getPosition().x;
            float posy = camera.getPosition().y;
            float posz = camera.getPosition().z;

            camera.setPosition(-posx, -posy, -posz);
            camera.addRotation(0.0f, (float) Math.toRadians(move));
            camera.setPosition(posx, posy, posz);

            rotation += move;

            if (rotation >= 360.0f){
                rotation = 0.0f;
                pressed = false;
            }
        }

        if (window.isKeyPressed(GLFW_KEY_B)){
            move = 1f;
            Vector3f pos = objects.get(0).model.transformPosition(new Vector3f());
            Vector3f posCam = camera.getPosition();

            ArrayList<Vector3f> vertices = new ArrayList<>(List.of());

            for(double i=0;i<360;i+=360/360){
                float x = (float)(pos.x + 2f*Math.sin(Math.toRadians(i)));
                float z = (float)(pos.z + 2f*Math.cos(Math.toRadians(i)));
                vertices.add(new Vector3f(x, pos.y, z));
            }

            camera.setPosition(vertices.get(0).x, vertices.get(0).y, vertices.get(0).z);

            camera.setPosition(-posCam.x, 0, -posCam.z);
            camera.addRotation(0.0f, (float) Math.toRadians(-move));
            camera.setPosition(posCam.x, 0, posCam.z);

            rotation += move;

            if (rotation > 359.0f){
                rotation = 0.0f;
            }

            camera.setPosition(vertices.get((int)rotation).x,vertices.get((int)rotation).y, vertices.get((int)rotation).z );
        }

        if (window.isKeyPressed(GLFW_KEY_V)){
            pressed1 = false;
        }

        if (window.isKeyPressed(GLFW_KEY_C)){
            camera.setPosition(0,0, 1.5f);
        }
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();

            input();

            //code

            for(Object object: objects){
                object.draw(camera, projection);
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Test().run();
    }
}

