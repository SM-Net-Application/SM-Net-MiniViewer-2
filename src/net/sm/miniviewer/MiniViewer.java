package net.sm.miniviewer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MiniViewer extends Application {

    @FXML private ListView<String> mediaListView;
    @FXML private StackPane previewStackPane;
    @FXML private ImageView imagePreview;
    @FXML private MediaView videoPreview;

    private final String appName = "MiniViewer";
    private final String appVersion = "2.0";
    private final String appAuthor = "SM-Net";

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("MiniViewer.fxml"));

        AnchorPane layout = fxmlLoader.load();

        Scene miniViewerScene = new Scene(layout);

        primaryStage.setScene(miniViewerScene);
        primaryStage.getIcons().add(Resources.ICON);
        primaryStage.setTitle(getAppTitle());
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(400);

        MiniViewer controller = fxmlLoader.getController();
        controller.initData();

        primaryStage.show();
    }

    private String getAppTitle() {
        return this.appAuthor.concat(" ").concat(this.appName).concat(" ").concat(appVersion);
    }

    @FXML public void initialize(){

        this.previewStackPane.setMinSize(0,0);

        this.mediaListView.setMinWidth(250);
        this.mediaListView.setMaxWidth(250);
        this.mediaListView.setMinHeight(250);

        this.imagePreview.fitWidthProperty().bind(this.previewStackPane.widthProperty());
        this.imagePreview.fitHeightProperty().bind(this.previewStackPane.heightProperty());

        this.videoPreview.fitWidthProperty().bind(this.previewStackPane.widthProperty());
        this.videoPreview.fitHeightProperty().bind(this.previewStackPane.heightProperty());
    }

    public void initData(){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
