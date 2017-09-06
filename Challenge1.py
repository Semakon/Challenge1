xs = []
ys = []
zs = []

# [timestamp, ??, x, y, z, \n]
with open("Accelerometer.txt") as accel:
    for line in accel:
        line = line.split(',')
        xs.append(float(line[2]))
        ys.append(float(line[3]))
        zs.append(float(line[4]))


print(ys)


a = 0.8
g = 0.9
for i in range(len(ys)):
    ys[i] -= a * g + (1 - a) * ys[i]


print(ys)
