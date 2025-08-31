import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

from tools.AuthTool import AuthTool
from tools.CaptchaTool import CaptchaTool
from tools.UserTool import UserTool


class BaseSeleniumTest(unittest.TestCase):
    """支持登录选择的Selenium测试基类"""

    # 类级别的配置
    base_url = "http://localhost:29093"  # 设置您的基础URL
    headless = False  # 是否无头模式运行
    implicit_wait = 10  # 隐式等待时间(秒)
    explicit_wait = 20  # 显式等待时间(秒)

    # 认证相关配置
    require_login = True  # 默认需要登录
    username = "superadmin"
    password = "password"
    platform = "CLIENT"

    @classmethod
    def tearDownClass(cls):
        """类级别清理 - 在所有测试结束后执行一次"""
        if hasattr(cls, 'driver'):
            cls.driver.quit()

    def setUp(self):
        """测试级别设置 - 在每个测试开始前执行"""
        super().setUp()

    def tearDown(self):
        """测试级别清理 - 在每个测试结束后执行"""
        super().tearDown()

    def navigate_to(self, url):
        """导航到指定URL"""
        full_url = f"{self.base_url}{url}" if url.startswith("/") else url
        self.driver.get(full_url)

    @classmethod
    def setUpClass(cls):
        """类级别设置 - 在所有测试开始前执行一次"""
        # 初始化浏览器驱动
        chrome_options = webdriver.ChromeOptions()
        if cls.headless:
            chrome_options.add_argument("--headless")  # 无头模式
            # chrome_options.add_argument("--disable-gpu")
            # chrome_options.add_argument("--no-sandbox")
            # chrome_options.add_argument("--disable-dev-shm-usage")

        cls.driver = webdriver.Chrome(
            options=chrome_options,
            service=Service('../chromedriver-win64/chromedriver.exe')
        )
        cls.driver.implicitly_wait(cls.implicit_wait)  # 隐式等待10秒
        cls.wait = WebDriverWait(cls.driver, cls.explicit_wait)

        # 初始化工具类
        cls.auth_tool = AuthTool(base_url=cls.base_url)
        cls.captcha_tool = CaptchaTool(base_url=cls.base_url)
        cls.user_tool = UserTool(base_url=cls.base_url)


