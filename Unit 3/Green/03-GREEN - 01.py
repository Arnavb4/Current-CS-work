import sys
file = sys.argv[1]

raw_data = []
floated_data = []
sorted_data = []
with open(file) as f:
    for i in f:
        raw_data.append(i.strip())
    
for i in raw_data:
    floated_data.append (float (i))

sorted_data = sorted(floated_data)

def median (x):
    if len(x) % 2 == 1:
        return (x[int ((len(x) - 1) / 2)])
    else:
        return float (x[int((len(x) / 2) - 1)] + x[int(len(x) / 2)]) / 2

def first_quartile(x):
    if len (x) % 2 == 1:
        return median(sorted_data [0: ((len(x) // 2))])
    else:
        return median (sorted_data[0: int((len(x) / 2))])

def third_quartile(x):
    if len (x) % 2 == 1:
        return median (sorted_data [((len(x) // 2)) + 1 : (len(x))])
    else:
        return median (sorted_data [int ((len(x) / 2)): int (len(x))])

def five_number_summary_and_average (sorted_data):
    print("Average:", float (sum(sorted_data) / len(sorted_data)))
    print("Minimum:", sorted_data [0])
    print("First Quartile:", first_quartile(sorted_data))
    print("Median:", median(sorted_data))
    print("Third Quartile:", third_quartile(sorted_data))
    print("Maximum:", sorted_data [len(sorted_data) - 1])
    print("Sorted list:", sorted_data)

five_number_summary_and_average(sorted_data)


    


 