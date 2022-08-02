def solution(board, moves):
    answer = 0
    gameboard = []
    for i in moves:
        for j in range(len(board)):
            if board[j][i-1] == 0:
                pass
            else:
                gameboard.append(board[j][i-1])
                board[j][i-1] = 0
                
                if len(gameboard) > 1:
                    if gameboard[-1] == gameboard[-2]:
                        gameboard.pop(-1)
                        gameboard.pop(-1)
                        answer +=2
                break
    
        
    print(gameboard)
    print(board)
    print(answer)
    return answer