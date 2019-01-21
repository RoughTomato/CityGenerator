#!/usr/bin/python
from argparse import ArgumentParser
import os

filename="raw.txt"
outputname="out.txt"
outputType="array"

spliter= ' '
outTypeOpening="\""
outTypeCloseing="\""

def selectType(outType):
    def array():
        outTypeOpening="\"" #lgtm [py/unused-local-variable]
        outTypeCloseing="\"" #lgtm [py/unused-local-variable]
    def sql():
        outTypeOpening="(\'" #lgtm [py/unused-local-variable]
        outTypeClosing="\')" #lgtm [py/unused-local-variable]
    typeDic = {
        "array" : array,
        "sql" : sql,
    }
    return typeDic[outType]()

def fileLines(filename):
    with open(filename) as f:
           return len(list(f))

parser = ArgumentParser()
parser.add_argument("-f", "--file", dest="file",
        help="file containing text to be converted", metavar="FILE")
parser.add_argument("-o", "--out", dest="output",
        help="output file", metavar="OUTPUT")
parser.add_argument("-t", "--type", dest="type",
        help="type of output, acceptable types are:\narray\nsql",
        metavar="TYPE")
parser.add_argument("-s", "--spliter", dest="spliter",
        help="character betwin two strings e.g. \"|\" default space.",
        metavar="SPLITER")

args = parser.parse_args()

if not args.file is None:
    filename = args.file
if not args.output is None:
    outputname = args.output
if not args.type is None:
    outputType = args.type
if not args.spliter is None:
    spliter = args.spliter

if os.path.isfile(filename):

    finalString = ""
    if(spliter == 'newline'):
        with open(filename) as fp:
            for i in range(fileLines(filename)-1):
                finalString += outTypeOpening + fp.readline().strip().lower() + outTypeCloseing + ","
    else:
        file = open(filename,"r")
        holder = file.read()
        array = holder.split(spliter)
        for i in range(len(array)-2):
            finalString += outTypeOpening + array[i].lower() + outTypeCloseing + ","
        finalString += outTypeOpening + array[len(array)-1].lower() + outTypeCloseing + ","

    file = open(outputname, "w")
    file.write(finalString)
else:
    print filename + " doesn't exist or couldn't be accessed."
