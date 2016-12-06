#!/usr/bin/python

import sys

if len(sys.argv) > 1:
	filename = sys.argv[1]
else:
	filename = raw_input("Enter a filename: ")
file =open(filename,'r')

dictID = {}

for data in file:
	data=data.strip('\n')
	data = data.split(' ')
	id = data[0]
	data.pop(0)
	
	fullName = ""
	for name in data:
		fullName += name + ' '
	dictID[id] = fullName
sorted(dictID.keys())
for key in dictID:
	print key, 
	print dictID.get(key) 



