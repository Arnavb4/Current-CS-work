import sys
file = sys.argv [1]

stripped_dates = []
comma_split = []
final_list = []
slash_full_year = []
comma_removed_final_list = []
final_sorted_list = []

with open(file) as f:
    for line in f:
        stripped_dates.append(str(line.strip()))

for each_date in stripped_dates:
    if "-" in each_date:
        final_list.append(each_date)
    elif "/" in each_date:
        split_date = []
        slash_full_year = []
        split_date = each_date.split("/")
        if int (split_date[2]) >= 22:
            slash_full_year = "19" + split_date [2]
        else:
            slash_full_year = "20" + split_date [2]
        if len(split_date [0]) == 1:
            slash_full_year = slash_full_year + "-0" + split_date [0]
        else:
            slash_full_year = slash_full_year + "-" + split_date [0]
        if len (split_date [1]) == 1:
            slash_full_year = slash_full_year + "-0" + split_date [1]
        else:
            slash_full_year = slash_full_year + "-" + split_date [1]
        final_list.append(slash_full_year)
    elif "," in each_date:
        comma_splitted_dates = []
        comma_reformatting = ""
        months_of_year = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        comma_splitted_date = each_date.split(" ")
        if len(comma_splitted_date [1]) == 2:
            if ((months_of_year.index (comma_splitted_date[0])) + 1) > 9:
                comma_reformatting = comma_reformatting + comma_splitted_date [2] + "-" + str ((months_of_year.index (comma_splitted_date[0])) + 1) + "-0" + comma_splitted_date [1] 
            else:
                comma_reformatting = comma_reformatting + comma_splitted_date [2] + "-0" + str ((months_of_year.index (comma_splitted_date[0])) + 1) + "-0" + comma_splitted_date [1]
        else:
            if ((months_of_year.index (comma_splitted_date[0])) + 1) > 9:
                comma_reformatting = comma_reformatting + comma_splitted_date [2] + "-" + str ((months_of_year.index (comma_splitted_date[0])) + 1) + "-" + comma_splitted_date [1]
            else:
                 comma_reformatting = comma_reformatting + comma_splitted_date [2] + "-0" + str ((months_of_year.index (comma_splitted_date[0])) + 1) + "-" + comma_splitted_date [1]
        final_list.append(comma_reformatting)

for final_date in final_list:
    if "," in final_date:
        x = final_date.replace (",", "")
        comma_removed_final_list.append(x)
        x = ""
    else:
        comma_removed_final_list.append(final_date)

final_sorted_list = sorted(comma_removed_final_list)

with open("sorted_dates.txt", "w") as final:
    for date in final_sorted_list:
        final.write (date + "\n")

