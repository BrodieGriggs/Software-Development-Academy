from io_tasks import *
from character import Goodie
from reading_writing_files import *

mario = Goodie("Mario", "100", "It's a me!")

print(mario.get_health())

print(read_from_file("file"))