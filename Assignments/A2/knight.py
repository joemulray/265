#!/usr/bin/env python
#Joseph Mulray
#Assignment 2

#import sys for arguments and random for random position
import sys
import random

"""check if board is a success or failure"""
def success(board):

	isTrue = True

	#see if any values where knight was not moved to
	for row in board:
		for value in row:
			if (value == 'x'):
				isTrue = False

	return isTrue	

"""creating the board, depending on user input"""
def createBoard():

	#set variables for the arguements passed in
	numRows = int(sys.argv[1])
	numColumns = int(sys.argv[2])

	#create board using user input for row and columns
	board = [['x' for column in range(numColumns)] for row in range(numRows)]

	#set the first position of the night on the board
	board[0][0]= 1

	return board


"""checking for available moves, use recursion to conitinue to replace moves until no 
moves are available, then run suceess"""
def getMoves(board, move=1, rowPos=0, colPos=0):
	
	#increment number of moves, create list of available positions
	move += 1	
	available = []

	#array of all possible moves by a knight piece
	allMoves = [[2,1], [2,-1], [-2,1], [-2,-1], [1,2], [1,-2], [-1,2], [-1,-2]]
		
	#check valid points, not allowing negative array positions to be a valid point
	for point in allMoves:

		validR = rowPos + point[0]
		validC = colPos + point[1]
		
		#validate that the points cannot be negative array[-1] will return last point in array
		if validR >= 0 and validC >= 0:
			try:
				#check if the board position is available
				if (board[validR][validC] == 'x'):
					available.append([validR, validC])	
	
			#catch out of range exception when checking for valid point
			except IndexError:
				pass

	#if there is an available move	
	if available:

		#Generate random number
		num = random.randint(0, len(available) -1)	
		
		#Get random point from available points, set poisiton equal to cuurent move, recall moves
		ranPoint = available[num]
		board[ranPoint[0]][ranPoint[1]] = move	
		getMoves(board, move, ranPoint[0], ranPoint[1])


"""print board and pass or fail value"""
def printBoard(board, isFalse):	

	#print board after succes or failure message
	print ""	
	if isFalse:
		print "SUCCESS:"
	else:
		print "FAIL:"	
	
	for row in board:
		for point in row:
			print point, ' ', 
		print ""
	
	print ""


"""run program"""	
if __name__ == '__main__':
	
	#exit if less than 3 arguments are passed in
	if len(sys.argv) < 4:
		print "Not enough arguments passed. Exiting"
		exit()
	

	#number of attempts, end loop if the board is a success
	isFalse = False	
	numAttempts = int(sys.argv[3])

	while numAttempts != 0 and isFalse == False:
		
		#call functions to create board, get valid moves, and their success value
		board = createBoard()
		getMoves(board)
		isFalse = success(board)
		numAttempts -= 1
	
	#print board function, indent to prove attempts work
	printBoard(board, isFalse)

