from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# 创建浏览器驱动对象
# driver = webdriver.Chrome()
driver = webdriver.Chrome(
    options=webdriver.ChromeOptions(),
    service=webdriver.chrome.service.Service('./chromedriver-win64/chromedriver.exe')
)

try:
    # TODO 测试
    # 打开题库页面
    # 点击两数之和
    # 选择编程语言
    # 输入两数之和解题代码
    # 点击运行按钮
    # 获取运行结果
    # 等待几秒获取代码克隆检测结果
    pass
finally:
    # driver.quit()  # 关闭浏览器
    # driver.close() # 关闭当前标签页
    pass