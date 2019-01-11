from argparse import ArgumentParser
import os

filename="raw.txt"
outputname="out.txt"
outputType="array"

spliter= ' '
outTypeOpening="\""
outTypeCloseing="\""

types = "array\nsql"

def selectType(outType):
    def array():
        outTypeOpening="\""
        outTypeCloseing="\""
    def sql():
        outTypeOpening="(\'"
        outTypeClosing="\')"
    typeDic = {
        "array" : array,
        "sql" : sql,
    }
    return typeDic[outType]()

parser = ArgumentParser()
parser.add_argument("-f", "--file", dest="file",
        help="file containing text to be converted", metavar="FILE")
parser.add_argument("-o", "--out", dest="output",
        help="output file", metavar="OUTPUT")
parser.add_argument("-t", "--type", dest="type",
        help="type of output, acceptable types are:\n" + types,
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
    file = open(filename,"r")
    holder = file.read()
    array = holder.split(spliter)

    finalString = ""
    for i in range(len(array)-2):
        finalString += outTypeOpening + array[i] + outTypeCloseing + ","
    finalString += outTypeOpening + array[len(array)-1] + outTypeCloseing + ","

    file = open(outputname, "w")
    file.write(finalString)
else:
    print filename + " doesn't exist or couldn't be accessed."
