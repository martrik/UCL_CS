import Data.Char
import Data.List

square :: Int -> Int
square x 
  = x * x

pyth :: Int -> Int -> Int
pyth x y 
  = square x + square y

isTriple :: Int -> Int -> Int -> Bool
isTriple a b c 
  = pyth a b == square c

isTripleAny :: Int -> Int -> Int -> Bool
isTripleAny a b c 
  = isTriple a b c || isTriple a c b || isTriple b c a

halfEvens :: [Int] -> [Int]
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

capitalised :: String -> String
capitalised (x : xs) 
  = toUpper x : [toLower y | y <- xs]

stringLower :: String -> String
stringLower xs 
  = [toLower x | x <- xs]

assessString :: String -> String
assessString xs
  | length xs >= 4 = capitalised xs 
  | otherwise      = stringLower xs

title :: [String] -> [String]
title [] 
  = []
title xxs 
  = [assessString xs | xs <- xxs]
