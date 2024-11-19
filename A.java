webdriver {
  driver = chrome
  autodownload = true
  capabilities {
    browserName = "chrome"
    acceptInsecureCerts = true
    "goog:chromeOptions" {
      args = [
        "--remote-allow-origins=*",
        "--no-sandbox",
        "--ignore-certificate-errors",
        "--start-maximized",
        "--disable-dev-shm-usage"
      ]
      prefs {
        "profile.default_content_settings.cookies" = 1
        "profile.default_content_settings.local_storage" = 1
      }
    }
  }
  headers {
    "User-Agent" = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    "Accept" = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
    "Accept-Language" = "en-US,en;q=0.5"
    "Accept-Encoding" = "gzip, deflate, br"
    "Connection" = "keep-alive"
    "Upgrade-Insecure-Requests" = "1"
    "Sec-Fetch-Dest" = "document"
    "Sec-Fetch-Mode" = "navigate"
    "Sec-Fetch-Site" = "none"
    "Sec-Fetch-User" = "?1"
    "Cache-Control" = "max-age=0"
  }
  timeouts {
    implicitlywait = 15000
    fluentwait = 15000
  }
  wait.for.timeout = 15000
}

serenity {
  browser.maximized = true
  take.screenshots = AFTER_EACH_STEP
  headless.mode = false
  browser {
    width = 1920
    height = 1080
  }
}