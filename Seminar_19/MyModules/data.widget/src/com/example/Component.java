package com.example;

import com.helpers.RendererSupport;
// TODO: the sample extracted from:  https://www.logicbig.com/tutorials/core-java-tutorial/modules/quick-start.html
/*
Attempting to use non-exported classes
   In our example, since the package 'org.jwidgets' has not been exported by 'common.widget' module,
   'data.widget' cannot use classes under that package. Let's try doing that and see what happens...
   To try we need to change the main()-method and use SimpleRenderer instead of RendererSupport.
*/

public class Component {
    public static void main(String[] args) {
        RendererSupport support = new RendererSupport();
        support.render("Test Object");
    }

    //TODO: show that we cannot use class from not exported module (while it is public...)
//    public static void main(String[] args) {
//        SimpleRenderer simpleRenderer = new SimpleRenderer();
//        simpleRenderer.renderAsString("Test Object");
//    }

}
