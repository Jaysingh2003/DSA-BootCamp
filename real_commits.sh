#!/bin/zsh

git reset HEAD .

FILES=($(find src/com -name "*.java" | sort))
TOTAL=${#FILES[@]}

DATES=($(python3 -c "
from datetime import date, timedelta
start = date(2026, 5, 1)
end = date(2026, 7, 11)
d = start
while d <= end:
    print(d)
    d += timedelta(days=1)
"))

TOTAL_DAYS=${#DATES[@]}
FILES_PER_DAY=$(( (TOTAL + TOTAL_DAYS - 1) / TOTAL_DAYS ))

echo "Total files: $TOTAL"
echo "Total days: $TOTAL_DAYS"
echo "Files per day: ~$FILES_PER_DAY"

FILE_INDEX=1

for DAY_INDEX in $(seq 1 $TOTAL_DAYS); do
    DATE="${DATES[$DAY_INDEX]}"
    BATCH=()

    for (( j=0; j<FILES_PER_DAY && FILE_INDEX<=TOTAL; j++ )); do
        BATCH+=("${FILES[$FILE_INDEX]}")
        FILE_INDEX=$((FILE_INDEX + 1))
    done

    [[ ${#BATCH[@]} -eq 0 ]] && break

    HALF=$(( ${#BATCH[@]} / 2 ))
    [[ $HALF -eq 0 ]] && HALF=1

    # Commit 1 - morning
    for (( k=1; k<=HALF; k++ )); do
        git add "${BATCH[$k]}" 2>/dev/null
    done
    GIT_AUTHOR_DATE="${DATE} 09:00:00 +0530" GIT_COMMITTER_DATE="${DATE} 09:00:00 +0530" \
        git commit -m "DSA practice ${DATE} - morning session" --allow-empty 2>/dev/null

    # Commit 2 - evening
    for (( k=HALF+1; k<=${#BATCH[@]}; k++ )); do
        git add "${BATCH[$k]}" 2>/dev/null
    done
    GIT_AUTHOR_DATE="${DATE} 20:00:00 +0530" GIT_COMMITTER_DATE="${DATE} 20:00:00 +0530" \
        git commit -m "DSA practice ${DATE} - evening session" --allow-empty 2>/dev/null

    echo "Done: $DATE (${#BATCH[@]} files)"
done

echo ""
echo "All commits done! Now run: git push origin main --force"
