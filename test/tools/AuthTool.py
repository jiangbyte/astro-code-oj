import requests


class AuthTool:
    """认证工具类"""

    def __init__(self, base_url=None):
        self.base_url = base_url

    def do_login(self,
                 username,
                 password,
                 platform='CLIENT',
                 captcha_code=None,
                 uuid=None,
                 auth_endpoint="/core/api/v1/sys/auth/login"
                 ):
        """执行登录操作，返回是否成功"""
        if not self.base_url:
            raise ValueError("base_url未设置")

        login_url = f"{self.base_url}{auth_endpoint}"
        try:
            login_data = {
                "username": username,
                "password": password,
                "captchaCode": captcha_code,
                "uuid": uuid,
                "platform": platform
            }
            login_response = requests.post(login_url, json=login_data)
            if login_response.status_code == 200:
                login_result = login_response.json()
                if login_result["code"] == '200':
                    token = login_result["data"]
                    print("登录成功，获取到token")
                    return token
                else:
                    print(f"登录失败: {login_result['message']}")
                    return None
        except:
            return None

    def do_logout(self, logout_endpoint="/core/api/v1/sys/auth/logout"):
        """执行登出操作，返回是否成功"""
        if not self.base_url:
            raise ValueError("base_url未设置")

        logout_url = f"{self.base_url}{logout_endpoint}"
        try:
            logout_response = requests.post(logout_url)
            if logout_response.status_code == 200:
                logout_result = logout_response.json()
                if logout_result["code"] == '200':
                    print("登出成功")
                    return True
                else:
                    print(f"登出失败: {logout_result['message']}")
                    return False
        except Exception as e:
            print(f"登出失败: {str(e)}")
            return False
