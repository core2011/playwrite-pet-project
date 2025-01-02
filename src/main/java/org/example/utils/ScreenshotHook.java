package org.example.utils;

import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
public class ScreenshotHook {

    private static Page page = null;
    private static final String SCREENSHOT_FOLDER = "target/screenshots/";

//    public ScreenshotHook(Page page) {
//        ScreenshotHook.page = page;
//    }

    public static void takeScreenshot(Page page, String scenarioName) {
        try {
            String screenshotPath = SCREENSHOT_FOLDER + scenarioName + "_" + System.currentTimeMillis() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
        } catch (Exception e) {
            log.info("Couldn't take a screenshot.");
        }
    }

    public static void cleanScreenshotsFolder() {
        File folder = new File(ScreenshotHook.SCREENSHOT_FOLDER);

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
}
