fac :: Int -> Int 
fac 0 = 1
fac n = n * fac n-1

fac' :: Int -> Int
fac' 0 = 1
fac' n = foldl (\x n -> n * x) 1 [1..n]

-- fib :: Int -> Int
type Board = [Int]

playNim :: IO ()
playNim = do
    putStrLn "*** Hi! Welcome to Nim. The two players need to take turns in order to get rid of all stars. ***"
    nextTurn [5, 4, 3, 2, 1] 1

nextTurn :: Board -> Int -> IO ()
nextTurn board n 
    | gameFinished board = do 
        putChar '\n'
        putStrLn "*** Congratulations, you won! ***"
    | otherwise = do
        putChar '\n'
        printBoard board
        putChar '\n'
        putStrLn $ "Turn of player " ++ show (n) ++ ". Put the row followed by the number of stars that you want to get rid of."
        rawinput <- getLine
        let input = words rawinput
        if length input == 2
            then do
                let row = read $ input!!0 :: Int
                let amount = read $ input!!1 :: Int
                if  row > 0 && row < 6 && amount > 0
                    then do
                        if board!!(row-1) > 0
                            then nextTurn (updateBoard (row-1) amount board) (nextPlayer n)
                            else do 
                                putStrLn "This row is already empty. Please type again."
                                nextTurn board n
                    else do
                        putStrLn "This row or amount isn't valid."
                        nextTurn board n
            else do
                putStrLn "The values aren't valid. Please type again."
                nextTurn board n

printBoard :: Board -> IO ()
printBoard board = do
    putStrLn $ "1: " ++ replicate (board!!0) '*'
    putStrLn $ "2: " ++ replicate (board!!1) '*'
    putStrLn $ "3: " ++ replicate (board!!2) '*'
    putStrLn $ "4: " ++ replicate (board!!3) '*'
    putStrLn $ "5: " ++ replicate (board!!4) '*'

updateBoard :: Int -> Int -> Board -> Board
updateBoard row amount board = take row board ++ [newAmount] ++ reverse (take (4-row) (reverse board))
    where 
        newAmount 
            | amount > board!!row = 0
            | otherwise = board!!row - amount

nextPlayer :: Int -> Int
nextPlayer n = (n `mod` 2) + 1

gameFinished :: Board -> Bool
gameFinished board = foldl (+) 0 board == 0
