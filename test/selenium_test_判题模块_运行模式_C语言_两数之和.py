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
    # 打开题库页面
    driver.get('http://localhost:3010/problems')
    time.sleep(2)
    print("页面已打开...")

    # 先登录
    print("开始登录...")
    # <button data-v-67381c39="" class="__button-1jj4wv7-lmmd n-button n-button--default-type n-button--medium-type" tabindex="0" type="button"><!----><!----><span class="n-button__content"> 登录 </span><div aria-hidden="true" class="n-base-wave"></div><div aria-hidden="true" class="n-button__border"></div><div aria-hidden="true" class="n-button__state-border"></div></button>
    # 用户名
    # <div class="n-input-wrapper"><!----><div class="n-input__input"><input type="text" class="n-input__input-el" placeholder="请输入用户名" size="20" value="super"><!----><!----></div><!----></div>
    # 密码
    # <div class="n-input-wrapper"><!----><div class="n-input__input"><input type="password" class="n-input__input-el" placeholder="请输入密码" size="20" value="123456789"><!----><!----></div><!----></div>

    # html 格式
    # <td colspan="1" rowspan="1" data-col-key="title" class="n-data-table-td" style="width: 250px;"><!---->最基础的A+B</td>
    # <td colspan="1" rowspan="1" data-col-key="title" class="n-data-table-td" style="width: 250px;"><!---->多组测试数据的A+B</td>
    # 找到包含"最基础的A+B"的表格单元格并点击
    # problem_xpath = "//td[contains(text(), '最基础的A+B')]"
    # problem_element = driver.find_element(By.XPATH, problem_xpath)
    # problem_element.click()
    # time.sleep(2)

    # 选择编程语言
    # 输入两数之和解题代码
    # 点击运行按钮
    # 获取运行结果
    # 等待几秒获取代码克隆检测结果
    time.sleep(5)
finally:
    driver.quit()  # 关闭浏览器
    # driver.close() # 关闭当前标签页
