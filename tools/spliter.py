
file = open("rawText.txt","r")

holder = file.read()

array = holder.split(' ')

finalString = ""
for i in range(len(array)-2):
    finalString += "\"" + array[i] + "\","
finalString += "\"" + array[len(array)-1] + "\","

file = open("resultText.txt", "w")
file.write(finalString)

