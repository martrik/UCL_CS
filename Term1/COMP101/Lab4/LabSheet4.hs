import Test.QuickCheck

halfEvens :: [Int] -> [Int]
halfEvens [] = []
halfEvens xs 
  = map f xs
  where
    f x | even x    = x `div` 2
        | otherwise = x

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b xs 
  = [x | x <- xs,  x >= a, x <= b]

countPositives :: [Int] -> Int
countPositives xs 
  = sum [1 | x <- xs, x > 0]

prop_HalfEvens :: [Int] -> Bool
prop_HalfEvens xs 
  = length (halfEvens xs) == length xs

prop_HalfEvensTwo :: [Int] -> Bool
prop_HalfEvensTwo xs 
  = sum (halfEvens xs) <= sum xs
 
prop_InRange :: Int -> Int -> [Int] -> Bool
prop_InRange a b xs = lex
prop_countPositives :: [Int] -> Bool
prop_countPositives xs 
  = countPositives xs <= length xs

evalRPN :: (Num a, Read a) => String -> a
evalRPN = head . foldl procStack [ ] . words

procStack :: (Num a, Read a) => [a] -> String -> [a]
procStack (x : y : ys) "*" = (y * x) : ys
procStack (x : y : ys) "+" = (y + x) : ys
procStack (x : y : ys) "-" = (y - x) : ys
procStack xs numString = read numString : xs

words' :: String -> [String]
words' []  = []
words' xxs@(x:xs) 
  | x == ' '  = words' xs
  | otherwise = ys : words' rest
                  where (ys, rest) = break (== ' ') xxs

unwords' :: [String] -> String
unwords' [c] = c
unwords' (c:cs) = c ++ " " ++ unwords' cs

prop_Words :: String -> Bool
prop_Words cs = words' cs == words cs 
