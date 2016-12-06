#!/usr/bin/python

import sys


filename = sys.argv[1]
file =open(filename,'r')

for data in file:

	data=data.strip('\n')
	score = data.split(' ')
	name = score[0]
	score.pop(0)
	total=0
        for scores in score:
        	total+=int(scores)
	print name,
    	print total/len(score)

