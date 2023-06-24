import Engine.*;
import Engine.Object;
import org.joml.*;
import org.lwjgl.opengl.GL;

import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window = new Window(1080, 1080, "Hello World");
    ArrayList<Object> objectObj = new ArrayList<>();
    ArrayList<Object> objectGround = new ArrayList<>();
    ArrayList<Object> objectAsteroid = new ArrayList<>();
    ArrayList<Object> objectToko = new ArrayList<>();

    ArrayList<Object> objectdekorasiToko = new ArrayList<>();
    ArrayList<Object> objectSampah = new ArrayList<>();
    ArrayList<Object> objectMejaKursi = new ArrayList<>();
    ArrayList<Object> objectSpaceship = new ArrayList<>();
    ArrayList<Object> objectFountain = new ArrayList<>();
    ArrayList<Object> objectAstronaut = new ArrayList<>();


    ArrayList<Object> posisiLight = new ArrayList<>();
    ArrayList<Object> hitboxEnvironment = new ArrayList<>();
    ArrayList<Object> hitboxPerson = new ArrayList<>();
    ArrayList<Object> hitboxAlien = new ArrayList<>();
    ArrayList<Object> hitboxSampah = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    float distance = 1f;
    float angle = 0f;
    float rotation = (float)Math.toRadians(1f);
    float move = 0.01f;
    List<Float> temp;
    int carPos = 0;
    int modeToggle = 0;
    int carPos2 = 0;
    boolean delay = false;
    int delayCounter = 0;
    boolean start = false;
    boolean malam = true;
    boolean delay2 = false;
    int delayCounter2 = 0;
    boolean delay3 = false;
    int delayCounter3 = 0;


    public void run() throws IOException {

        init();
        loop();

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init() throws IOException {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0f, 0f, 2.5f + distance);

        //botol sementara
        objectObj.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,1f,1.0f),
                "resources/model/Bottle/Bottle.obj"
        ));

        objectObj.get(0).scaleObject(0.01f,0.01f,0.01f);
        objectObj.get(0).translateObject(0.0f, 0.0f, 0f);

        //asteroid_Ground
        objectGround.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/untitled.obj"
        ));

        objectGround.get(0).scaleObject(0.05f,0.05f,0.03f);
        objectGround.get(0).translateObject(-0.1f, -0.82f, 0.05f);

        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidkecil.obj"
        ));

        objectAsteroid.get(0).scaleObject(0.1f,0.1f,0.1f);
        objectAsteroid.get(0).translateObject(-0.3f, -0.82f, -8f);


        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidkecil2.obj"
        ));

        objectAsteroid.get(1).scaleObject(0.1f,0.1f,0.1f);
        objectAsteroid.get(1).translateObject(-5f, -0.7f, -6f);

        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidkecil2.obj"
        ));

        objectAsteroid.get(2).scaleObject(0.05f,0.05f,0.05f);
        objectAsteroid.get(2).translateObject(11f, 3f, -2f);

        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidkecil2.obj"
        ));

        objectAsteroid.get(3).scaleObject(0.05f,0.05f,0.05f);
        objectAsteroid.get(3).translateObject(-9f, -4f, 5f);

        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidbesar.obj"
        ));

        objectAsteroid.get(4).scaleObject(0.05f,0.05f,0.05f);
        objectAsteroid.get(4).translateObject(-7f, -3f, -10f);

        objectAsteroid.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.330f,0.333f,0.333f,1.0f),
                "resources/model/asteroid/asteroidbesar.obj"
        ));

        objectAsteroid.get(5).scaleObject(0.05f,0.05f,0.05f);
        objectAsteroid.get(5).rotateObject(0.5f, 0.0f, 0.0f,1.0f);
        objectAsteroid.get(5).translateObject(3f, -1f, 8f);


        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f,0.513f,0.410f,1.0f),
                "resources/model/toko/lt2badan.obj"
        ));

        objectToko.get(0).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(0).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/atap1.obj"
        ));

        objectToko.get(1).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(1).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f,0.513f,0.410f,1.0f),
                "resources/model/toko/lt1.obj"
        ));

        objectToko.get(2).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(2).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f,0.710f,0.710f,1.0f),
                "resources/model/toko/bannerlt1.obj"
        ));

        objectToko.get(3).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(3).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.610f,0.533f,0.470f,1.0f),
                "resources/model/toko/penyanggalt1.obj"
        ));

        objectToko.get(4).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(4).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/toko/piring_dan_kertas.obj"
        ));

        objectToko.get(5).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(5).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,0f,1.0f),
                "resources/model/toko/gelas.obj"
        ));

        objectToko.get(6).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(6).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.137f,0.530f,0.0848f,1.0f),
                "resources/model/toko/botol.obj"
        ));

        objectToko.get(7).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(7).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampion.obj"
        ));

        objectToko.get(8).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(8).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/kursitinggiobj.obj"
        ));

        objectToko.get(9).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(9).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/toko/bawahgalon.obj"
        ));

        objectToko.get(10).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(10).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,1f,1.0f),
                "resources/model/toko/galon.obj"
        ));

        objectToko.get(11).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(11).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/lt2atap.obj"
        ));

        objectToko.get(12).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(12).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.393f,0.393f,0.393f,1.0f),
                "resources/model/toko/listrik_tong.obj"
        ));

        objectToko.get(13).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(13).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/kerangka.obj"
        ));

        objectToko.get(14).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(14).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,0f,1.0f),
                "resources/model/toko/penyanggabanner.obj"
        ));

        objectToko.get(15).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(15).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.630f,0.469f,0.258f,1.0f),
                "resources/model/toko/banner.obj"
        ));

        objectToko.get(16).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(16).translateObject(0.0f, 0.0f, 0f);

        objectToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f,0.710f,0.710f,1.0f),
                "resources/model/toko/bannerluar_karpet.obj"
        ));

        objectToko.get(17).scaleObject(0.1f,0.1f,0.1f);
        objectToko.get(17).translateObject(0.0f, 0.0f, 0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/tiang_banner1.obj"
        ));

        objectdekorasiToko.get(0).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(0).translateObject(-0.25f, -0.02f, -0.1f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/isi_banner.obj"
        ));

        objectdekorasiToko.get(1).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(1).translateObject(-0.25f, -0.02f, -0.1f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/tiang_lampionkiri.obj"
        ));

        objectdekorasiToko.get(2).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(2).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/tiang_lampionkanan.obj"
        ));

        objectdekorasiToko.get(3).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(3).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.250f,0.177f,1.0f),
                "resources/model/toko/tiang_lampiontengah.obj"
        ));

        objectdekorasiToko.get(4).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(4).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampionkiri.obj"
        ));

        objectdekorasiToko.get(5).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(5).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampionkiritengah.obj"
        ));

        objectdekorasiToko.get(6).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(6).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampiontengah.obj"
        ));

        objectdekorasiToko.get(7).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(7).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampionkanantengah.obj"
        ));

        objectdekorasiToko.get(8).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(8).translateObject(1.8f, -0.02f, 0.0f);

        objectdekorasiToko.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,0f,0f,1.0f),
                "resources/model/toko/lampionkanan.obj"
        ));

        objectdekorasiToko.get(9).scaleObject(5f,5f,5f);
        objectdekorasiToko.get(9).translateObject(1.8f, -0.02f, 0.0f);

        objectSampah.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,0f,1.0f),
                "resources/model/sampah/sampah1.obj"
        ));

        objectSampah.get(0).scaleObject(0.1f,0.1f,0.1f);
        objectSampah.get(0).translateObject(0.0f, 0.0f, 0f);

        objectSampah.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,0f,1.0f),
                "resources/model/sampah/sampah2.obj"
        ));

        objectSampah.get(1).scaleObject(0.1f,0.1f,0.1f);
        objectSampah.get(1).translateObject(0.0f, 0.0f, 0f);

        objectSampah.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.196f,0.430f,0.155f,1.0f),
                "resources/model/sampah/tong_sampah_besar.obj"
        ));

        objectSampah.get(2).scaleObject(0.1f,0.1f,0.1f);
        objectSampah.get(2).translateObject(0.0f, 0.0f, 0f);

        objectSampah.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.620f,0.541f,0.384f,1.0f),
                "resources/model/sampah/kerdus.obj"
        ));

        objectSampah.get(3).scaleObject(0.1f,0.1f,0.1f);
        objectSampah.get(3).translateObject(0.0f, 0.0f, 0f);


        objectMejaKursi.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.620f,0.541f,0.384f,1.0f),
                "resources/model/mejakursi/mejakursi.obj"
        ));

        objectMejaKursi.get(0).scaleObject(0.4f,0.4f,0.4f);
        objectMejaKursi.get(0).rotateObject(-0.3f,0.0f,1f,0.0f);
        objectMejaKursi.get(0).translateObject(-1.3f, -0.105f, 0.8f);

        objectMejaKursi.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.620f,0.541f,0.384f,1.0f),
                "resources/model/mejakursi/mejakursi.obj"
        ));

        objectMejaKursi.get(1).scaleObject(0.4f,0.4f,0.4f);
//        objectMejaKursi.get(0).rotateObject(-0.3f,0.0f,1f,0.0f);
        objectMejaKursi.get(1).translateObject(0f, -0.105f, 1.1f);

        objectMejaKursi.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.620f,0.541f,0.384f,1.0f),
                "resources/model/mejakursi/mejakursi.obj"
        ));

        objectMejaKursi.get(2).scaleObject(0.4f,0.4f,0.4f);
        objectMejaKursi.get(2).rotateObject(0.3f,0.0f,1f,0.0f);
        objectMejaKursi.get(2).translateObject(1.2f, -0.105f, 1.1f);

        objectSpaceship.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,1f,1.0f),
                "resources/model/spaceship/mainbody.obj"
        ));


        objectSpaceship.get(0).scaleObject(0.4f,0.4f,0.4f);
        objectSpaceship.get(0).translateObject(-2.7f, -0.0f, 0.5f);

        objectSpaceship.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,1f,1.0f),
                "resources/model/spaceship/sayapkiri.obj"
        ));


        objectSpaceship.get(1).scaleObject(0.4f,0.4f,0.4f);
        objectSpaceship.get(1).translateObject(-2.7f, -0.0f, 0.5f);

        objectSpaceship.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,1f,1.0f),
                "resources/model/spaceship/sayapkanan.obj"
        ));


        objectSpaceship.get(2).scaleObject(0.4f,0.4f,0.4f);
        objectSpaceship.get(2).translateObject(-2.7f, -0.0f, 0.5f);

        objectSpaceship.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f),
                "resources/model/spaceship/kursiPenumpang.obj"
        ));

        objectSpaceship.get(3).scaleObject(0.4f,0.4f,0.4f);
        objectSpaceship.get(3).translateObject(-2.7f, -0.0f, 0.5f);

        objectSpaceship.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/spaceship/penutup.obj"
        ));

        objectSpaceship.get(4).scaleObject(0.4f,0.4f,0.4f);
        objectSpaceship.get(4).translateObject(-2.7f, -0.0f, 0.5f);

        objectFountain.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.670f,0.670f,0.670f,1.0f),
                "resources/model/fountain/badanfountain.obj"
        ));

        objectFountain.get(0).scaleObject(0.15f,0.15f,0.15f);
        objectFountain.get(0).translateObject(-1.9f, 0.0f, -0.9f);

        objectFountain.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0192f,0.402f,0.640f,1.0f),
                "resources/model/fountain/air.obj"
        ));

        objectFountain.get(1).scaleObject(0.15f,0.15f,0.15f);
        objectFountain.get(1).translateObject(-1.9f, 0.0f, -0.9f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/helm.obj"
        ));

        objectAstronaut.get(0).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(0).translateObject(-2.2f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,0f,1.0f),
                "resources/model/astronaut/tutuphelm.obj"
        ));

        objectAstronaut.get(1).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(1).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/badan2.obj"
        ));

        objectAstronaut.get(2).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(2).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/tangankiri.obj"
        ));

        objectAstronaut.get(3).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(3).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/tangankanan.obj"
        ));

        objectAstronaut.get(4).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(4).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/kakikiri2.obj"
        ));

        objectAstronaut.get(5).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(5).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                "resources/model/astronaut/kakikanan1.obj"
        ));

        objectAstronaut.get(6).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(6).translateObject(-2.185f, 0.0f, -0.0f);

        objectAstronaut.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.210f,0.151f,0.0840f,1.0f),
                "resources/model/astronaut/tas.obj"
        ));

        objectAstronaut.get(7).scaleObject(0.2f,0.2f,0.2f);
        objectAstronaut.get(7).translateObject(-2.185f, 0.0f, -0.0f);

        for (int i = 0; i < objectAstronaut.size(); i++){
            objectAstronaut.get(i).scaleObject(0.8f, 0.8f, 0.8f);
            objectAstronaut.get(i).rotateObject(-0.5f, 0f, 1f, 0.0f);
            objectAstronaut.get(i).translateObject(-0.5f, 0.0f, 1.2f);
        }
//        objectAstronaut.add(new Model(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f,1f,1f,1.0f),
//                "resources/model/astronaut/badan.obj"
//        ));
//
//        objectAstronaut.get(1).scaleObject(0.05f,0.05f,0.05f);
//        objectAstronaut.get(1).translateObject(-2.2f, 0.0f, -0.0f);

        for(int i = 0; i < objectToko.size(); i++){
            objectToko.get(i).translateObject(0.0f, 0.0f, -0.6f);
        }
        for(int i = 0; i < objectSampah.size(); i++){
            objectSampah.get(i).translateObject(0.0f, 0.0f, -0.6f);
        }

        hitbox();
    }

    public void testLight(){
        posisiLight.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f), new Vector3f(0,0,0), 0.05f, 0.05f, 0.05f
        ));
        posisiLight.get(0).translateObject(1.16f, 0.75f, 0.55f);
        posisiLight.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f), new Vector3f(0,0,0), 0.05f, 0.05f, 0.05f
        ));
        posisiLight.get(1).translateObject(1.46f, 0.73f, 0.55f);
        posisiLight.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f), new Vector3f(0,0,0), 0.05f, 0.05f, 0.05f
        ));
        posisiLight.get(2).translateObject(1.8f, 0.71f, 0.55f);
        posisiLight.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f), new Vector3f(0,0,0), 0.05f, 0.05f, 0.05f
        ));
        posisiLight.get(3).translateObject(2.13f, 0.72f, 0.55f);
        posisiLight.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,0f,1.0f), new Vector3f(0,0,0), 0.05f, 0.05f, 0.05f
        ));
        posisiLight.get(4).translateObject(2.43f, 0.75f, 0.55f);

    }

    public void hitbox(){
        // kotak toko
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-0.35f, 0.5f, -0.6f), 0.2f, 1f, 1.4f
        ));

        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.55f, 0.5f, -0.6f), 0.2f, 1f, 1.4f
        ));

        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.1f, 0.5f, -0.6f), 1.1f, 1f, 1f
        ));

        // lentera
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-0.575f, 0.625f, 0.2f), 0.15f, 0.25f, 0.15f
        ));

        // kursi toko 1
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-0.11f, 0.0f, -0.025f), 0.125f, 0.25f, 0.125f
        ));

        // kursi toko 2
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.155f, -0.2f, -0.025f), 0.125f, 0.25f, 0.125f
        ));

        // kotak sampah kiri
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-0.525f, 0.0f, -0.05f), 0.15f, 0.25f, 0.3f
        ));

        // flag banner
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-0.75f, -0.3f, -0.125f), 0.2f, 0.75f, 0.05f
        ));

        // meja 1
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-1.3f, 0.1f, 0.8f), 0.65f, 0.4f, 0.5f
        ));

        // meja 2
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0f, 0.1f, 1.1f), 0.65f, 0.4f, 0.5f
        ));

        // meja 3
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(1.2f, 0.1f, 1.1f), 0.65f, 0.4f, 0.5f
        ));

        // light pole left
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(1.1f, 0.4f, 0.45f), 0.3f, 1.1f, 0.3f
        ));

        // light pole right
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(2.5f, 0.4f, 0.45f), 0.3f, 1.1f, 0.3f
        ));

        // small trash can
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.7f, -0.1f, 0.105f), 0.1f, 0.2f, 0.1f
        ));

        // box right side
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.8f, 0.0f, -0.26f), 0.3f, 0.2f, 0.275f
        ));

        // big trash can
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(0.8f, 0.125f, -0.855f), 0.3f, 0.6f, 0.7f
        ));

        // fountain
        hitboxEnvironment.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f), new Vector3f(-1.65f, 0.125f, -0.95f), 1f, 0.6f, 1f
        ));

        hitboxPerson.add(new Square(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,1f,1f,1.0f), new Vector3f(0,0,0), 0.25f, 0.4f, 0.25f
        ));
        hitboxPerson.get(0).translateObject(-2.075f, 0.175f, 0.32f);
    }

    public ArrayList<Boolean> checkCollision(){
        ArrayList <Boolean> collision = new ArrayList<>();
        for (int i=0; i<7; i++){
            collision.add(false);
        }
        int ia=0;
        for (Object object: hitboxEnvironment) {

            ArrayList <Boolean> col = object.checkCollision(this.hitboxPerson.get(0).getCenterPoint(), this.hitboxPerson.get(0).getSize());
            if (ia ==16) {System.out.println(col);}
            if (col.get(0)) {
                for (int i = 0; i < col.size(); i++) {
                    if (col.get(i)) {
                        collision.set(i, true);
                    }
                }
            }
            ia++;
        }
        return collision;
    }

    public void input() {
        Vector3f temp = objectObj.get(0).getCenterPoint();
        angle = angle % (float) Math.toRadians(360);

        if (window.isKeyPressed(GLFW_KEY_L) && !delay2){
            malam = !malam;
            for (Object object: objectObj){
                object.setScene(malam);
                for(Object objectChild: object.getChildObject()){
                    objectChild.setScene(malam);
                }
            }

            for (Object object: objectGround){
                object.setScene(malam);
                for(Object objectChild: object.getChildObject()){
                    objectChild.setScene(malam);
                }
            }

            for (Object object: objectMejaKursi){
                object.setScene(malam);
                for(Object objectChild: object.getChildObject()){
                    objectChild.setScene(malam);
                }
            }

            for (Object object: objectAstronaut){
                object.setScene(malam);
                for(Object objectChild: object.getChildObject()){
                    objectChild.setScene(malam);
                }
            }

            delay2 = true;
        }

        if (window.isKeyPressed(GLFW_KEY_F) && !delay){
            modeToggle++;
            modeToggle = modeToggle % 3;
            System.out.println("Model Toggle: " + modeToggle);
            delay = true;
        }

        if (window.isKeyPressed(GLFW_KEY_G)){
            start = true;
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            objectObj.get(0).translateObject(0.0f, move, 0.0f);
            Vector3f posObj = objectObj.get(0).model.transformPosition(new Vector3f());

            ArrayList<Vector3f> verticesK = new ArrayList<>(List.of());

            for(float i = 0;i<360;i+=1) {
                float x = (float) (posObj.x + 2f * Math.sin(Math.toRadians(i)));
                float z = (float) (posObj.z + 2f * Math.cos(Math.toRadians(i)));
                float y =(float) posObj.y+0.3f;
                verticesK.add(new Vector3f(x, y, z));
            }
            camera.setPosition(verticesK.get(0).x, verticesK.get(0).y, verticesK.get(0).z);

            if (rotation >= 360.0) {
                rotation = 0.0f;
            }
            camera.setPosition(verticesK.get((int)rotation).x,verticesK.get((int)rotation).y, verticesK.get((int)rotation).z);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            objectObj.get(0).translateObject(0.0f, -move, 0.0f);
            Vector3f posObj = objectObj.get(0).model.transformPosition(new Vector3f());

            ArrayList<Vector3f> verticesK = new ArrayList<>(List.of());

            for(float i = 0;i<360;i+=1) {
                float x = (float) (posObj.x + 2f * Math.sin(Math.toRadians(i)));
                float z = (float) (posObj.z + 2f * Math.cos(Math.toRadians(i)));
                float y =(float) posObj.y+0.3f;
                verticesK.add(new Vector3f(x, y, z));
            }
            camera.setPosition(verticesK.get(0).x, verticesK.get(0).y, verticesK.get(0).z);

            if (rotation >= 360.0) {
                rotation = 0.0f;
            }
            camera.setPosition(verticesK.get((int)rotation).x,verticesK.get((int)rotation).y, verticesK.get((int)rotation).z);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            objectObj.get(0).translateObject(-move, 0.0f, 0.0f);
            Vector3f posObj = objectObj.get(0).model.transformPosition(new Vector3f());

            ArrayList<Vector3f> verticesK = new ArrayList<>(List.of());

            for(float i = 0;i<360;i+=1) {
                float x = (float) (posObj.x + 2f * Math.sin(Math.toRadians(i)));
                float z = (float) (posObj.z + 2f * Math.cos(Math.toRadians(i)));
                float y =(float) posObj.y+0.3f;
                verticesK.add(new Vector3f(x, y, z));
            }
            camera.setPosition(verticesK.get(0).x, verticesK.get(0).y, verticesK.get(0).z);

            if (rotation >= 360.0) {
                rotation = 0.0f;
            }
            camera.setPosition(verticesK.get((int)rotation).x,verticesK.get((int)rotation).y, verticesK.get((int)rotation).z);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            objectObj.get(0).translateObject(move, 0.0f, 0.0f);
            Vector3f posObj = objectObj.get(0).model.transformPosition(new Vector3f());
            float posX = camera.getPosition().x;
            float posY = camera.getPosition().y;
            float posZ = camera.getPosition().z;

            ArrayList<Vector3f> verticesK = new ArrayList<>(List.of());

            for(float i = 0;i<360;i+=1) {
                float x = (float) (posObj.x + 2f * Math.sin(Math.toRadians(i)));
                float z = (float) (posObj.z + 2f * Math.cos(Math.toRadians(i)));
                float y =(float) posObj.y+0.3f;
                verticesK.add(new Vector3f(x, y, z));
            }
            camera.setPosition(verticesK.get(0).x, verticesK.get(0).y, verticesK.get(0).z);

            if (rotation >= 360.0) {
                rotation = 0.0f;
            }
            camera.setPosition(verticesK.get((int)rotation).x,verticesK.get((int)rotation).y, verticesK.get((int)rotation).z);
        }

        if (window.isKeyPressed(GLFW_KEY_Q)){
            camera.moveForward(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_E)){
            camera.moveBackwards(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_R)){
            camera.moveLeft(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_T)){
            camera.moveRight(0.05f);
        }


        if (window.isKeyPressed(GLFW_KEY_UP)) {
            if (modeToggle == 2) {
                camera.addRotation(-0.01f, 0f);
            } else {
                camera.addRotation(-0.01f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            if (modeToggle == 2) {
                camera.addRotation(0.01f, 0f);
            } else {
                camera.addRotation(0.01f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            if (modeToggle == 2) {
                camera.addRotation(0f, -0.01f);
            } else {
                camera.addRotation(0f, -0.01f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            if (modeToggle == 2) {
                camera.addRotation(0f, 0.01f);
            } else {
                camera.addRotation(0f, 0.01f);
            }
        }

        if (window.getMouseInput().isRightButtonPressed()) {
            Vector2f displVec = window.getMouseInput().getDisplVec();
            if (modeToggle == 2) {
                camera.addRotation((float) Math.toRadians(displVec.x * 0.1f), (float) Math.toRadians(displVec.y * 0.1f));
            } else {
                camera.addRotation((float) Math.toRadians(displVec.x * 0.1f), (float) Math.toRadians(displVec.y * 0.1f));
            }
        }

        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.1f));
            window.getMouseInput().setScroll(new Vector2f());
        }

        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            if (modeToggle == 2) {
                camera.moveUp(move);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            if (modeToggle == 2) {
                camera.moveDown(move);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_1) && !delay3) { // look back

            camera.setPosition(-temp.get(0), -temp.get(1), -temp.get(2));
            camera.addRotation(0, (float) Math.toRadians(180f));
            camera.setPosition(temp.get(0), temp.get(1), temp.get(2));
            camera.moveBackwards(distance);

            delay3 = true;
        }

        ArrayList<Boolean> collision = checkCollision();

        for (boolean col: collision){
            //System.out.println(collision);
        }

        if (window.isKeyPressed(GLFW_KEY_H)){
            if (!collision.get(6)) {
                hitboxPerson.get(0).translateObject(0f, 0f, -0.005f);
                for (Object object: objectAstronaut){
                    object.translateObject(0f, 0f, -0.005f);
                }
            }
        }
        else if (window.isKeyPressed(GLFW_KEY_B)){
            if (!collision.get(2)) {
                hitboxPerson.get(0).translateObject(-0.005f, 0f, 0f);
                for (Object object: objectAstronaut){
                    object.translateObject(-0.005f, 0f, 0f);
                }
            }
        }

        if (window.isKeyPressed(GLFW_KEY_N)){
            if (!collision.get(5)) {
                hitboxPerson.get(0).translateObject(0f, 0f ,0.005f);
                for (Object object: objectAstronaut){
                    object.translateObject(0f, 0f, 0.005f);
                }
            }
        }
        else if (window.isKeyPressed(GLFW_KEY_M)){
            if (!collision.get(1)) {
                hitboxPerson.get(0).translateObject(0.005f, 0f, 0f);
                for (Object object: objectAstronaut){
                    object.translateObject(0.005f, 0f, 0f);
                }
            }
        }
        
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            if(malam){
                glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            } else {
                glClearColor(0.0f, 0.64453125f, 1.0f, 1.0f);
            }

            GL.createCapabilities();

            input();

            if (delay){
                delayCounter++;
            }

            if (delayCounter > 30){
                delayCounter = 0;
                delay = false;
            }

            if (delay2){
                delayCounter2++;
            }

            if (delayCounter2 > 30){
                delayCounter2 = 0;
                delay2 = false;
            }

            if (delay3){
                delayCounter3++;
            }

            if (delayCounter3 > 30){
                delayCounter3 = 0;
                delay3 = false;
            }

            if (start){
                if (carPos < 900) {
                    objectObj.get(1).translateObject(0f, 0f, -0.007f);
                    carPos++;
                }

                if (900 <= carPos && carPos < 990) {
                    Vector3f temp = objectObj.get(1).getCenterPoint();
                    objectObj.get(1).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(1).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(1).translateObject(temp.get(0), temp.get(1), temp.get(2));
                }

                if (900 <= carPos && carPos < 1250) {
                    objectObj.get(1).translateObject(0.007f, 0f, 0f);
                    carPos++;
                }

                if (1250 <= carPos && carPos < 1340) {
                    Vector3f temp = objectObj.get(1).getCenterPoint();
                    objectObj.get(1).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(1).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(1).translateObject(temp.get(0), temp.get(1), temp.get(2));
                }

                if (1250 <= carPos && carPos < 2330) {
                    objectObj.get(1).translateObject(0f, 0f, 0.007f);
                    carPos++;
                }

                if (2330 <= carPos && carPos < 2420) {
                    Vector3f temp = objectObj.get(1).getCenterPoint();
                    objectObj.get(1).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(1).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(1).translateObject(temp.get(0), temp.get(1), temp.get(2));
                }

                if (2330 <= carPos && carPos < 2680) {
                    objectObj.get(1).translateObject(-0.007f, 0f, 0f);
                    carPos++;
                }

                if (2680 <= carPos && carPos < 2770) {
                    Vector3f temp = objectObj.get(1).getCenterPoint();
                    objectObj.get(1).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(1).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(1).translateObject(temp.get(0), temp.get(1), temp.get(2));
                }

                if (2680 <= carPos && carPos < 2860) {
                    objectObj.get(1).translateObject(0f, 0f, -0.007f);
                    carPos++;
                }

                if (carPos == 2860) {
                    carPos = 0;
                }
            }

            if (modeToggle > 0) {
                if (modeToggle == 1) {
                    Vector3f temp = objectObj.get(0).getCenterPoint();
                    camera.setPosition(temp.get(0), temp.get(1), temp.get(2));
                    camera.moveBackwards(distance);
                }

                if (carPos2 < 660) {
                    objectObj.get(0).translateObject(0f, 0f, -0.01f);
                    carPos2++;
                }

                if (660 <= carPos2 && carPos2 < 750) {
                    Vector3f temp = objectObj.get(0).getCenterPoint();
                    objectObj.get(0).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(0).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(0).translateObject(temp.get(0), temp.get(1), temp.get(2));
                    angle = angle - (float) Math.toRadians(1f);
                }

                if (660 <= carPos2 && carPos2 < 1000) {
                    objectObj.get(0).translateObject(0.01f, 0f, 0f);
                    carPos2++;
                }

                if (1000 <= carPos2 && carPos2 < 1090) {
                    Vector3f temp = objectObj.get(0).getCenterPoint();
                    objectObj.get(0).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(0).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(0).translateObject(temp.get(0), temp.get(1), temp.get(2));
                    angle = angle - (float) Math.toRadians(1f);
                }

                if (1000 <= carPos2 && carPos2 < 1820) {
                    objectObj.get(0).translateObject(0f, 0f, 0.01f);
                    carPos2++;
                }

                if (1820 <= carPos2 && carPos2 < 1910) {
                    Vector3f temp = objectObj.get(0).getCenterPoint();
                    objectObj.get(0).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(0).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(0).translateObject(temp.get(0), temp.get(1), temp.get(2));
                    angle = angle - (float) Math.toRadians(1f);
                }

                if (1820 <= carPos2 && carPos2 < 2160) {
                    objectObj.get(0).translateObject(-0.01f, 0f, 0f);
                    carPos2++;
                }

                if (2160 <= carPos2 && carPos2 < 2250) {
                    Vector3f temp = objectObj.get(0).getCenterPoint();
                    objectObj.get(0).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                    objectObj.get(0).rotateObject(-(float) Math.toRadians(1f), 0f, 1f, 0f);
                    objectObj.get(0).translateObject(temp.get(0), temp.get(1), temp.get(2));
                    angle = angle - (float) Math.toRadians(1f);
                }

                if (2160 <= carPos2 && carPos2 < 2320) {
                    objectObj.get(0).translateObject(0f, 0f, -0.01f);
                    carPos2++;
                }

                if (carPos2 == 2320) {
                    carPos2 = 0;
                }
            }

            // code here
            for (Object object: objectObj) {
                object.draw(camera, projection);
            }

            for (Object object: objectGround) {
                object.draw_ground(camera, projection);
            }

            for (Object object: objectAsteroid) {
                object.draw(camera, projection);
            }

            for (Object object: objectToko) {
                object.draw(camera, projection);
            }

            for (Object object: objectdekorasiToko) {
                object.draw_mejakursi(camera, projection);
            }


            for (Object object: objectMejaKursi) {
                object.draw(camera, projection);
            }

            for (Object object: objectSampah) {
                object.draw(camera, projection);
            }

            for (Object object: objectSpaceship) {
                object.draw_mejakursi(camera, projection);
            }

            for (Object object: objectAstronaut) {
                object.draw_mejakursi(camera, projection);
            }

            for (Object object: objectFountain) {
                object.draw(camera, projection);
            }

            for (Object object: posisiLight){
                object.drawLine(camera, projection);
            }

            for (Object object: hitboxEnvironment){
                object.drawLine(camera, projection);
            }

            for (Object object: hitboxPerson){
                object.drawLine(camera, projection);
            }



            // Restore state
            glDisableVertexAttribArray(0);
            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
