def euklid(a, b):
    while b != 0:
        a, b = b, a % b
    return a

zahl1 = int(input("Geben Sie die erste Zahl ein: "))
zahl2 = int(input("Geben Sie die zweite Zahl ein: "))

print("Der ggT von", zahl1, "und", zahl2, "ist", euklid(zahl1, zahl2))
