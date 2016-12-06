#!/bin/bash
#Joseph Mulray

for file in *; do
	if [ ! -d $file ]; then
	echo -n $file ;wc -lw < $file
	fi
done
