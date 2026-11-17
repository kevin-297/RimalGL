package com.rimalgl;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

public class Main {

    private GLFWErrorCallback errorCallback=GLFWErrorCallback.createPrint(System.err);
    private GLFWKeyCallback keyCallback=new GLFWKeyCallback() {
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            if(key==GLFW_KEY_ESCAPE && action==GLFW_PRESS)
                glfwSetWindowShouldClose(window,true);
        }
    };

    public Main(){
        glfwSetErrorCallback(errorCallback);
        if(!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");
        long window=glfwCreateWindow(700,500,"My first OpenGL test", NULL,NULL);
        if(window==NULL)
            throw new IllegalStateException("Failed to create a window");

        glfwSetKeyCallback(window,keyCallback);

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        while(!glfwWindowShouldClose(window)){
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main() {
        new Main();
    }

}
