package vip.creeper.programs.qqlevelchecker;

import java.io.File;

/**
 * Created by July on 2018/2/2.
 */
public class QqLevelCheck {
    private static final String COOKIE = "pgv_pvi=2351035392; pt2gguin=o0884633197; RK=BIPXcCvqOS; ptcz=e8479f886d219fb0b47b757ca1b629939b8980f311da74e13798e34e17f29c14; pgv_pvid=2395417474; o_cookie=884633197; pac_uid=1_884633197; eas_sid=C1T5v1U4F5G9W5B4C7k2T3O008; ts_uid=3293448356; pgv_flv=-; tvfe_boss_uuid=9c3ec1fa1a8c480d; ts_refer=ADTAGCLIENT.QQ.5551_sviplevel.0; uin=o0884633197; skey=@ZGQfNxuJe; ptisp=ctc; pgv_info=ssid=s1423242395; rv2=80260F77736B2B60C34EC099C87B94CAA4DE3DEC0CCDC98887; property20=BAB879200E0D840974638BB77F9B16BCD427BD64FE67E41C9802FD83DA71B36FF7B0F3293700EF2C; ts_last=vip.qq.com/pk/index";
    private static final String PATH = "C:\\Users\\July_\\Desktop\\qqs.txt";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        for (String qq : FileUtil.readFile(new File(PATH)).split(LINE_SEPARATOR)) {
            String response = HttpUtil.sendGet("http://vip.qq.com/pk/index?param=" + qq, COOKIE);

            response = response.substring(2285, response.length());
            System.out.println(response.substring(response.indexOf("iQQLevel\":\""), response.indexOf("\",\"iQQSportStep\":\"")));
        }
    }
}
