import { request as $alova } from '@/utils'

/**
 * 题目排行榜 API请求
 */
export function useUserSetRankingFetch() {
  const pathPrefix = '/core/api/v1/'
  const table = 'pro/set/user'

  return {
    /**
     * 获取总排行榜分页
     * @param data setRankingPageParam
     */
    setUserTotalRankingPage(data: any) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/page/total`, {
        params: {
          ...data,
        },
      })
    },

    /**
     * 获取用户总排行榜
     * @param userId 用户ID
     */
    setUserTotalRankingByUserId(userId: string) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/total/user`, {
        params: {
          userId,
        },
      })
    },

    /**
     * 获取月排行榜分页
     * @param data setRankingPageParam
     */
    setUserMonthlyRankingPage(data: any) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/page/monthly`, {
        params: {
          ...data,
        },
      })
    },

    /**
     * 获取用户月排行榜
     * @param userId 用户ID
     */
    setUserMonthlyRankingByUserId(userId: string) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/monthly/user`, {
        params: {
          userId,
        },
      })
    },

    /**
     * 获取周排行榜分页
     * @param data setRankingPageParam
     */
    setUserWeeklyRankingPage(data: any) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/page/weekly`, {
        params: {
          ...data,
        },
      })
    },

    /**
     * 获取用户周排行榜
     * @param userId 用户ID
     */
    setUserWeeklyRankingByUserId(userId: string) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/weekly/user`, {
        params: {
          userId,
        },
      })
    },

    /**
     * 获取日排行榜分页
     * @param data setRankingPageParam
     */
    setUserDailyRankingPage(data: any) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/page/daily`, {
        params: {
          ...data,
        },
      })
    },

    /**
     * 获取用户日排行榜
     * @param userId 用户ID
     */
    setUserDailyRankingByUserId(userId: string) {
      return $alova.Get<IResult<any>>(`${pathPrefix + table}/ranking/daily/user`, {
        params: {
          userId,
        },
      })
    },
  }
}
