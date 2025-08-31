import unittest
import time
import statistics


class EnhancedTestResult(unittest.TestResult):
    """
    增强的测试结果收集器
    继承自unittest.TestResult，添加了额外的功能，记录每个测试的执行时间，以及测试结果摘要
    """

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)  # 调用父类初始化
        self.test_timings = {}  # 存储每个测试的执行时间
        self.test_start_time = None  # 存储当前测试开始时间
        self.execution_count = 0  # 测试执行次数
        self.pass_count = 0  # 测试通过的数量
        self.fail_count = 0  # 测试失败的数量
        self.error_count = 0  # 测试出错的数量

    def startTest(self, test):
        """测试开始时的回调"""
        self.test_start_time = time.time()  # 记录测试开始时间
        self.execution_count += 1  # 测试执行次数加1
        super().startTest(test)  # 调用父类方法保持原有功能

    def addSuccess(self, test):
        """测试成功时的回调"""
        elapsed_time = time.time() - self.test_start_time  # 计算测试执行时间
        self.test_timings[test] = elapsed_time  # 记录测试执行时间
        self.pass_count += 1  # 测试通过数量加1
        super().addSuccess(test)  # 调用父类方法保持原有功能

    def addFailure(self, test, err):
        """测试失败时的回调"""
        elapsed_time = time.time() - self.test_start_time  # 计算测试执行时间
        self.test_timings[test] = elapsed_time  # 记录测试执行时间
        self.fail_count += 1  # 测试失败数量加1
        super().addFailure(test, err)  # 调用父类方法保持原有功能

    def addError(self, test, err):
        """测试出错时的回调"""
        elapsed_time = time.time() - self.test_start_time  # 计算测试执行时间
        self.test_timings[test] = elapsed_time  # 记录测试执行时间
        self.error_count += 1  # 测试出错数量加1
        super().addError(test, err)  # 调用父类方法保持原有功能

    def get_summary(self):
        """测试结果摘要"""
        total_tests = self.pass_count + self.fail_count + self.error_count  # 总测试数
        success_rate = (self.pass_count / total_tests * 100) if total_tests > 0 else 0  # 计算成功率

        # 计算平均执行时间
        if self.test_timings:
            avg_time = statistics.mean(self.test_timings.values())
            max_time = max(self.test_timings.values())
            min_time = min(self.test_timings.values())
        else:
            avg_time = max_time = min_time = 0

        return {
            "execution_count": self.execution_count,
            "pass_count": self.pass_count,
            "fail_count": self.fail_count,
            "error_count": self.error_count,
            "success_rate": round(success_rate, 2),
            "avg_execution_time": round(avg_time, 4),
            "max_execution_time": round(max_time, 4),
            "min_execution_time": round(min_time, 4),
            "total_execution_time": round(sum(self.test_timings.values()), 4)
        }
