import requests


class UserTool:
    """用户工具类"""

    def __init__(self, base_url=None, auth_token=None):
        self.base_url = base_url
        self.auth_token = auth_token

    def get_profile_noe(self, profile_endpoint="/core/api/v1/sys/auth/sys/user/profile/noe"):
        """ 获取验证码UUID """
        if not self.base_url:
            raise ValueError("base_url未设置")

        if not self.auth_token:
            raise ValueError("auth_token未设置")

        profile_url = f"{self.base_url}{profile_endpoint}"
        headers = {"Authorization": f"{self.auth_token}"}
        try:
            response = requests.get(profile_url, headers=headers)
            response.raise_for_status()
            return response.json()
        except Exception as e:
            print(f"获取用户信息失败: {e}")
            return None
