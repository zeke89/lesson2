package com.zeke.lesson2.utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverFactory {

    public enum Browsers {
        FIREFOX {
            public WebDriver create(MutableCapabilities options) {
                FirefoxOptions option = new FirefoxOptions();
                option.merge(options);
                return new FirefoxDriver(option);
            }
        },
        CHROME {
            public WebDriver create(MutableCapabilities options) {
                ChromeOptions option = new ChromeOptions();
                option.merge(options);
                return new ChromeDriver(option);
            }
        },
        SAFARI {
            public WebDriver create(MutableCapabilities options) {
                SafariOptions option = new SafariOptions();
                option.merge(options);
                return new SafariDriver(option);
            }
        },
        IE {
            public WebDriver create(MutableCapabilities options) {
                InternetExplorerOptions option = new InternetExplorerOptions();
                option.merge(options);
                return new InternetExplorerDriver(option);
            }
        };

        public WebDriver create(MutableCapabilities options) {
            return null;
        }
    }

    public static WebDriver createNewDriver(String webDriverName) {
        MutableCapabilities options = new MutableCapabilities();
        WebDriver driver = Browsers.valueOf(webDriverName.toUpperCase()).create(options);
        return driver;
    }

    public static WebDriver createNewDriver(String webDriverName, MutableCapabilities options) {
        WebDriver driver = Browsers.valueOf(webDriverName.toUpperCase()).create(options);
        return driver;
    }
}