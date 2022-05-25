import os


def read_from_file(filename):
    name = filename + ".txt"
    file = open(name, "r")
    result = ""
    for line in file.read():
        result += line

    return result


def write_to_file(filename, text):
    name = filename + ".txt"
    file = open(name, "w")
    file.write(text)
