#!/bin/bash

git init
touch commit_file.txt

for i in $(seq 0 59); do
    DATE=$(date -v+"${i}d" -v"2024-05-01" "+%Y-%m-%d")
    
    for j in 1 2; do
        echo "$DATE commit $j" >> commit_file.txt
        git add commit_file.txt
        GIT_AUTHOR_DATE="${DATE} 10:0${j}:00" GIT_COMMITTER_DATE="${DATE} 10:0${j}:00" git commit -m "DSA practice - $DATE - $j"
    done
done
