def solution(m, n, puddles):
    answer = 0
    dp = [[0] * (m+1) for _ in range(n+1)]
    dp[1][1] = 1
    puddles_list = [[0] * (m+1) for _ in range(n+1)]
    for i,j in puddles:
        puddles_list[j][i] = 1
    #m이 행, n이 열임
    #오른쪽 = [n][m+1] -> [i][j+1]
    #아래 = [n+1][m] -> [i+1][j]
    for i in range(1,n+1):
        for j in range(1,m+1):
            print(i,j)
            if i == 1 and j == 1:
                continue
            #웅덩이라면 continue
            if puddles_list[i][j] == 1:
                continue
            else:
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007
    return dp[n][m]



