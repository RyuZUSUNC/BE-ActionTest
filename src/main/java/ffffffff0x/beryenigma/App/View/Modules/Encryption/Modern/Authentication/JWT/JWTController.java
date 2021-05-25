package ffffffff0x.beryenigma.App.View.Modules.Encryption.Modern.Authentication.JWT;

import ffffffff0x.beryenigma.Init.ViewInit;
import ffffffff0x.beryenigma.Kit.Utils.ViewUtils;
import ffffffff0x.beryenigma.App.Controller.Encryption.Modern.Authentication.JWT.Authentication_JWT;
import ffffffff0x.beryenigma.App.View.Viewobj.ViewControllerObject;

public class JWTController extends ViewControllerObject {
    /**
     *  JTA_dst1 :Header
     *  JTA_dst2 :Payload
     *  JTA_dst3 :VS
     *  JTA_src :Token
     */

    @Override
    protected void initialize(){
        ViewInit.textAreaErrorInfoGeneral(JTA_src);
    }

    @Override
    public void ONClickEncode() {
        ViewUtils.textAreaValidateReset(JTA_src);
        try {
            JTA_src.setText(Authentication_JWT.encode(JTA_dst1.getText(), JTA_dst2.getText(), JTA_dst3.getText()));
        } catch (Exception e) {
            ViewUtils.textAreaValidate(JTA_src);
        }
    }

    @Override
    public void ONClickDecode() {
        ViewUtils.textAreaValidateReset(JTA_src);
        try {
            String[] result = Authentication_JWT.decode(JTA_src.getText());
            JTA_dst1.setText(result[0]);
            JTA_dst2.setText(result[1]);
            JTA_dst3.setText(result[2]);
        } catch (Exception e) {
            ViewUtils.textAreaValidate(JTA_src);
        }
    }
}
