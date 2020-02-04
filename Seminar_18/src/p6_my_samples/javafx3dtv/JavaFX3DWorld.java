package p6_my_samples.javafx3dtv;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.VertexFormat;

class JavaFX3DWorld {

    private final Group root = new Group();
    private final Xform world = new Xform();

//    final Xform axisGroup = new Xform();
    private final Xform contentGroup = new Xform();

    private final PerspectiveCamera camera = new PerspectiveCamera(true);
    private final Xform cameraXform = new Xform();
    private final Xform cameraXform2 = new Xform();
    private final Xform cameraXform3 = new Xform();

    private static final double CAMERA_INITIAL_DISTANCE = -450;
    private static final double CAMERA_INITIAL_X_ANGLE = 5.0; //70.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 190.0; //320.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;

//    private static final double AXIS_LENGTH = 250.0;

    private static final double CONTROL_MULTIPLIER = 0.1;
    private static final double SHIFT_MULTIPLIER = 10.0;
    private static final double MOUSE_SPEED = 0.1;
    private static final double ROTATION_SPEED = 2.0;
    private static final double TRACK_SPEED = 0.3;


    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;
    private double mouseDeltaX;
    private double mouseDeltaY;

    // for texture map:
    private final BooleanProperty diffuseMap = new SimpleBooleanProperty(true);
    private final ObjectProperty<Image> imageProperty;

    JavaFX3DWorld(ObjectProperty<Image> imageProperty){
        this.imageProperty = imageProperty;
    }

    FlowPane get3DWorldPane(){

        FlowPane pane = new FlowPane();

        root.getChildren().add(world);
        buildCamera();
//        buildAxes();
        buildContent();

        SubScene subScene = new SubScene(root, 700, 600);
        subScene.setFill(Color.GREY);
//        handleKeyboard(subScene, world);
//        handleMouse(subScene, world);
        handleKeyboard(subScene);
        handleMouse(subScene);

        subScene.setCamera(camera);
        pane.getChildren().add(subScene);

        return pane;
    }

    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        cameraXform3.setRotateZ(180.0);
        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }

//    private void buildAxes() {
//        final PhongMaterial redMaterial = new PhongMaterial();
//        redMaterial.setDiffuseColor(Color.DARKRED);
//        redMaterial.setSpecularColor(Color.RED);
//        final PhongMaterial greenMaterial = new PhongMaterial();
//        greenMaterial.setDiffuseColor(Color.DARKGREEN);
//        greenMaterial.setSpecularColor(Color.GREEN);
//        final PhongMaterial blueMaterial = new PhongMaterial();
//        blueMaterial.setDiffuseColor(Color.DARKBLUE);
//        blueMaterial.setSpecularColor(Color.BLUE);
//        final Box xAxis = new Box(AXIS_LENGTH, 1, 1);
//        final Box yAxis = new Box(1, AXIS_LENGTH, 1);
//        final Box zAxis = new Box(1, 1, AXIS_LENGTH);
//        xAxis.setMaterial(redMaterial);
//        yAxis.setMaterial(greenMaterial);
//        zAxis.setMaterial(blueMaterial);
//        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
//        axisGroup.setVisible(true);
//        world.getChildren().addAll(axisGroup);
//    }

    private void buildContent(){

        Xform contentXform = new Xform();
        TriangleMesh triangleMesh = new TriangleMesh(VertexFormat.POINT_TEXCOORD);
        triangleMesh.getPoints().addAll(
                -100F,   100F,    0F, //p0
                -100F,  -100F,    0F, //p1
                100F,  -100F,    0F, //p2
                100F,   100F,    0F  //p3
        );
        triangleMesh.getTexCoords().addAll(0,0, 1,0, 0,1, 1,1);
        triangleMesh.getFaces().addAll(0,0,   1,2,    2,3,    0,0,   2,3,    3,1);
        MeshView meshView = new MeshView(triangleMesh);

//        PhongMaterial material = new PhongMaterial(Color.color(0D, 1.D, 0D, 1D), null, null, null, null);

//        Image image = new Image(getClass().getResource("portrait.jpg").toExternalForm());
//        System.out.println("image = " + image);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.WHITE);
//        material.setDiffuseColor(Color.RED);
//        material.diffuseMapProperty().bind(Bindings.when(diffuseMap).then(image).otherwise((Image) null));
        material.diffuseMapProperty().bind(Bindings.when(diffuseMap).then(imageProperty).otherwise((Image) null));
        
//        material.setSpecularColor(Color.TRANSPARENT);
//        material.specularMapProperty().bind(
//                Bindings.when(specularMap).then(sImage).otherwise((Image) null));
//        material.bumpMapProperty().bind(
//                Bindings.when(bumpMap).then(nImage).otherwise((Image) null));
//        material.selfIlluminationMapProperty().bind(
//                Bindings.when(selfIlluminationMap).then(siImage).otherwise((Image) null));

        meshView.setMaterial(material);

        contentXform.getChildren().add(meshView);
        contentGroup.getChildren().add(contentXform);
        world.getChildren().addAll(contentGroup);
    }

    private void handleKeyboard(SubScene scene /*, final Node root */) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case Z:
                    cameraXform2.t.setX(0.0);
                    cameraXform2.t.setY(0.0);
                    camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
                    cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
                    cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
                    break;
//                    case X:
//                        axisGroup.setVisible(!axisGroup.isVisible());
//                        break;
//                    case V:
//                        break;
            }
        });
    }

    private void handleMouse(SubScene scene /*, final Node root */) {
        scene.setOnMousePressed(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseDeltaX = (mousePosX - mouseOldX);
            mouseDeltaY = (mousePosY - mouseOldY);

            double modifier = 1.0;

            if (me.isControlDown()) {
                modifier = CONTROL_MULTIPLIER;
            }
            if (me.isShiftDown()) {
                modifier = SHIFT_MULTIPLIER;
            }
            if (me.isPrimaryButtonDown()) {
                cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED);
                cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED);
            }
            else if (me.isSecondaryButtonDown()) {
                double z = camera.getTranslateZ();
                double newZ = z + mouseDeltaX*MOUSE_SPEED*modifier;
                camera.setTranslateZ(newZ);
            }
            else if (me.isMiddleButtonDown()) {
                cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);
                cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);
            }
        });
        scene.setOnScroll(event -> {
            double delta = event.getDeltaY();
            double currentDistance = camera.getTranslateZ();
            double newCameraDistance = currentDistance + delta;
            camera.setTranslateZ(newCameraDistance);
        });
    }

}
