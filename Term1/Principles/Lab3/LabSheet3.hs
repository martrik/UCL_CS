mult :: Num a => [a] -> a
mult xs = foldr (*) 1 xs

posList :: [Int] -> [Int]
posList xs = filter (\n -> n>0) xs

trueList :: [Bool] -> Bool
trueList bs = foldr (&&) True bs

evenList :: Integral a => [a] -> Bool
evenList xs = trueList $ map (\n -> even n) xs

maxList :: Ord a => [a] -> a
maxList xs = foldr (\x y -> if x>y then x else y) (head xs) xs

inRange :: Int -> Int -> [Int] -> [Int]
inRange l u xs = filter (\x -> x>=l && x<= u) xs

countPositives :: Num a => Ord a => [a] -> Int
countPositives xs = sum (map (\x -> 1) (filter (\x -> x>0) xs))

myLength :: [a] -> Int
myLength xs = foldr (+) 0 (map (\x -> 1) xs)

myMap :: (a -> b) -> [a] -> [b]
myMap f (x:xs) = foldr (\y ys -> (f y):ys) [] xs

myLength' :: [a] -> Int
myLength' xs = foldr (\_ n -> 1 + n) 0 xs