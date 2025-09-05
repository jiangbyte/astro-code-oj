import time
import requests
import redis


class CaptchaTool:
    """验证码获取通用工具类"""

    def __init__(self, base_url=None):
        self.redis_client = None
        self.base_url = base_url

    def setup_redis(self, host='localhost', port=6379, db=0, password=None):
        """ 设置Redis连接 """
        try:
            self.redis_client = redis.Redis(
                host=host,
                port=port,
                db=db,
                password=password,
                decode_responses=True  # 自动解码返回的字节数据
            )
            # 测试连接
            self.redis_client.ping()
            return True
        except redis.ConnectionError as e:
            print(f"Redis连接失败: {e}")
            self.redis_client = None
            return False

    def get_captcha_uuid(self, captcha_endpoint="/core/api/v1/sys/auth/captcha"):
        """ 获取验证码UUID """
        if not self.base_url:
            raise ValueError("base_url未设置")

        captcha_url = f"{self.base_url}{captcha_endpoint}"
        try:
            response = requests.get(captcha_url)
            response.raise_for_status()
            captcha_data = response.json()
            return captcha_data['data']["uuid"]
        except requests.RequestException as e:
            raise Exception(f"获取验证码UUID失败: {e}")
        except KeyError as e:
            raise Exception(f"解析验证码响应数据失败: {e}")

    def get_captcha_code(self, uuid_key):
        """ 获取验证码 """
        if not self.redis_client:
            raise ValueError("Redis客户端未初始化")

        captcha_key = f"captcha:{uuid_key}"
        return self.redis_client.get(captcha_key)

    def wait_for_captcha_code(self, uuid_key, timeout=10, interval=0.5):
        """ 等待验证码出现 """
        if not self.redis_client:
            raise ValueError("Redis客户端未初始化")

        captcha_key = f"captcha:{uuid_key}"
        end_time = time.time() + timeout

        while time.time() < end_time:
            captcha_code = self.redis_client.get(captcha_key)
            if captcha_code:
                return captcha_code
            time.sleep(interval)

        return None
