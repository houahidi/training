
from points import Point
from rectangles import Rectangle
import pickle

try :
    print "ouverture en mode lecture du fichier cercles.py"
    file = open('cercles.py','r')
    for ligne in file:
        print ligne
    file.close()
except IOError as e:
    print "erreur : ",e

# exemples avec le module pickle : sauver/ restituer des objets
try :
    print " sauver des objets"
    POINT1 = Point(3,5)
    REC1 = Rectangle(POINT1, 4, 5)
    file = open("formes.txt", 'w')
    pickle.dump(POINT1, file)
    pickle.dump(REC1, file)
    file.close()
except IOError as e:
    print e

try :
    print " restituer les objets"
    file = open("formes.txt", 'r')
    while True:
        obj = pickle.load(file)
        print obj
except IOError as e:
    print "erreur:",e
except EOFError as e:
    print "fin",e
finally:
    file.close()
