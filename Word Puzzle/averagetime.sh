#!/bin/bash
echo "Hello! Please input the dictionary file name"
read dictionary
echo "Hello! Please input the grid file name"
read puzzle
#words.txt 250x250.grid.txt

run1=`./a.out $dictionary $puzzle | tail -1`
run2=`./a.out $dictionary $puzzle | tail -1`
run3=`./a.out $dictionary $puzzle | tail -1`
run4=`./a.out $dictionary $puzzle | tail -1`
run5=`./a.out $dictionary $puzzle | tail -1`

runSum=$((run1 + run2))
echo $runSum
runSum=$((runSum + run2))
echo $runSum
runSum=$((runSum + run3))
echo $runSum
runSum=$((runSum + run4))
echo $runSum
runSum=$((runSum + run5))
echo $runSum

average=$((runSum / 5))

echo "In the midst of crippling defeat, here is my number: "$average


