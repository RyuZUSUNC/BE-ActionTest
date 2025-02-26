package ffffffff0x.beryenigma.Kit.Utils;

import com.jfoenix.controls.*;
import ffffffff0x.beryenigma.Init.ConfigListInit;
import ffffffff0x.beryenigma.Init.Init;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class ViewUtils {
    /**
     * 返回文件获取窗口
     * @return 返回文件获取窗口
     */
    public static File getFile(){
        Stage primaryStage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Init.languageResourceBundle.getString("File"));
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setInitialDirectory(fsv.getHomeDirectory());
        return fileChooser.showOpenDialog(primaryStage);
    }

    /**
     * 带有单个文件名后缀过滤器的文件获取窗口
     * @param extFilter 后缀过滤器
     * @return 带有单个文件名后缀过滤器的文件获取窗口
     */
    public static File getFile(FileChooser.ExtensionFilter extFilter){
        Stage primaryStage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle(Init.languageResourceBundle.getString("File"));
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setInitialDirectory(fsv.getHomeDirectory());
        return fileChooser.showOpenDialog(primaryStage);
    }


    /**
     * 带有文件名后缀过滤器的文件获取窗口
     * @param extFilter 后缀过滤器
     * @return 带有文件名后缀过滤器的文件获取窗口
     */
    public static File getFile(FileChooser.ExtensionFilter[] extFilter){
        Stage primaryStage = null;
        FileChooser fileChooser = new FileChooser();
        for (FileChooser.ExtensionFilter filter:extFilter) {
            fileChooser.getExtensionFilters().add(filter);
        }
        fileChooser.setTitle(Init.languageResourceBundle.getString("File"));
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setInitialDirectory(fsv.getHomeDirectory());
        return fileChooser.showOpenDialog(primaryStage);
    }

    /**
     * 保存文件时的文件选择器
     * @return 保存文件时的文件选择器
     */
    public static File fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.gif"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setInitialDirectory(fsv.getHomeDirectory());
        fileChooser.setInitialFileName("Result");
        return fileChooser.showSaveDialog(new Stage());
    }

    /**
     * 保存文件时的文件目录选择器
     * @return 保存文件时的文件目录选择器
     */
    public static File directoryChooser(){
        DirectoryChooser directorychooser = new DirectoryChooser();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        directorychooser.setInitialDirectory(fsv.getHomeDirectory());
        return directorychooser.showDialog(new Stage());
    }

    /**
     * 保存文件时的文件选择器
     * @return 保存文件时的文件选择器
     */
    public static File fileChooser(String filename){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setInitialDirectory(fsv.getHomeDirectory());
        fileChooser.setInitialFileName(filename);
        return fileChooser.showSaveDialog(new Stage());
    }

    /**
     * alert弹窗，用于报错，提示等功能
     * @param stage 目标stage
     * @param heading 标题
     * @param body 正文
     */
    public static void alertPane(Stage stage, String heading, String body){
        JFXAlert alert = new JFXAlert(stage);
        alert.initModality(Modality.NONE);
        alert.setOverlayClose(false);
        JFXDialogLayout layout = new JFXDialogLayout();
        Label HeadingLable = new Label(heading);
        HeadingLable.setStyle("-fx-font-size: 20.0px;");
        layout.setHeading(HeadingLable);
        layout.setBody(new Label(body));
        JFXButton closeButton = new JFXButton(Init.languageResourceBundle.getString("Accept"));
        closeButton.setPrefSize(120,60);
        closeButton.setStyle("    -fx-background-color: WHITE;\n" +
                "    -fx-font-size: 14.0px;");
        closeButton.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(closeButton);
        alert.setContent(layout);
        alert.show();
    }

    /**
     * 清空文本域控件的文字并显示过滤器报错
     * @param jta 目标文本域node
     */
    public static void textAreaValidate(JFXTextArea jta){
        jta.setText("");
        jta.validate();
    }

    /**
     * 重置文本域控件的过滤器报错
     * @param jta 目标文本域node
     */
    public static void textAreaValidateReset(JFXTextArea jta){
        jta.resetValidation();
    }

    /**
     * 用于设置在Anchor中node对象的Anchor
     * @param node 要设置Anchor的目标node
     * @param TopAnchor 上
     * @param LeftAnchor 左
     * @param RightAnchor 右
     * @param BottomAnchor 下
     */
    public static void setAnchor(Node node, Double TopAnchor, Double LeftAnchor, Double RightAnchor, Double BottomAnchor){
        AnchorPane.setTopAnchor(node,TopAnchor);
        AnchorPane.setRightAnchor(node,RightAnchor);
        AnchorPane.setLeftAnchor(node,LeftAnchor);
        AnchorPane.setBottomAnchor(node,BottomAnchor);
    }

    /**
     * 将swing的BufferedImage对象转换为JAVAFX的Image对象
     * @param image BufferedImage对象
     * @return JAVAFX的Image对象
     */
    public static javafx.scene.image.Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }

    /**
     * 用于获取文本分隔符
     * @param jtaSplit 传入的JFXTextField对象
     * @return String
     */
    public static String getSplit(JFXTextField jtaSplit) {
        return Util.splitStringReplace(jtaSplit.getText());
    }

    /**
     * 获取一个圆形假进度条
     * @return JFXSpinner
     */
    public static JFXSpinner getRunningSpinner() {
        JFXSpinner jfxSpinner = new JFXSpinner();
        jfxSpinner.setPrefSize(36.0,36.0);
        jfxSpinner.setVisible(false);
        setAnchor(jfxSpinner,null,null,50.0,47.0);
        return jfxSpinner;
    }

    /**
     * 获取图片
     * @return Image
     */
    public static Image getImage(String imgName) {
        imgName = imgName.replace("{$}", Init.getConfig(ConfigListInit.AppStyle));
        return new Image(Objects.requireNonNull(ViewUtils.class.getResourceAsStream(imgName)));
    }
}
