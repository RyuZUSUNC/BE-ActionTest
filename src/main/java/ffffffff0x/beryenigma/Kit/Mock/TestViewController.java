package ffffffff0x.beryenigma.Kit.Mock;

import ffffffff0x.beryenigma.App.View.Viewobj.ViewController;
import ffffffff0x.beryenigma.Init.ViewInit;
import ffffffff0x.beryenigma.Kit.Utils.ConfigUtils;
import ffffffff0x.beryenigma.Kit.Utils.FileUtils;
import ffffffff0x.beryenigma.Kit.Utils.ViewUtils;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.Security;
import java.util.Properties;

public class TestViewController extends ViewController {
    /**
     * 全局界面初始化
     */
    @Override
    protected void initialize() {
        super.initialize();
        setTextareaOnDrag();
        JTA_src.setText(System.getProperty("user.home") + "\n" + System.getProperty("user.dir"));
        StringBuilder a = new StringBuilder();
        for (Provider o : Security.getProviders()) {
            a.append(o.getName()).append("\n");
        }
        JTA_dst.setText(a.toString());
        ViewInit.textAreaErrorInfoGeneral(JTA_src);
        JTA_src.setTextFormatter(new TextFormatter<String>(change -> {
            System.out.println(change.getText());//获取文本
            String value = change.getText();
            if (value.matches("[A-Z]") || value.length() == 0){//限制用户输入，使用正则表达式很重要
                return change;
            }
            ViewUtils.alertPane(new Stage(),"test","test");
            return null;
        }));
    }

    @Override
    public void ONClickEncode() {
        super.ONClickEncode();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/META-INF/maven/org.ffffffff0x/BerylEnigma/pom.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JBT_enCode.setText("test");

    }

    protected void setTextareaOnDrag() {
//        JTA_src.setOnDragOver(dragEvent -> {
//            if (dragEvent.getGestureSource() != JTA_src) {
//                dragEvent.acceptTransferModes(TransferMode.ANY);
//            }
//        });

//        JTA_src.setOnDragDropped(dragEvent -> {
//            Dragboard dragboard = dragEvent.getDragboard();
//            List<File> files = dragboard.getFiles();
//            if(files.size() > 0){
//                JTA_dst.setText(files.get(0).getPath());
//            }
//        });
    }
}
