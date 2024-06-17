package Themes;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ThemesControl {

    private boolean isDarkTheme = false;

    public ThemesControl() {
    }

    // Method to set the light theme

    public void setLightTheme() {
//        UIManager.put("control", new Color(240, 240, 240));
//        UIManager.put("info", new Color(242, 242, 189));
//        UIManager.put("nimbusBase", new Color(51, 98, 140));
//        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
//        UIManager.put("nimbusDisabledText", new Color(142, 143, 145));
//        UIManager.put("nimbusFocus", new Color(115, 164, 209));
//        UIManager.put("nimbusGreen", new Color(176, 179, 50));
//        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
//        UIManager.put("nimbusLightBackground", new Color(255, 255, 255));
//        UIManager.put("nimbusOrange", new Color(191, 98, 4));
//        UIManager.put("nimbusRed", new Color(169, 46, 34));
//        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
//        UIManager.put("nimbusSelectionBackground", new Color(57, 105, 138));
//        UIManager.put("text", new Color(0, 0, 0));
        FlatLightFlatIJTheme.setup();
    }

    // Method to set the dark theme
    public void setDarkTheme() {
        FlatMaterialDarkerContrastIJTheme.setup();
//        UIManager.put("control", new Color(60, 63, 65));
//        UIManager.put("info", new Color(60, 63, 65));
//        UIManager.put("nimbusBase", new Color(18, 30, 49));
//        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
//        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
//        UIManager.put("nimbusFocus", new Color(115, 164, 209));
//        UIManager.put("nimbusGreen", new Color(176, 179, 50));
//        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
//        UIManager.put("nimbusLightBackground", new Color(43, 43, 43));
//        UIManager.put("nimbusOrange", new Color(191, 98, 4));
//        UIManager.put("nimbusRed", new Color(169, 46, 34));
//        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
//        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
//        UIManager.put("text", new Color(230, 230, 230));
    }

    public void switchTheme(JFrame frame) {
        if (isDarkTheme) {
            setLightTheme();
        } else {
            setDarkTheme();
        }
        SwingUtilities.updateComponentTreeUI(frame);
        isDarkTheme = !isDarkTheme;
    }

}
