#!/usr/bin/python
from argparse import ArgumentParser
import os

filename="raw.txt"
outputname="out.txt"
outputType="array"

spliter= ' '

def selectType(typeName,string):
    def array(string):
        return "\"" + string + "\","
    def sql(string):
        return "(\'" + string +"\'),"
    def xml(string):
        return "<entry key=\"testName\">" + string + "</entry>\n"
    typeDic = {
        "array" : array(string),
        "sql" : sql(string),
        "xml" : xml(string),
    }
    return typeDic[typeName]

def fileLines(filename):
    with open(filename) as f:
           return len(list(f))

parser = ArgumentParser()
parser.add_argument("-f", "--file", dest="file",
        help="file containing text to be converted", metavar="FILE")
parser.add_argument("-o", "--out", dest="output",
        help="output file", metavar="OUTPUT")
parser.add_argument("-t", "--type", dest="type",
        help="type of output, acceptable types are:\narray\nsql\nxml",
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
                finalString += selectType(outputType,fp.readline().strip().lower())
    else:
        file = open(filename,"r")
        holder = file.read()
        array = holder.split(spliter)
        for i in range(len(array)-2):
            finalString += selectType(outputType,array[i].lower())
        finalString += selectType(outputType,array[len(array)-1].lower())

    file = open(outputname, "w")
    file.write(finalString)
else:
    print(filename + " doesn't exist or couldn't be accessed.")
