package com.helpers;
import org.jwidgets.SimpleRenderer;

//TODO: the sample extracted from: https://www.logicbig.com/tutorials/core-java-tutorial/modules/quick-start.html
public class RendererSupport {
    public void render(Object object) {
        new SimpleRenderer().renderAsString(object);
    }
}
