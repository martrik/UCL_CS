import Data.Char

inRange :: Int -> Int -> [Int] -> [Int]
inRange _ _ [] 
  = []
inRange a b (x:xs) 
  = if x >= a && x<=b then x : inRange a b xs else inRange a b xs

countPositives :: [Int] -> Int
countPositives [] 
  = 0
countPositives (x:xs) 
  = if x > 0 then 1 + countPositives xs else countPositives xs

capitalised :: String -> String
capitalised []
  = []
capitalised [x]
  = [toUpper x]
capitalised xs
  = capitalised(init(xs)) ++ [toLower(last(xs))]

title :: [String] -> [String]
title [] 
  = []
title (cs:[]) 
  = [capitalised cs]
title ccs 
  =  title(init(ccs)) ++ if length(last(ccs)) >= 4 then [capitalised(last(ccs))] else [last(ccs)]

--Insertion sort implementation
isort :: Ord a => [a] -> [a]
isort []
  = []
isort [x]
  = [x]
isort (x:xs) 
  = insertInt x (isort xs)

insertInt :: Ord a => a -> [a] -> [a]
insertInt n xs 
  = [x | x <- xs, x <= n] ++ [n] ++ [x | x <- xs, x > n]


-- Merge sort implementation
merge :: Ord a => [a] -> [a] -> [a]
merge xs []
  = xs
merge [] ys
  = ys
merge (x:xs) (y:ys)
  | x <= y    = x : merge xs (y:ys)
  | otherwise = y : merge (x:xs) ys

mergeSort :: Ord a => [a] -> [a]
mergeSort [x]
  = [x]
mergeSort xs
  | even (length xs) = merge firstHalf lastHalf
  | otherwise        = merge firstHalf lastHalf'
  where
    half  = (length xs) `div` 2
    half' = 1 + half
    firstHalf  = mergeSort $ take half  xs
    lastHalf   = mergeSort $ drop half  xs
    lastHalf'  = mergeSort $ drop half' xs


-- Cipher
rotor :: Int -> String -> String
rotor n s
  | n < 0 = "Offset must be bigger than 0"
  | n >= length s = "Offset must be less than the length of the string"
  | otherwise = drop n s ++ take n s

makeKey :: Int -> [(Char, Char)]
makeKey n = zip ['A'..'Z'] (rotor n ['A'..'Z'])

lookUp :: Char -> [(Char, Char)] -> Char
lookUp c [] = c
lookUp c [x]
  | c == fst x = snd x
  | otherwise = c
lookUp c (x:xs)
  | c == fst x = snd x
  | otherwise = lookUp c xs

encipher :: Int -> Char -> Char
encipher n c = lookUp c (makeKey n)

normalise :: String -> String
normalise [] = []
normalise cs = filter (\c -> c `elem` ['A'..'Z'] || c `elem` ['0'..'9']) (map toUpper cs)

encipherStr :: Int -> String -> String
encipherStr n cs = map f (normalise cs)
  where
    f c = lookUp c keye
    key = makeKey n

