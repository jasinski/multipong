#!/bin/bash
for i in *.java; do
    javac $i
    echo "$i compiled"
done
